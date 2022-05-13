package differentWaysToPOST;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

import pojoClass.ProjectLibrary;

public class CreateProjectUisngPOJOClass {
	
	@Test
	public void createProject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		Random ran = new Random();
		int random = ran.nextInt(1000);
		
		//Step 1: create data
		ProjectLibrary pLib = new ProjectLibrary("Soumya", "Xebia-"+random, "Created", 25);
		
		//Step 2: send Data
		given()
		  .body(pLib)
		  .contentType(ContentType.JSON)
		.when()
		  .post("/addProject")
		.then()
		  .log().all();
	}
	
	

}
