package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class PaymentPage extends BasePage{

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement btnAddCheckout;
	
	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement btnshippingCheckout;
	
	@FindBy(xpath = "//textarea[@name='message']")
	WebElement txtbox;
	
	@FindBy(xpath = "//input[@id='cgv']")
	WebElement chkAgree;
	
	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement payment1;
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement btnConfirm;
	
	public void btnshippingCheckout() {
		btnshippingCheckout.click();
	}
	
	public void btnAddCheckout() {
		btnAddCheckout.click();
	}
	
	public void txtBox() {
		txtbox.sendKeys("Please put them on the Apple Box");
	}
	
	public void checkbox() {
		chkAgree.click();
	}	
	
	public void payment() {
		payment1.click();
	}
	
	public void btnConfirm() {
		btnConfirm.click();
	}	
}
