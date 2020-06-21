package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class Steps extends BaseClass{

	@Before
	public void setup() {
		
		logger=logger.getLogger("nopCommerce");//added logger
		PropertyConfigurator.configure("Log4j.properties");//u have to mention complete path id log4j.properties file is placed other than project directories
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("*****Launching browser******");
	}

	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {

		
		lp=new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {

		logger.info("*****Accessing URL******");
		driver.get(url);
		driver.manage().window().maximize();

	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws InterruptedException {

		logger.info("*****Providing loging details******");
		Thread.sleep(5000);
		lp.setUserName(email);
		lp.setPassword(password);

	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {

		logger.info("*****click on login******");
		lp.clickButtonLogIn();
		Thread.sleep(5000);

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {


		Assert.assertEquals(title, lp.getPageTitle());


	}

	@When("User Click on Log out Link")
	public void user_Click_on_Log_out_Link() throws InterruptedException {

		lp.clickLinkLogOut();
		Thread.sleep(3000);
		
	}
	
	

	@Then("Close Browser")
	public void close_Browser() {

		logger.info("*****Closing browser******");
		driver.quit();

	}

	//Customer feature step definitions...


	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() throws InterruptedException {

		Thread.sleep(3000);
		addCust=new AddCustomerPage(driver);

		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
		Assert.assertEquals("Dashboard",addCust.verifyDashBoard());
	}

	@When("User Click on customers menu")
	public void user_Click_on_customers_menu() throws InterruptedException {

		addCust.clickDashBoardMenu();
		Thread.sleep(3000);


	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {

		addCust.clicklinkCustomerMenuItem();
		Thread.sleep(3000);


	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {

		addCust.clickAddNewBtn();
		Thread.sleep(3000);

	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {

		String actual=driver.getPageSource();
		boolean flag=actual.contains("Add a new customer");
		Assert.assertTrue(flag);
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {

		String user=randomString(6).toUpperCase();

		addCust.setUserName(user+"@yopmail.com");
		addCust.setPassword("Tester#123");
		addCust.enterFirstName(user);
		addCust.enterLastName(randomString(5).toUpperCase());
		addCust.enterDateOfBirth(dob);
		//addCust.enteCompanyName(randomString(10).toUpperCase());
		//addCust.selectMaleRadioBtn();
		//addCust.selectCustomerRole("Vendors");
		//addCust.enterAdminComment("Admin approves this user");

	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {

		//addCust.clickSaveBtn();
		Thread.sleep(3000);

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {

		String actual=driver.getPageSource();
		boolean flag=actual.contains("The new customer has been added successfully.");
		Assert.assertTrue(flag);
	}

}
