package differentWaysToPOST;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProjectUisngJSONFile {
	
	@Test
	public void createProject()
	{
	    
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: create data
		File file = new File(".\\data.json");
		
		//Step 2: send data
		given()
		  .body(file)
		  .contentType(ContentType.JSON)
		.when()
		  .post("/addProject")
		.then()
		  .log().all();
		
		
		
		
		
		
		
		
		
		
		
	}

}
