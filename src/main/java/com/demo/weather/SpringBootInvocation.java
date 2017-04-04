package com.demo.weather;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringBootInvocation
{
  private ApplicationContext applicationContext;

  public void run()
  {
    String[] args = new String[0];
    this.applicationContext = SpringApplication.run(SpringBootInvocation.class, args);
  }

  public ApplicationContext getApplicationContext() {
    return this.applicationContext;
  }
  @Bean
  public Jaxb2Marshaller marshaller() { Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("globalweather.wsdl");
    return marshaller; }

  @Bean
  public ServiceInvoke serviceInvoke(Jaxb2Marshaller marshaller) {
    ServiceInvoke client = new ServiceInvoke();
    client.setDefaultUri("http://www.webservicex.com/globalweather.asmx");
    client.setMarshaller(marshaller());
    client.setUnmarshaller(marshaller);
    return client;
  }
}