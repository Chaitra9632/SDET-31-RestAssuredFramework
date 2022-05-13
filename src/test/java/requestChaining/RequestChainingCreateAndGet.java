package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class RequestChainingCreateAndGet {
	
	@Test
	public void createDataAndGet()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		Random r = new Random();
		int ran = r.nextInt(200);
		
		/*create data*/
		//Step 1: create project using POST()
		ProjectLibrary pLib = new ProjectLibrary("Keshav", "Xebia-"+ran, "Created", 25);
		
		Response resp = given()
						.body(pLib)
						.contentType(ContentType.JSON)
						.when()
						.post("/addProject");
		 
		//Step 2: capture the response using jsonPath()
		//Step 3: Store the data in variable
		String projectIDCaptured = resp.jsonPath().get("projectI");
		System.out.println(projectIDCaptured);
		
		/*Get the data */
		//Step 4: create another request and use the captured variable
		given()
		 .pathParam("pid", projectIDCaptured)
		.when()
		 .get("/projects/{pid}")
		
		//Step 5: validate
		.then().assertThat().statusCode(200).log().all();
	}

}
