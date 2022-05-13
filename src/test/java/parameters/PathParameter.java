package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void pathParameterTest()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		//Step 1: prerequisites
		given()
		  .pathParam("pid", "TY_PROJ_4806")
		
		//Step 2: send request
		.when() 
		  .get("/projects/{pid}")
		  
		//Step 3: validate response
		.then()
		  .assertThat().statusCode(200).log().all();
		
		
		
		
	
	}

}
