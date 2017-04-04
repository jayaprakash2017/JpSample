package com.demo.weather;


import globalweather.wsdl.GetCitiesByCountry;
import globalweather.wsdl.GetCitiesByCountryResponse;
import globalweather.wsdl.ObjectFactory;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

public class ServiceInvoke extends WebServiceGatewaySupport
{
  public String test(String arg)
  {
    GetCitiesByCountry getCitiesByCountry = new ObjectFactory().createGetCitiesByCountry();
    getCitiesByCountry.setCountryName("India");

    GetCitiesByCountryResponse getCitiesByCountryResponse = (GetCitiesByCountryResponse)getWebServiceTemplate().marshalSendAndReceive("http://www.webservicex.com/globalweather.asmx", getCitiesByCountry, new WebServiceMessageCallback()
    {
      public void doWithMessage(WebServiceMessage message) {
        ((SoapMessage)message).setSoapAction("http://www.webserviceX.NET/GetCitiesByCountry");
      }
    });
    System.out.println("Output Here....." + getCitiesByCountryResponse.getGetCitiesByCountryResult());
    return "Output Here....." + getCitiesByCountryResponse.getGetCitiesByCountryResult();
  }
}