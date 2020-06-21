package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;;

public class AddCustomerPage {

	public WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}


	By textDashBoard=By.xpath("//div[@class='content-header']/h1[contains(text(),'Dashboard')]");
	By linkCustomerMenu=By.xpath("//a//span[contains(text(),'Customers')]");
	By linkCustomerMenuItem=By.xpath("//span[@class='menu-item-title' and contains(text(),'Customers')]");
	By linkAddNewCustomer=By.xpath("//a[contains(.,'Add new')]");
	By txtBoxEmail=By.xpath("//input[@name='Email']");
	By txtBoxPassword=By.xpath("//input[@name='Password']");
	By txtBoxFirstName=By.xpath("//input[@name='FirstName']");
	By txtBoxLastName=By.xpath("//input[@name='LastName']");
	By radioButtonGenderMale=By.xpath("//input[@id='Gender_Male']//..");
	By radioButtonGenderFemale=By.xpath("//input[@id='Gender_Female']");
	By txtBoxDateOfBirth=By.xpath("//input[@id='DateOfBirth']");
	By txtBoxCompanyName=By.xpath("//input[@id='Company']");
	By txtBoxCustomerRoles=By.xpath("//input[@class='k-input']");
	By txtAreaAdminComment=By.xpath("//textarea[@id='AdminComment']");
	By btnSave=By.xpath("//button[@name='save']");


	public String getPageTitle() {

		return driver.getTitle();
	}


	public String verifyDashBoard() {

		return driver.findElement(textDashBoard).getText();

	}

	public void clickDashBoardMenu() {

		driver.findElement(linkCustomerMenu).click();

	}

	public void clicklinkCustomerMenuItem()  {

		driver.findElement(linkCustomerMenuItem).click();

	}

	public void clickAddNewBtn()  {

		driver.findElement(linkAddNewCustomer).click();;

	}

	public void setUserName(String user) {

		driver.findElement(txtBoxEmail).clear();
		driver.findElement(txtBoxEmail).sendKeys(user);
	}

	public void setPassword(String password) {

		driver.findElement(txtBoxPassword).clear();
		driver.findElement(txtBoxPassword).sendKeys(password);
	}

	public void enterFirstName(String fname)
	{
		driver.findElement(txtBoxFirstName).clear();
		driver.findElement(txtBoxFirstName).sendKeys(fname);

	}

	public void enterLastName(String lname)
	{
		driver.findElement(txtBoxLastName).clear();
		driver.findElement(txtBoxLastName).sendKeys(lname);
	}

	public void selectMaleRadioBtn() {

		driver.findElement(radioButtonGenderMale).click();

	}

	public void enterDateOfBirth(String dob)
	{
		driver.findElement(txtBoxDateOfBirth).sendKeys(dob);
		driver.findElement(txtBoxDateOfBirth).sendKeys(Keys.ENTER);
	}

	public void enteCompanyName(String cName)
	{
		driver.findElement(txtBoxCompanyName).clear();
		driver.findElement(txtBoxCompanyName).sendKeys(cName);
	}

	public void selectCustomerRole(String role)
	{
		driver.findElement(txtBoxCustomerRoles).sendKeys(role);
		driver.findElement(txtBoxCustomerRoles).sendKeys(Keys.ENTER);
	}


	public void enterAdminComment(String comment) {

		driver.findElement(txtAreaAdminComment).clear();
		driver.findElement(txtAreaAdminComment).sendKeys(comment);
	}

	public void clickSaveBtn() {

		driver.findElement(btnSave).isDisplayed();
		driver.findElement(btnSave).click();
	}






}
