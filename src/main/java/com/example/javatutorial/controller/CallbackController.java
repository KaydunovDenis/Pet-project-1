package com.example.javatutorial.controller;

import com.example.javatutorial.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/callback/tenant")
public class CallbackController {

  private final TenantService tenantService;

  @Autowired
  public CallbackController(TenantService tenantService) {
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

  private String generateTenantURL(String tenantId) {
    //todo replace on variable for "approuter-helloworld.cfapps.us10-001.hana.ondemand.com"
    return "https://" + tenantId + "-approuter-helloworld.cfapps.us10-001.hana.ondemand.com";
  }

}
