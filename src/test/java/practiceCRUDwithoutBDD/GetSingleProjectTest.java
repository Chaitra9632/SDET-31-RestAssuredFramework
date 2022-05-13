package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetSingleProjectTest {
	
	@Test
	public void getProject()
	{
        String expContType = "application/json";
        int expStatus = 201;
		//Step 1: create neccessary request data
		
		//Step 2: Send request
		Response resp = RestAssured.when().get("http://localhost:8084/projects/TY_PROJ_1204");
		
		//Step 3: validate
		String actcontType = resp.getContentType();
		int actStatus = resp.getStatusCode();
		
		Assert.assertEquals(expContType, actcontType);
		
		Assert.assertEquals(expStatus, actStatus);
		
	}

}
