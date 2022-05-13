package genericLibrary;

import io.restassured.response.Response;

/**
 * This class contains all the generic methods related to rest assured
 * @author Chaitra M
 *
 */
public class RestAssuredLibrary {
	
	/**
	 * This method will take json path and return the data 
	 * @param response
	 * @param path
	 * @return
	 */
	public String getJsonData(Response response, String path)
	{
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}
	
	
	/**
	 * This method will log all the logs in console
	 * @param response
	 */
	public void logAll(Response response) 
	{
		response.then().log().all();
	}

}
