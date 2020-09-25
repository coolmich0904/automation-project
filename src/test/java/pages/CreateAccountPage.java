package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class CreateAccountPage extends BasePage {
 
	public CreateAccountPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(id="id_gender1")
	WebElement radio1;
	
	@FindBy(id="id_gender2")
	WebElement radio2;
		
	@FindBy(id="customer_firstname")
	WebElement fname;
	
	@FindBy(id="customer_lastname")
	WebElement lname;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;
	
	
	@FindBy(xpath="//input[@id='old_passwd']")
	WebElement passwd;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement newpasswd;
	
	@FindBy(xpath="//input[@id='confirmation']")
	WebElement conpasswd;
	
	
	@FindBy(xpath="//select[@id='days']")
	WebElement day;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement month;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement year;
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement newsletter;
			
	@FindBy(xpath="//input[@id='optin']")
	WebElement specialoffer;
	
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement addrfname;
	
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement addrlname;
	
	
	@FindBy(xpath="//input[@id='company']")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement addr1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postal;
	
	@FindBy(xpath="//select[@id='id_country']")
	WebElement country;
	
	@FindBy(xpath="//textarea[@id='other']")
	WebElement txtOther;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement cellp;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement alias;
	
	@FindBy(xpath="//span[contains(text(),'Register')]")
	WebElement btnRegister;	
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement btnSave;
	
	
	public void submit() {
		btnRegister.click();
	}
	
	public void doRegister() {
		radio1.click();
		fname.sendKeys("Hamay");
		lname.sendKeys("Gorski");		
		password.sendKeys("hm002");
		
		Select sd = new Select(day);
			sd.selectByValue("15");
		Select sm = new Select(month);
			sm.selectByValue("8");
		Select sy = new Select(year);
			sy.selectByValue("2000");
	
		newsletter.click();
		specialoffer.click();
		
		company.sendKeys("mike company");
		addr1.sendKeys("123 west");
		city.sendKeys("New York");
		
		Select st = new Select(state);
		st.selectByVisibleText("Alaska");
		
		postal.sendKeys("12345");
		
		Select sco = new Select(country);
		sco.selectByValue("21");
	
		//txtOther.sendKeys("nothing!!!!");
		cellp.sendKeys("1234567890");
		//alias.sendKeys();
		submit();
	}
	
	public void doUpdate() {
		radio1.click();
		email.sendKeys("");
		passwd.sendKeys("12345");
		newpasswd.sendKeys("54321");
		conpasswd.sendKeys("54321");
		
		Select sd = new Select(day);
			sd.selectByValue("15");
		Select sm = new Select(month);
			sm.selectByValue("8");
		Select sy = new Select(year);
			sy.selectByValue("2000");
	
		newsletter.click();
		specialoffer.click();
	}
	
	public void reverseUpdate() {
		
		passwd.sendKeys("54321");
		newpasswd.sendKeys("12345");
		conpasswd.sendKeys("12345");
	}
	
	public void btnSave() {
		btnSave.click();
	}
	
}
