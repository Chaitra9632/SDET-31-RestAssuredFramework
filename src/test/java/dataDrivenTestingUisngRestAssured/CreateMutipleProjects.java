package dataDrivenTestingUisngRestAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojoClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateMutipleProjects {
	
	@Test(dataProvider = "getData")
	public void createMultipleProjects(String createdBy, String projectName, int teamSize)
	{
		baseURI = "http://localhost";
		port = 8084;
		
		Random ran = new Random();
		int random = ran.nextInt(200);
		
		//Step 1: read data from dataprovider
		ProjectLibrary pLib = new ProjectLibrary(createdBy, projectName+random, "Created", teamSize);
		
		//Step 2: send Resquest
		Response resp = given()
						  .body(pLib)
						  .contentType(ContentType.JSON)
						.when()
						  .post("/addProject");
		
		//Step 3: Validate the response
		
		String actData = resp.jsonPath().get("msg");
		
		Assert.assertEquals("Successfully Added", actData);
		
		resp.then().log().all();
		
		
		
	}

	
	@DataProvider(name = "getData")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][3];
		
		data[0][0] = "ramya";
		data[0][1] = "Accionlabs";
	    //data[0][2] = "Created";
	    data[0][3] = 20;
	    
		data[1][0] = "Soumya";
		data[1][1] = "Amdocs";
	    //data[1][2] = "Created";
	    data[1][3] = 25;
	    
		data[2][0] = "kavya";
		data[2][1] = "All States";
	    //data[2][2] = "Created";
	    data[2][3] = 30;
	    
	    return data;
	}
}
