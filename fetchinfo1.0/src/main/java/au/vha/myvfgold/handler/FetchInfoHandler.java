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
    public String handleRequest(GetInfoRequest getInfoRequest, Context arg1)
    {
        String responseJson = null;
        RequestValidator requestValidator = new RequestValidator();
        if(requestValidator.isValidMsisdn(getInfoRequest.getMsisdn()))
        {
            GetInfoResponse getInfoResponse = new GetInfoResponse();
            getInfoResponse.setMsisdn(getInfoRequest.getMsisdn());
            getInfoResponse.setName("Lamda POST Tester update 2");
            getInfoResponse.setVoiceUsage(new BigDecimal(100));
            getInfoResponse.setDataUsage(new BigDecimal(100.2D));
            ObjectMapper mapper = new ObjectMapper();
            try
            {
                responseJson = mapper.writeValueAsString(getInfoResponse);
            }
            catch(JsonProcessingException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        } else
        {
            responseJson = "{\"statusCode\":100,\"statusMessage\":\"Invalid Msisdn\"}";
        }
        return responseJson;
    }

//    public String handleRequest(Object getInfoRequest1, Context arg1)
//    {
//        String responseJson = null;
//        RequestValidator requestValidator = new RequestValidator();
//        GetInfoRequest getInfoRequest = (GetInfoRequest) getInfoRequest1;
//        if(requestValidator.isValidMsisdn(getInfoRequest.getMsisdn()))
//        {
//            GetInfoResponse getInfoResponse = new GetInfoResponse();
//            getInfoResponse.setMsisdn(getInfoRequest.getMsisdn());
//            getInfoResponse.setName("Lamda POST Tester");
//            getInfoResponse.setVoiceUsage(new BigDecimal(100));
//            getInfoResponse.setDataUsage(new BigDecimal(100.2D));
//            ObjectMapper mapper = new ObjectMapper();
//            try
//            {
//                responseJson = mapper.writeValueAsString(getInfoResponse);
//            }
//            catch(JsonProcessingException e)
//            {
//                e.printStackTrace();
//            }
//            catch(IOException e)
//            {
//                e.printStackTrace();
//            }
//        } else
//        {
//            responseJson = "{\"statusCode\":100,\"statusMessage\":\"Invalid Msisdn\"}";
//        }
//        return responseJson;
//    }


}
