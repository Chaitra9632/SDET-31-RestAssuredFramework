package authentications;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerTokenAuthentication {
	
	@Test
	public void bearerTokenTest()
	{
		baseURI = "https://api.github.com";
		
		JSONObject jObj = new JSONObject();
		jObj.put("name", "BearerTokenRest");
		jObj.put("description", "RIP");
		
		given()
		  .auth()
		  .oauth2("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")
		  .body(jObj)
		  .contentType(ContentType.JSON)
		  
		.when()
		   .post("/user/repos")
		   
		.then().log().all();
	}

}
