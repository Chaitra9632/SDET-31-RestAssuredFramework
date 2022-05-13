package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
	
	@Test
	public void getAllProjects()
	{
		baseURI = "http://localhost";
		port = 8084;
		//Step1: create data
		
		//Step 2: send request
		
		when()
		  .get("/projects")
		.then()
		  .assertThat().statusCode(200)
		  .log().all();
		
		//step 3: validate
	}

}
