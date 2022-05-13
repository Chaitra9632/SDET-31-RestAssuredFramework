package differentWaysToPOST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectUisngJSONObject {
	
	@Test
	public void createProject()
	{
		Random ran = new Random();
		int random = ran.nextInt(100);
		
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create neccessary data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Roja");
		jObj.put("projectName", "Sony-"+random);
		jObj.put("status", "On Going");
		jObj.put("teamSize", 23);
		
		//Step2: send request
		given()
		  .body(jObj)
		  .contentType(ContentType.JSON)
		.when()
		  .post("/addProject")
		.then()
		  .assertThat().statusCode(201)
		  .log().all();
	}

}
