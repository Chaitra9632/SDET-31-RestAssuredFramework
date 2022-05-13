package practiceCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {
	
	@Test
	public void createProject()
	{
	    //step 1: create data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Roja");
		jObj.put("projectName", "Sony");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 23);
		
		//Step 2: send request
		given()
		  .body(jObj)
		  .contentType(ContentType.JSON)
		  
		.when()
		  .post("http://localhost:8084/addProject")
		.then()
		  .assertThat().statusCode(201)
		  .contentType(ContentType.JSON)
		  .log().all();
		
		
		//Step 3: validate response
	}

}
