package com.github.kaydunovdenis.config.hibernate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    TenantIdentifierResolver target = new TenantIdentifierResolver();
    SecurityContext securityContextMock = mock(SecurityContext.class);
    TenantAccessException tenantAccessExceptionMock = mock(TenantAccessException.class);
    doThrow(tenantAccessExceptionMock).when(securityContextMock).getAuthentication();
    String result = target.resolveCurrentTenantIdentifier();
    assertAll("result", () -> {
      assertThat(result, is(nullValue()));
      verify(securityContextMock).getAuthentication();
    });
  }
}
