package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//i[@class='icon-plus']")
	WebElement btnIncrease;
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement btnCheckout;
	
	public void increaseQty() {
		btnIncrease.click();
	}
	
	public void checkout() {
		btnCheckout.click();
	}
}
