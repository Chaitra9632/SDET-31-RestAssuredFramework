package responseValidatation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	
	@Test
	public void staticResponse()
	{
		baseURI = "http://localhost";
		port = 8084;
		//Step 1: create neccessary data
		
		//Step 2: send request - get all projects
		Response resp = when()
		  .get("/projects");
		
		//Step 3: provide validation
		String expData = "TY_PROJ_1004";
		String actData = resp.jsonPath().get("[1].projectId");
		
		Assert.assertEquals(expData, actData);
		//resp.then().log().all();
		System.out.println("data verification successful");
		
	}

}
