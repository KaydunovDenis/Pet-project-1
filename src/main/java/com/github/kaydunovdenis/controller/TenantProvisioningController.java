package com.github.kaydunovdenis.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.kaydunovdenis.service.TenantProvisioningService;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/callback/v1.0/tenants")
public class TenantProvisioningController {

  private static final String APP_ROUTER_DOMAIN_NAME = "-approuter-helloworld.cfapps.us10-001.hana.ondemand.com";

  private static final String HTTPS = "https://";

  private final TenantProvisioningService tenantProvisioningService;

  @Autowired
  public TenantProvisioningController(TenantProvisioningService tenantProvisioningService) {
    this.tenantProvisioningService = tenantProvisioningService;
  }

  @PutMapping("/{tenantId}")
  public ResponseEntity<String> subscribeTenant(@RequestBody JsonNode requestBody,
                                                @PathVariable(value = "tenantId") String tenantId) {

    log.info("Tenant callback service was called with method PUT for tenant {}.", tenantId);
    String subscribedSubdomain = requestBody.get("subscribedSubdomain").asText();
    tenantProvisioningService.subscribeTenant(tenantId);
    return ResponseEntity.ok(generateTenantURL(subscribedSubdomain));
  }

  @DeleteMapping("/{tenantId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Void> unsubscribeTenant(@PathVariable(value = "tenantId") String tenantId) throws SQLException {
    log.info("Tenant callback service was called with method DELETE for tenant {}.", tenantId);
    tenantProvisioningService.unsubscribeTenant(tenantId);
    return ResponseEntity.ok().build();
  }

  private String generateTenantURL(String subscribedSubdomain) {
    return HTTPS + subscribedSubdomain + APP_ROUTER_DOMAIN_NAME;
  }
}
