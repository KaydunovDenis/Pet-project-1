package com.github.kaydunovdenis.config.hibernate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.kaydunovdenis.util.TenantUtil;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;

class SchemaPerTenantConnectionProviderSapientGeneratedTest {

  //Sapient generated method id: ${26c599f7-8ee7-30af-979c-0ef50400b80d}
  @Test()
  void getAnyConnectionTest() throws SQLException {
    //Given
    DataSource dataSourceMock = mock(DataSource.class);

    //my settings
    Connection connection = mock(Connection.class);
    when(dataSourceMock.getConnection()).thenReturn(connection);

    SchemaPerTenantConnectionProvider target = new SchemaPerTenantConnectionProvider(dataSourceMock);

    //When
    Connection result = target.getAnyConnection();

    //Then
    assertAll("result", () -> assertThat(result, is(notNullValue())));
  }

  //Sapient generated method id: ${9e8421bd-7636-3aa3-a9cd-9222629eac74}
  @Test()
  void releaseAnyConnectionTest() throws SQLException {
    DataSource dataSourceMock = mock(DataSource.class);
    SchemaPerTenantConnectionProvider target = new SchemaPerTenantConnectionProvider(dataSourceMock);
    Connection connectionMock = mock(Connection.class);
    target.releaseAnyConnection(connectionMock);
    verify(connectionMock).close();
  }

  //Sapient generated method id: ${6d1e515d-b7ec-358a-8f3f-35be0793124a}
  @Test()
  void getConnectionTest() throws SQLException {
    // Create a mock Connection object
    Connection mockConnection = mock(Connection.class);

    // Create an instance of YourClass
    DataSource dataSource = mock(DataSource.class);
    SchemaPerTenantConnectionProvider target = new SchemaPerTenantConnectionProvider(dataSource);

    // Set up test data
    String tenantIdentifier = "exampleTenant";

    // Set up the expected schema name
    String expectedSchemaName = TenantUtil.createSchemaName(tenantIdentifier);

    // Mock the getAnyConnection() method to return the mockConnection
    when(target.getAnyConnection()).thenReturn(mockConnection);

    // Call the getConnection method
    Connection result = target.getConnection(tenantIdentifier);

    // Verify that the setSchema method is called with the expected schema name
      verify(mockConnection).setSchema(expectedSchemaName);

    // Verify that the result is the same as the mockConnection
    assertEquals(mockConnection, result);
  }

  //Sapient generated method id: ${3b85bf95-b94e-33d7-a7f2-ab05084e3cd0}
  @Test()
  void supportsAggressiveReleaseTest() {
    DataSource dataSourceMock = mock(DataSource.class);
    SchemaPerTenantConnectionProvider target = new SchemaPerTenantConnectionProvider(dataSourceMock);
    boolean result = target.supportsAggressiveRelease();
    assertAll("result", () -> assertThat(result, equalTo(Boolean.TRUE)));
  }

  //Sapient generated method id: ${ff3c3d06-009f-3bb0-ab1a-8cd69aa4e2ba}
  @Test()
  void isUnwrappableAsTest() {
    DataSource dataSourceMock = mock(DataSource.class);
    SchemaPerTenantConnectionProvider target = new SchemaPerTenantConnectionProvider(dataSourceMock);
    boolean result = target.isUnwrappableAs(Object.class);
    assertAll("result", () -> assertThat(result, equalTo(Boolean.FALSE)));
  }

  //Sapient generated method id: ${c9caae7f-b2ba-380a-8b24-210edca9aa59}
  @Test()
  void unwrapTest() {
    DataSource dataSourceMock = mock(DataSource.class);
    SchemaPerTenantConnectionProvider target = new SchemaPerTenantConnectionProvider(dataSourceMock);
    Object result = target.unwrap(Object.class);
    assertAll("result", () -> assertThat(result, is(nullValue())));
  }
}
