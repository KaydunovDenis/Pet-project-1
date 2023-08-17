package com.github.kaydunovdenis.controller;

import com.sap.cloud.security.xsuaa.token.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "helloworld")
public class HelloController {

  @GetMapping(path = "")
  public ResponseEntity<String> readAll(@AuthenticationPrincipal Token token) {
    return new ResponseEntity<>("Hello Denis Kaydunov!", HttpStatus.OK);
  }

}
