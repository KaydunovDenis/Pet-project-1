package com.example.javatutorial.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CallbackController {

  @PutMapping("/callback/v1.0/tenants/*")
  public String putCallback(@RequestBody RequestBody requestBody) {
    String tenantAppURL = generateTenantAppURL(requestBody);
    return tenantAppURL;
  }

  @DeleteMapping("/callback/v1.0/tenants/*")
  public String deleteCallback(@RequestBody RequestBody requestBody) {
    String tenantAppURL = generateTenantAppURL(requestBody);
    return tenantAppURL;
  }

  private String generateTenantAppURL(RequestBody requestBody) {
    String consumerSubdomain = "your_subdomain"; // замените "your_subdomain" на соответствующую логику получения поддомена
    //todo replace on variable for "approuter-helloworld.cfapps.us10-001.hana.ondemand.com"
    String tenantAppURL = "https://" + consumerSubdomain + "-approuter-helloworld.cfapps.us10-001.hana.ondemand.com";
    return tenantAppURL;
  }

}
