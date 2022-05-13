package practiceCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
	
	@Test
	public void updateProject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
	    //Step1: create data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Roja");
		jObj.put("projectName", "Sony");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 23);
		
		//Step2: send request
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		.when()
		  .put("/projects/TY_PROJ_1209")
		.then()
		  .log().all();
		
		//Step 3: validate
	}

}
