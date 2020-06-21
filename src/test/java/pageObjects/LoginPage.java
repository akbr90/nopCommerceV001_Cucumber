package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement linkLogOut;

	
	public String getPageTitle() {
		
		return driver.getTitle();
	}
	
	public void setUserName(String user) {

		txtEmail.clear();
		txtEmail.sendKeys(user);
	}

	public void setPassword(String password) {

		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickButtonLogIn() {

		btnLogin.click();
	}

	public void clickLinkLogOut() {

		linkLogOut.click();
	}


}
