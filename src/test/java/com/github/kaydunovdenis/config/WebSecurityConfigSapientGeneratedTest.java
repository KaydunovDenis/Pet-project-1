package com.github.kaydunovdenis.config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import com.sap.cloud.security.xsuaa.XsuaaServiceConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

class WebSecurityConfigSapientGeneratedTest {



  private AutoCloseable autoCloseableMocks;

  @InjectMocks()
  private WebSecurityConfig target;

  @AfterEach()
  public void afterTest() throws Exception {
    if (autoCloseableMocks != null) {
      autoCloseableMocks.close();
    }
  }

  //Sapient generated method id: ${9864b6d8-8a5d-3745-b8d3-5ca98b714c60}
  @Test()
  void filterChainTest() throws Exception {
    HttpSecurity httpMock = mock(HttpSecurity.class);
    SessionManagementConfigurer<HttpSecurity> sessionManagementConfigurerMock = mock(SessionManagementConfigurer.class);
    doReturn(sessionManagementConfigurerMock).when(httpMock).sessionManagement();
    SessionManagementConfigurer sessionManagementConfigurerMock2 = mock(SessionManagementConfigurer.class);
    doReturn(sessionManagementConfigurerMock2).when(sessionManagementConfigurerMock)
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    HttpSecurity httpSecurityMock = mock(HttpSecurity.class);
    doReturn(httpSecurityMock).when(sessionManagementConfigurerMock2).and();
    ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry
        expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock =
        mock(ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry.class);
    doReturn(expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock).when(httpSecurityMock)
        .authorizeRequests();
    ExpressionUrlAuthorizationConfigurer.AuthorizedUrl expressionUrlAuthorizationConfigurerAuthorizedUrlMock =
        mock(ExpressionUrlAuthorizationConfigurer.AuthorizedUrl.class);
    String[] stringArray = new String[] {"/**"};
    doReturn(expressionUrlAuthorizationConfigurerAuthorizedUrlMock).when(
        expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock).antMatchers(stringArray);
    ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry
        expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock2 =
        mock(ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry.class);
    doReturn(expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock2).when(
        expressionUrlAuthorizationConfigurerAuthorizedUrlMock).authenticated();
    ExpressionUrlAuthorizationConfigurer.AuthorizedUrl expressionUrlAuthorizationConfigurerAuthorizedUrlMock2 =
        mock(ExpressionUrlAuthorizationConfigurer.AuthorizedUrl.class);
    doReturn(expressionUrlAuthorizationConfigurerAuthorizedUrlMock2).when(
        expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock2).anyRequest();
    ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry
        expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock3 =
        mock(ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry.class);
    doReturn(expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock3).when(
        expressionUrlAuthorizationConfigurerAuthorizedUrlMock2).denyAll();
    HttpSecurity httpSecurityMock2 = mock(HttpSecurity.class);
    doReturn(httpSecurityMock2).when(expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock3).and();
    OAuth2ResourceServerConfigurer<HttpSecurity> oAuth2ResourceServerConfigurerMock =
        mock(OAuth2ResourceServerConfigurer.class);
    doReturn(oAuth2ResourceServerConfigurerMock).when(httpSecurityMock2).oauth2ResourceServer();
    OAuth2ResourceServerConfigurer.JwtConfigurer oAuth2ResourceServerConfigurerJwtConfigurerMock =
        mock(OAuth2ResourceServerConfigurer.JwtConfigurer.class);
    doReturn(oAuth2ResourceServerConfigurerJwtConfigurerMock).when(oAuth2ResourceServerConfigurerMock).jwt();
    OAuth2ResourceServerConfigurer.JwtConfigurer oAuth2ResourceServerConfigurerJwtConfigurerMock2 =
        mock(OAuth2ResourceServerConfigurer.JwtConfigurer.class);
    Converter converterMock = mock(Converter.class);
    doReturn(oAuth2ResourceServerConfigurerJwtConfigurerMock2).when(oAuth2ResourceServerConfigurerJwtConfigurerMock)
        .jwtAuthenticationConverter(converterMock);
    SecurityFilterChain securityFilterChainMock = mock(SecurityFilterChain.class);
    doReturn(securityFilterChainMock).when(httpMock).build();
    target = spy(new WebSecurityConfig());
    autoCloseableMocks = MockitoAnnotations.openMocks(this);
    doReturn(converterMock).when(target).getJwtAuthoritiesConverter();
    SecurityFilterChain result = target.filterChain(httpMock);
    assertAll("result", () -> {
      assertThat(result, equalTo(securityFilterChainMock));
      verify(httpMock).sessionManagement();
      verify(sessionManagementConfigurerMock).sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      verify(sessionManagementConfigurerMock2).and();
      verify(httpSecurityMock).authorizeRequests();
      verify(expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock).antMatchers(stringArray);
      verify(expressionUrlAuthorizationConfigurerAuthorizedUrlMock).authenticated();
      verify(expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock2).anyRequest();
      verify(expressionUrlAuthorizationConfigurerAuthorizedUrlMock2).denyAll();
      verify(expressionUrlAuthorizationConfigurerExpressionInterceptUrlRegistryMock3).and();
      verify(httpSecurityMock2).oauth2ResourceServer();
      verify(oAuth2ResourceServerConfigurerMock).jwt();
      verify(oAuth2ResourceServerConfigurerJwtConfigurerMock).jwtAuthenticationConverter(converterMock);
      verify(httpMock).build();
      verify(target).getJwtAuthoritiesConverter();
    });
  }

}
