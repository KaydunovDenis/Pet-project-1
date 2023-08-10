package com.github.kaydunovdenis.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
class TenantUtilSapientGeneratedTest {

  //Sapient generated method id: ${a464d56b-921d-3ff9-a93f-022331c2b55f}
  @Test()
  void createSchemaNameTest() {
    String result = TenantUtil.createSchemaName("A");
    assertAll("result", () -> assertThat(result, equalTo("tenant_A")));
  }
}
