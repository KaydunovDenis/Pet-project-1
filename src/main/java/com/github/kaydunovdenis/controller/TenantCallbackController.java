package com.github.kaydunovdenis.controller;

import com.github.kaydunovdenis.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "callback/v1.0/tenants")
public class TenantCallbackController {

  private static final String APP_ROUTER_DOMAIN_NAME = "-approuter-helloworld.cfapps.us10-001.hana.ondemand.com";
  private static final String HTTPS = "https://";
  private final TenantService tenantService;

  @Autowired
  public TenantCallbackController(TenantService tenantService) {
    this.tenantService = tenantService;
  }

  @PutMapping("/{tenantId}")
  public ResponseEntity<String> subscribeTenant(@PathVariable(value = "tenantId") String tenantId) {
    tenantService.subscribe(tenantId);
    return ResponseEntity.ok(generateTenantURL(tenantId));
  }

  @DeleteMapping("/{tenantId}")
  public ResponseEntity<String> unsubscribeTenant(@PathVariable(value = "tenantId") String tenantId) {
    tenantService.unsubscribe(tenantId);
    return ResponseEntity.ok(generateTenantURL(tenantId));
  }


  //todo subdomen
   private String generateTenantURL(String tenantId) {
    //todo replace on variable for "approuter-helloworld.cfapps.us10-001.hana.ondemand.com"
    return HTTPS + tenantId + APP_ROUTER_DOMAIN_NAME;
  }

}
