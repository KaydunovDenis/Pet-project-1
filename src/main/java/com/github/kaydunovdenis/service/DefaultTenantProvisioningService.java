package com.github.kaydunovdenis.service;

import com.github.kaydunovdenis.config.hibernate.SchemaPerTenantConnectionProvider;
import com.github.kaydunovdenis.util.TenantUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.regex.Pattern;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DefaultTenantProvisioningService implements TenantProvisioningService {

  @Value("${spring.liquibase.change-log}")
  public static String liquibasePath;
  private static final Pattern TENANT_PATTERN = Pattern.compile("[-\\w]+");
  private final SchemaPerTenantConnectionProvider provider;

  @Autowired
  public DefaultTenantProvisioningService(SchemaPerTenantConnectionProvider provider) {
    this.provider = provider;
  }

  public void subscribeTenant(final String tenantId) throws SQLException, LiquibaseException {
    Validate.isTrue(isValidTenantId(tenantId), String.format("Invalid tenant id: \"%s\"", tenantId));
    String schemaName = TenantUtil.createSchemaName(tenantId);

    try (
        Connection connection = provider.getConnection(tenantId);
        Statement statement = connection.createStatement()
    ) {
      statement.execute(String.format("CREATE SCHEMA IF NOT EXISTS \"%s\"", schemaName));
      log.info("SCHEMA with name: {} was created", schemaName);
      runLiquibaseScript(provider.getConnection(tenantId));
    } catch (Exception e) {
      log.error("TenantProvisioningService: Tenant subscription failed for {}.", tenantId, e);
      throw e;
    }
  }

  private void runLiquibaseScript(Connection connection) throws LiquibaseException, SQLException {
    Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
    Liquibase liquibase = new Liquibase(liquibasePath, new ClassLoaderResourceAccessor(), database);
    liquibase.update(new Contexts());
    log.info("Initial script for schema: {} was performed successfully", connection.getSchema());
    connection.commit();
  }

  public void unsubscribeTenant(final String tenantId) throws SQLException {
    try {
      Validate.isTrue(isValidTenantId(tenantId), String.format("Invalid tenant id: \"%s\"", tenantId));
      final String schemaName = TenantUtil.createSchemaName(tenantId);
      final Connection connection = provider.getAnyConnection();
      try (Statement statement = connection.createStatement()) {
        statement.execute(String.format("DROP SCHEMA IF EXISTS \"%s\" CASCADE", schemaName));
      }
      log.info("SCHEMA with name: {} was deleted successfully", schemaName);
    } catch (Exception e) {
      log.error("Tenant unsubscription failed for {}.", tenantId, e);
      throw e;
    }
  }

  private boolean isValidTenantId(String tenantId) {
    return Objects.nonNull(tenantId) && TENANT_PATTERN.matcher(tenantId).matches();
  }
}