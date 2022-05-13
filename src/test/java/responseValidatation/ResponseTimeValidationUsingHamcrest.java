package responseValidatation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidationUsingHamcrest {
	
	@Test
	public void responseTimeValidation()
	{
		baseURI = "http://localhost";
		port = 8084;
		
	    //Step 2: sned request
		Response resp = when()
		                 .get("/projects");
		
		//Validate response time
	    resp.then().assertThat().time(Matchers.lessThan(500L),TimeUnit.MILLISECONDS);
	}

}
