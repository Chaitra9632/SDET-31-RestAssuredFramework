package authentications;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Authentication {
	
	@Test
	public void oauth2AuthenticationTest()
	{
		//Step 1: generate the access Token
		Response resp = given()
						.formParam("client_id", "SDET31-REST")
						.formParam("client_secret", "85d61609bd07fee754bda67379005474")
						.formParam("grant_type", "client_credentials")
						.formParam("redirect_uri", "http://example.com")
						.formParam("code", "authorization_code")
		  
						.when()
						.post("http://coop.apps.symfonycasts.com/token");
			
		//Step 2: Capture the token from response
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//Step 3: create another request to access the token
		given()
		  .auth()
		  .oauth2(token)
		  .pathParam("USER_ID", 1914)
		  
		  
		.when()
		  .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		  
		.then().log().all();
		
	}

}
