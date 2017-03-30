package au.vha.myvfgold.handler;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

import au.vha.myvfgold.model.GetInfoRequest;

public class FetchInfoHandlerTest {

	 private Context createContext() {
	        TestContext ctx = new TestContext();

	        // TODO: customize your context here if needed.
	        ctx.setFunctionName("LambdaForm");

	        return ctx;
	    }
	 
	 @Test
	 public void handleRequestTest(){
		 FetchInfoHandler fetchInfoHandler = new FetchInfoHandler();
		  Context ctx = createContext();
		 fetchInfoHandler.handleRequest(getRequest(), ctx);
	 }
	 
	 public GetInfoRequest getRequest(){
		 GetInfoRequest getInfoRequest = new GetInfoRequest();
		 getInfoRequest.setMsisdn("000");
		return getInfoRequest;
	 }
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}

}
