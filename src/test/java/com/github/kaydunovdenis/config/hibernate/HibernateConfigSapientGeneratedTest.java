package com.github.kaydunovdenis.config.hibernate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import javax.sql.DataSource;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.junit.jupiter.api.Test;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

class HibernateConfigSapientGeneratedTest {

  @Test()
  void entityManagerFactoryTest() {
    //Given
    HibernateConfig target = spy(new HibernateConfig());
    JpaVendorAdapter jpaVendorAdapterMock = mock(JpaVendorAdapter.class);
    doReturn(jpaVendorAdapterMock).when(target).jpaVendorAdapter();

    DataSource dataSourceMock = mock(DataSource.class);
    MultiTenantConnectionProvider multiTenantConnectionProviderMock = mock(MultiTenantConnectionProvider.class);
    CurrentTenantIdentifierResolver currentTenantIdentifierResolverMock = mock(CurrentTenantIdentifierResolver.class);

    //When
    LocalContainerEntityManagerFactoryBean resultEm =
        target.entityManagerFactory(dataSourceMock, multiTenantConnectionProviderMock,
            currentTenantIdentifierResolverMock);

    //Then
    LocalContainerEntityManagerFactoryBean expectedEm = new LocalContainerEntityManagerFactoryBean();
    expectedEm.setJpaPropertyMap(getExpectedProps(multiTenantConnectionProviderMock, currentTenantIdentifierResolverMock));
    expectedEm.setJpaVendorAdapter(jpaVendorAdapterMock);

    assertAll("result", () -> {
      assertEquals(resultEm.getJpaPropertyMap(), expectedEm.getJpaPropertyMap());
      assertEquals(resultEm.getJpaVendorAdapter(), expectedEm.getJpaVendorAdapter());
      verify(target).jpaVendorAdapter();
    });
  }

  private HashMap<String, Object> getExpectedProps(
      MultiTenantConnectionProvider multiTenantConnectionProviderMock,
      CurrentTenantIdentifierResolver currentTenantIdentifierResolverMock) {

    HashMap<String, Object> jpaProperties = new HashMap<>();
    jpaProperties.put("hibernate.multiTenancy", MultiTenancyStrategy.SCHEMA);
    jpaProperties.put("hibernate.multi_tenant_connection_provider", multiTenantConnectionProviderMock);
    jpaProperties.put("hibernate.tenant_identifier_resolver", currentTenantIdentifierResolverMock);
    jpaProperties.put("hibernate.format_sql", true);
    return jpaProperties;
  }

  //Sapient generated method id: ${e17d2857-9d44-3ba0-8f40-645f8c197452}
  @Test()
  void jpaVendorAdapterTest() {
    HibernateConfig target = new HibernateConfig();
    JpaVendorAdapter result = target.jpaVendorAdapter();
    assertTrue(result instanceof HibernateJpaVendorAdapter);
  }
}
