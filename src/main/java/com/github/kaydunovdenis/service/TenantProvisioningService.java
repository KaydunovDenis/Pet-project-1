package com.github.kaydunovdenis.service;

public interface TenantProvisioningService {

  void subscribeTenant(String tenantId);

  void unsubscribeTenant(String tenantId);

}
