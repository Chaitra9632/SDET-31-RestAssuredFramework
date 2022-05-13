package endToEndScenarioForRMGYANTRA;

import org.junit.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClass;
import genericLibrary.ConstantLibrary;
import genericLibrary.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pojoClass.ProjectLibrary;

public class CreateProjectAndVerifyInDatabaseTest extends BaseAPIClass {
	
	@Test
	public void createProject() throws Throwable
	{
		//Step 1: create data
		ProjectLibrary pLib = new ProjectLibrary("Kiran", "Amdocs-"+jLib.getRandomNumber(), "Created", 20);
		
		//Step 2: send request
		Response response = given()
					.body(pLib)
					.contentType(ContentType.JSON)
					.when()
					.post(EndPointsLibrary.createProject);
		
		//Step 3: API response - capture the resp
		String proId = rLib.getJsonData(response, "projectId");
		System.out.println(proId);
		
		//Step 4: validate response in database
		String query = "select * from project";
		String data = dLib.executeQueryAndReturnData(query, 1, proId);

		Assert.assertEquals(proId, data);
	}

}
