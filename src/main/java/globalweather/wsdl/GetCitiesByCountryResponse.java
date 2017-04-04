package globalweather.wsdl;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"getCitiesByCountryResult"})
@XmlRootElement(name="GetCitiesByCountryResponse")
public class GetCitiesByCountryResponse
{

  @XmlElement(name="GetCitiesByCountryResult")
  protected String getCitiesByCountryResult;

  public String getGetCitiesByCountryResult()
  {
    return this.getCitiesByCountryResult;
  }

  public void setGetCitiesByCountryResult(String value)
  {
    this.getCitiesByCountryResult = value;
  }
}