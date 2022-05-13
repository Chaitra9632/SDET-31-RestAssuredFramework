package genericLibrary;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

/**
 * This class contains pre and post conditions using spec builders
 * @author Chaitra M
 *
 */
public class BaseAPIClassWithBuilders {
	
	public JavaLibrary jLib = new JavaLibrary();
	public DataBaseLibrary dLib = new DataBaseLibrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	public RequestSpecification req;
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		RequestSpecBuilder requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri("http://localhost:8084");
		requestSpec.setContentType(ContentType.JSON);
		
		req = requestSpec.build();
		
		dLib.connectToDB();
		System.out.println("===db connected=====");
	}

	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
		System.out.println("====db closed=====");
	}
}
