package responseValidatation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {
	
	@Test
	public void dynamicResponse()
	{
		String expData = "TY_PROJ_603";
		
		baseURI = "http://localhost";
		port = 8084;
		
		//Step2: send request
		Response resp = when().get("/projects");
		
		//Step 3: capture all the project ids
		boolean flag = false;
		List<String> list = resp.jsonPath().get("projectId");
		for(String actData : list)
		{
			if (actData.equalsIgnoreCase(expData)) 
			{
			   flag = true; //flag rising 
			   break;
			}
		}
		
		if (flag) 
		{
			System.out.println("data verfied");
		}
		else
		{
			System.out.println("data not verfied");
		}
		
		Assert.assertEquals(true, flag);
		
		long resTime = resp.getTime();
		System.out.println(resTime);
		
		
		
		
		
		
		
	}

}
