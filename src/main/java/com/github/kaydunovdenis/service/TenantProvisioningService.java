package com.github.kaydunovdenis.service;

import java.sql.SQLException;
import liquibase.exception.LiquibaseException;

public interface TenantProvisioningService {

  void subscribeTenant(String tenantId) throws SQLException, LiquibaseException;

  void unsubscribeTenant(String tenantId) throws SQLException;

}
