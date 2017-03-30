package au.vha.myvfgold.util;

public class RequestValidator {

	  public boolean isValidMsisdn(String msisdn)
	  {
	    Boolean validationResult = Boolean.valueOf(false);
	    String regex = "\\d+";
	    if (msisdn == null) {
	      return false;
	    }
	    validationResult = Boolean.valueOf(msisdn.matches(regex));
	    
	    return validationResult.booleanValue();
	  }
}
