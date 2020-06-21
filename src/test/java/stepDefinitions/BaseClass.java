package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public static Logger logger;
	
	
	public static String dob="02/01/1990";
	
	public static String randomString(int strLen) {
		
		String ranString=RandomStringUtils.randomAlphabetic(strLen);
		
		return ranString;
		
	}
}
