package globalweather.wsdl;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _String_QNAME = new QName("http://www.webserviceX.NET", "string");

  public GetWeather createGetWeather()
  {
    return new GetWeather();
  }

  public GetWeatherResponse createGetWeatherResponse()
  {
    return new GetWeatherResponse();
  }

  public GetCitiesByCountry createGetCitiesByCountry()
  {
    return new GetCitiesByCountry();
  }

  public GetCitiesByCountryResponse createGetCitiesByCountryResponse()
  {
    return new GetCitiesByCountryResponse();
  }

  @XmlElementDecl(namespace="http://www.webserviceX.NET", name="string")
  public JAXBElement<String> createString(String value)
  {
    return new JAXBElement(_String_QNAME, String.class, null, value);
  }
}