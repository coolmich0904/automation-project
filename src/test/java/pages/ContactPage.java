package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class ContactPage extends BasePage {

	public ContactPage (WebDriver driver) {
		super(driver);		
	}
	
	
	@FindBy(xpath = "//select[@id='id_contact']")
	WebElement subject;
	
	@FindBy(xpath = "//div[@id='contact-link']//a[contains(text(),'Contact us')]")
	WebElement btncontact;
	
	@FindBy(xpath = "//input[@id='fileUpload']")
	WebElement choosefile;
	
	
	@FindBy(xpath = "//span[contains(text(),'Send')]//i[@class='icon-chevron-right right']")
	WebElement btnsend;
	
	@FindBy(xpath = "//textarea[@id='message']")
	WebElement btnmessage;
	
	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement successmsg;
	
	
	public void btnContact() {
		btncontact.click();
	}
	
	public void selectSubject() {
		Select select = new Select(subject);
		select.selectByVisibleText("Customer service");
	}
	
	public void chooseFile() {
		choosefile.sendKeys("C:\\Users\\irene\\Documents\\pictures\\stitch.jpg");
	}
	
	public void btnSend() {
		btnsend.click();
	}
	
	public void btnMsg() {
		btnmessage.sendKeys("wtesfygdvuzshdvb..ovdhba,ugefcbasjh.aoifbvcna");
	}
	
	
	public String successMsg() {
		return successmsg.getText();
	}
	
}
