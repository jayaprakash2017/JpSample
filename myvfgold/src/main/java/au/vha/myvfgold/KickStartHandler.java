package au.vha.myvfgold;

import java.util.Calendar;
import java.util.Date;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class KickStartHandler implements RequestHandler<String, String> {
    public String handleRequest(String input, Context context) {
    	Date date = new Date();
        context.getLogger().log("AWS Request ID: " + context.getAwsRequestId());
        context.getLogger().log("Input: " + input + " at " + Calendar.getInstance().getTimeInMillis());
        return "Cheers. ...We have started....CI/CD done....WebHook test 29Mar Hook 3................----> "+date;
    }
}
