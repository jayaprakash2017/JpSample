package com.demo.weather;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;

@Component
@Scope("prototype")
public class RequestComponent
{
  static Log log = LogFactory.getLog(RequestComponent.class);

  @Autowired
  ApplicationContext applicationContext;

  @Autowired
  Environment environment;

  @Autowired
  CheckBean checkBean;

  @Value("${configtest.value}")
  private String configValue;

  public String processRequest(String name, Context context) { log.info("In the hello function");
    log.info("Test value here = " + this.configValue);
    log.info("env value = " + this.environment.getProperty("configtest.value"));
    String temp = this.checkBean.getValue();
    return String.format("Hello %s %s :-)", new Object[] { temp, name });
  }
}