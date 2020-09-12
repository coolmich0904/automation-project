package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class ProductDetailsPage extends BasePage{
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath = "//img[@id='bigpic']")
	WebElement bigPicure;
	
	@FindBy(xpath = "//span[@class='span_link no-print']")
	WebElement bigPic;
	
	@FindBy(xpath = "//a[@class='fancybox-nav fancybox-next']")
	WebElement nextPic;
	
	@FindBy(xpath = "//a[@class='fancybox-nav fancybox-prev']")
	WebElement prePic;
	
	@FindBy(xpath = "//div[@class='fancybox-overlay fancybox-overlay-fixed']")
	WebElement closePic;
	
	@FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
	WebElement btnClosePic;
	
	@FindBy(xpath = "//select[@id='group_1']")
	WebElement selectSizeM;
	
	
	@FindBy(xpath = "//a[@id='view_scroll_right']")
	WebElement viewR;
	
	@FindBy(xpath = "//a[@id='view_scroll_left']")
	WebElement viewL;
	
	@FindBy(xpath = "//a[@id='color_8']")
	WebElement colorWh;
	
	@FindBy(xpath = "//button[@name='Submit']")
	WebElement addcart;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement btnCheckout;
	
	
	public void selectBigPic() {
		bigPic.click();
	}
	
	public void selectSize() {
		Select select = new Select(selectSizeM);
		select.selectByVisibleText("M");
	}
	
	public void color() {
		if(colorWh.isDisplayed())
			colorWh.click();
	}
	
	public void addCart() {
		addcart.click();
	}
	
	public void checkout() {
		if(btnCheckout.isEnabled())
			btnCheckout.click();
	}
	
	public void moveNext() {
		nextPic.click();
	}
	
	public void movePrevious() {
		prePic.click();
	}
	
	public void closePic() {
		btnClosePic.click();
	}
	
	public void moveRight() {
		viewR.click();
	}
	
	
	public void moveLeft() {
		viewL.click();
	}
}
