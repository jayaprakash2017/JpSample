package com.demo.weather;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class WeatherHandler
  implements RequestHandler<String, String>
{
  public String handleRequest(String name, Context context)
  {
    SpringBootInvocation springBootInvocation = new SpringBootInvocation();
    springBootInvocation.run();
    return ((ServiceInvoke)springBootInvocation.getApplicationContext().getBean(ServiceInvoke.class)).test(name);
  }
}