package com.github.kaydunovdenis.config.hibernate;


import static org.hibernate.cfg.Environment.FORMAT_SQL;
import static org.hibernate.cfg.Environment.MULTI_TENANT;
import static org.hibernate.cfg.Environment.MULTI_TENANT_CONNECTION_PROVIDER;
import static org.hibernate.cfg.Environment.MULTI_TENANT_IDENTIFIER_RESOLVER;

import com.github.kaydunovdenis.HelloWorldApplication;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class HibernateConfig {

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    return new HibernateJpaVendorAdapter();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                     MultiTenantConnectionProvider multiTenantConnectionProvider,
                                                                     CurrentTenantIdentifierResolver tenantIdentifierResolver) {
    final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPackagesToScan(HelloWorldApplication.class.getPackageName());
    em.setJpaVendorAdapter(this.jpaVendorAdapter());

    final Map<String, Object> jpaProperties = new HashMap<>();
    jpaProperties.put(MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
    jpaProperties.put(MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
    jpaProperties.put(MULTI_TENANT_IDENTIFIER_RESOLVER, tenantIdentifierResolver);
    jpaProperties.put(FORMAT_SQL, true);

    em.setJpaPropertyMap(jpaProperties);
    return em;
  }

}