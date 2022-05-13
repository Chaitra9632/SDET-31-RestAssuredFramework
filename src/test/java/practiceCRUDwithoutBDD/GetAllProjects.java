package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	
	@Test
	public void getAllProjects()
	{
		//Step 1: create neccessary data
		
		//Step 2: SEnd request
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//Step 3: Validate response
		resp.then().log().all();
	}

}
