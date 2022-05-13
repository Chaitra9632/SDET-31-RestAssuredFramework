package genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class consists of generic methods related to database
 * @author Chaitra M
 *
 */
public class DataBaseLibrary {
	
	Driver driverRef;
	Connection con;
	
	/**
	 * This method will establish connection with database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		driverRef = new Driver();
	    DriverManager.registerDriver(driverRef);
	    con=DriverManager.getConnection(ConstantLibrary.dbURL, ConstantLibrary.dbUsername, ConstantLibrary.dbPassword);
	}
	
	/**
	 * This method will close the database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	
	/**
	 * This method will execute the query 
	 * It will compare the expdata with actual data
	 * it will return the data if comparison is successful
	 * @param query
	 * @param colummnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndReturnData(String query, int colummnIndex, String expData) throws Throwable
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(colummnIndex);
			if(expData.equalsIgnoreCase(actData))
			{
				flag = true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("data verification successful");
			return expData;
		}
		else
		{
			System.out.println("data verification failed");
			return "";
		}
	}
	
	

}
