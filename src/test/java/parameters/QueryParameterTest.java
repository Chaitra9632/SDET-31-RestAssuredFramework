package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameterTest {
	
	@Test
	public void queryParameterTest()
	{
		baseURI = "https://reqres.in";
		
		//Step 1: pre requisites
		given()
		  .queryParam("page", 3)
		  
		
		//Step 2: send request
		.when()
		  .get("/api/users")
		
		//Step 3: validate response
		.then().log().all();
	}

}
