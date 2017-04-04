package globalweather.wsdl;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"cityName", "countryName"})
@XmlRootElement(name="GetWeather")
public class GetWeather
{

  @XmlElement(name="CityName")
  protected String cityName;

  @XmlElement(name="CountryName")
  protected String countryName;

  public String getCityName()
  {
    return this.cityName;
  }

  public void setCityName(String value)
  {
    this.cityName = value;
  }

  public String getCountryName()
  {
    return this.countryName;
  }

  public void setCountryName(String value)
  {
    this.countryName = value;
  }
}