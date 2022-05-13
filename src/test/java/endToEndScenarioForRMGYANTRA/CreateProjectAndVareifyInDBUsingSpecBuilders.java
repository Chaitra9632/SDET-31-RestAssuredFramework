package endToEndScenarioForRMGYANTRA;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClassWithBuilders;
import genericLibrary.EndPointsLibrary;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.ProjectLibrary;

public class CreateProjectAndVareifyInDBUsingSpecBuilders extends BaseAPIClassWithBuilders{
	
	@Test
	public void createdProject() throws Throwable
	{
		        //Step 1: create data
				ProjectLibrary pLib = new ProjectLibrary("Kiran", "Amdocs-"+jLib.getRandomNumber(), "Created", 20);
				
				//Step 2: send request
				Response response = given()
							.spec(req)
							.body(pLib)
							.when()
							.post(EndPointsLibrary.createProject);
				
				//Step 3: API response - capture the resp
				rLib.logAll(response);
				String proId = rLib.getJsonData(response, "projectId");
				System.out.println(proId);
				
				//Step 4: validate response in database
				String query = "select * from project";
				String data = dLib.executeQueryAndReturnData(query, 1, proId);

				Assert.assertEquals(proId, data);
	}

}
