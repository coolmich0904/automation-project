package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
 
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='email_create']")
	public WebElement createEmail;
	
	@FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
	public WebElement alert;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='passwd']")
	public WebElement txtPassword;
	
	@FindBy(xpath = "//form[@id='create-account_form']//span[1]")
	public WebElement btnRegister;
	
	@FindBy(xpath = "//p[@class='submit']//span[1]")
	public WebElement btnSignin;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	public WebElement forgetPassword;
	
	
	public void doRegister(String myEmail) {
		createEmail.sendKeys(myEmail);
		btnRegister.click();
		//createEmail.clear();
	}
	

	public void doLogin(String myEmail, String myPword) {
		txtEmail.sendKeys(myEmail);
		txtPassword.sendKeys(myPword);
		btnSignin.click();	
	}
}
