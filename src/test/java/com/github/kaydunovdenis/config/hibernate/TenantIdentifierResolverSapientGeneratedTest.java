package com.github.kaydunovdenis.config.hibernate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.sap.cloud.sdk.cloudplatform.tenant.exception.TenantAccessException;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.context.SecurityContext;

class TenantIdentifierResolverSapientGeneratedTest {

  //Sapient generated method id: ${81ff7a36-eb7a-3772-ab81-754a9c000ae8}
  @Test()
  void resolveCurrentTenantIdentifierWhenObjectsNotNonNullAuthToken() {
    /* Branches:* (Objects.nonNull(authToken)) : false*/
    TenantIdentifierResolver target = new TenantIdentifierResolver();
    String result = target.resolveCurrentTenantIdentifier();
    assertAll("result", () -> assertThat(result, is(nullValue())));
  }

  //Sapient generated method id: ${7c56b19e-84f2-3030-bf3c-9bae370ea82d}
  @Test()
  void resolveCurrentTenantIdentifierWhenCaughtTenantAccessException() {
    /* Branches:* (Objects.nonNull(authToken)) : false* (catch-exception (TenantAccessException)) : true*/

    //Given
    TenantIdentifierResolver target = new TenantIdentifierResolver();
    SecurityContext securityContextMock = mock(SecurityContext.class);
    TenantAccessException tenantAccessExceptionMock = mock(TenantAccessException.class);
    when(securityContextMock.getAuthentication()).thenThrow(tenantAccessExceptionMock);

    //When
    String result = target.resolveCurrentTenantIdentifier();

    //then
    assertAll("result", () -> {
      assertThat(result, is(nullValue()));
    });
  }

  //Sapient generated method id: ${f174460b-7e1d-3d14-90ef-3d878fd9557b}
  @Test()
  void validateExistingCurrentSessionsTest() {
    TenantIdentifierResolver target = new TenantIdentifierResolver();
    boolean result = target.validateExistingCurrentSessions();
    assertAll("result", () -> assertThat(result, equalTo(Boolean.TRUE)));
  }
}
