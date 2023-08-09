package com.github.kaydunovdenis.controller;

import com.github.kaydunovdenis.service.TenantProvisioningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "callback/v1.0/tenants")
public class TenantProvisioningController {

  private static final String APP_ROUTER_DOMAIN_NAME = "-approuter-helloworld.cfapps.us10-001.hana.ondemand.com";
  private static final String HTTPS = "https://";

  private final TenantProvisioningService tenantProvisioningService;

  @Autowired
  public TenantProvisioningController(TenantProvisioningService tenantProvisioningService) {
    this.tenantProvisioningService = tenantProvisioningService;
  }

  @PutMapping("/{tenantId}")
  public ResponseEntity<String> subscribeTenant(@PathVariable(value = "tenantId") String tenantId) {
    log.info("Tenant callback service was called with method PUT for tenant {}.", tenantId);
    tenantProvisioningService.subscribeTenant(tenantId);
    return ResponseEntity.ok(generateTenantURL(tenantId));
  }

  @DeleteMapping("/{tenantId}")
  public ResponseEntity<String> unsubscribeTenant(@PathVariable(value = "tenantId") String tenantId) {
    log.info("Tenant callback service was called with method DELETE for tenant {}.", tenantId);
    tenantProvisioningService.unsubscribeTenant(tenantId);
    return ResponseEntity.ok(generateTenantURL(tenantId));
  }

   private String generateTenantURL(String tenantId) {
    return HTTPS + tenantId + APP_ROUTER_DOMAIN_NAME;
  }

}
