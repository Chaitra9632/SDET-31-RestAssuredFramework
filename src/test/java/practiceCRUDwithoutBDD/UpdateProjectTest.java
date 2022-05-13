package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	
	@Test
	public void updateProject()
	{
		//Step 1: create neccessary data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Pooja");
		jObj.put("projectName", "Sony");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 10);
		
		
		//Step 2: send request
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_4412");
		
		//Step 3: validate response
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}

}
