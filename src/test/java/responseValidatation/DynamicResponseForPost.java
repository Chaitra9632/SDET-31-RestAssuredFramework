package responseValidatation;

import static io.restassured.RestAssured.*;


import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojoClass.ProjectLibrary;

public class DynamicResponseForPost {
	
	@Test
	public void staticPOst()
	{
		String expData = "Successfully Added";
		
		baseURI = "http://localhost";
		port = 8084;
		
		Random ran = new Random();
		int random = ran.nextInt(1000);
		
		//Step 1: create data
		ProjectLibrary pLib = new ProjectLibrary("Soumya", "Xebia-"+random, "Created", 25);
		
		//Step 2: send Data
		Response resp = given()
		  .body(pLib)
		  .contentType(ContentType.JSON)
		.when()
		  .post("/addProject");
		
		//Step 3: provide validation
		String actData = resp.jsonPath().get("msg");
		
		Assert.assertEquals(expData, actData);
		
		
	}

}
