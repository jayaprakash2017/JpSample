package au.vha.myvfgold.handler;

import java.io.IOException;
import java.math.BigDecimal;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import au.vha.myvfgold.model.GetInfoRequest;
import au.vha.myvfgold.model.GetInfoResponse;
import au.vha.myvfgold.util.RequestValidator;

public class FetchInfoHandler implements RequestHandler<GetInfoRequest, String>
 {
    public String handleRequest(GetInfoRequest getInfoRequest, Context context)
    {
        String responseJson = null;
        RequestValidator requestValidator = new RequestValidator();
        if(requestValidator.isValidMsisdn(getInfoRequest.getMsisdn()))
        {
            GetInfoResponse getInfoResponse = new GetInfoResponse();
            getInfoResponse.setMsisdn(getInfoRequest.getMsisdn());
            getInfoResponse.setName("Lamda Test User 6 accessed on 04-Apr");
            getInfoResponse.setVoiceUsage(new BigDecimal(100));
            getInfoResponse.setDataUsage(new BigDecimal("100.20"));
            ObjectMapper mapper = new ObjectMapper();
            try
            {
                responseJson = mapper.writeValueAsString(getInfoResponse);
            }
            catch(JsonProcessingException je)
            {
            	 context.getLogger().log("Json Parsing Exception Occured {}"+ je);
            }
            catch(IOException ie)
            {
            	 context.getLogger().log("IOException Occured {}"+ ie);
            }
        } else
        {
            responseJson = "{\"statusCode\":100,\"statusMessage\":\"Invalid Msisdn\"}";
        }
        return responseJson;
    }


}
