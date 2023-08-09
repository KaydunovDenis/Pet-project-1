package com.github.kaydunovdenis.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

  public void subscribe(final String tenantId) {
    Logger logger = Logger.getLogger(TenantService.class.getName());
    logger.log(Level.ALL, "ERROR OF SUBSCRIBE");
    //todo implement
  }

  public void unsubscribe(final String tenantId) {
    //todo implement
  }
}
