package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	public void createProjectTest()
	{
		//Step 1: Create the data necessary - request Body
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Pooja");
		jObj.put("projectName", "Sony");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 1);
		
		//Step 2: Send the request
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
	    Response resp = req.post("http://localhost:8084/addProject");
		
		//Step 3: Validate the response
	    
	    //System.out.println(resp.asPrettyString()); // use it if only response body is needed
	    //System.out.println(resp.prettyPrint());
	    //System.out.println(resp.asString());
	    //System.out.println(resp.prettyPeek()); // use it when both header and body is needed
	    
	 
	    System.out.println(resp.getStatusCode());
	    System.out.println(resp.getContentType());
	    System.out.println(resp.getSessionId());
	    System.out.println(resp.getTime());
	    
	    ValidatableResponse validate = resp.then();
	    validate.log().all();
	    validate.assertThat().statusCode(200);
	    System.out.println("created successfully");
	}

	
	
	
	
	
	
	
}
