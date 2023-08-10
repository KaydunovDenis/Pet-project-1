package com.github.kaydunovdenis.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.github.kaydunovdenis.exception.NotAuthorizedException;
import com.sap.cloud.security.xsuaa.token.Token;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class MainControllerSapientGeneratedTest {

  //Sapient generated method id: ${9f578ec9-f477-361a-a961-fe48941b0212}
  @Test()
  void readAllWhenTokenGetAuthoritiesNotContainsNewSimpleGrantedAuthorityDisplayThrowsNotAuthorizedException() {
    /* Branches:* (!token.getAuthorities().contains(new SimpleGrantedAuthority("Display"))) : true*/
    Token tokenMock = mock(Token.class);
    Collection<GrantedAuthority> collection = new ArrayList<>();
    doReturn(collection).when(tokenMock).getAuthorities();
    MainController target = new MainController();
    NotAuthorizedException notAuthorizedException =
        new NotAuthorizedException("This operation requires \"Display\" scope");
    final NotAuthorizedException result = assertThrows(NotAuthorizedException.class, () -> {
      target.readAll(tokenMock);
    });
    assertAll("result", () -> {
      assertThat(result, is(notNullValue()));
      assertThat(result.getMessage(), equalTo(notAuthorizedException.getMessage()));
      verify(tokenMock).getAuthorities();
    });
  }

  //Sapient generated method id: ${ba655b76-0ae7-38ef-92d6-8990dcca5f88}
  @Test()
  void readAllWhenTokenGetAuthoritiesContainsNewSimpleGrantedAuthorityDisplay() {
    /* Branches:* (!token.getAuthorities().contains(new SimpleGrantedAuthority("Display"))) : false*/
    Token tokenMock = mock(Token.class);
    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Display");
    Collection<GrantedAuthority> collection = new ArrayList<>();
    collection.add(simpleGrantedAuthority);
    doReturn(collection).when(tokenMock).getAuthorities();
    MainController target = new MainController();
    ResponseEntity<String> result = target.readAll(tokenMock);
    ResponseEntity<String> responseEntity = new ResponseEntity<>("Hello World!", HttpStatus.OK);
    assertAll("result", () -> {
      assertThat(result, equalTo(responseEntity));
      verify(tokenMock).getAuthorities();
    });
  }
}
