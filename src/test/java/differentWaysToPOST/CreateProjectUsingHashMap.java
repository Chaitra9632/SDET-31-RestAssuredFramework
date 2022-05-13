package differentWaysToPOST;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

public class CreateProjectUsingHashMap {
	
	@Test
	public void createProject()
	{
		Random ran = new Random();
		int random = ran.nextInt(100);
		
		baseURI = "http://localhost";
		port = 8084;
		
	   //Step 1: create neccessary data
		HashMap map = new HashMap();
		map.put("createdBy", "bibhudatta");
		map.put("projectName", "Amdocs-"+random);
		map.put("status", "Created");
		map.put("teamSize", 40);
		
		//Step 2: send request
		given()
		  .body(map)
		  .contentType(ContentType.JSON)
		.when()
		  .post("/addProject")
		.then()
		  .log().all();
		
	}

}
