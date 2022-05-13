package genericLibrary;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * this contains all the pre and post conditions
 * @author Chaitra M
 *
 */
public class BaseAPIClass {
	
	public JavaLibrary jLib = new JavaLibrary();
	public DataBaseLibrary dLib = new DataBaseLibrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
	    baseURI = "http://localhost";
	    port = 8084;
	    
	    dLib.connectToDB();
	    
	    System.out.println("=======db connection successful=========");
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
		System.out.println("========db connection closed========");
	}

}
