package genericLibrary;

import java.util.Random;

/**
 * This class contains generic methods related to java 
 * like generating random numbers, getting date
 * @author Chaitra M
 *
 */
public class JavaLibrary {
	
	/**
	 * This method will generate the random number and
	 * returns it to the caller for every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		return ran.nextInt(1000);
	}

}
