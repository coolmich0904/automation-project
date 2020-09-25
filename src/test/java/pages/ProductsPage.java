package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ProductsPage extends BasePage {
		
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//ul[@id='homefeatured']//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line']//i[@class='icon-eye-open']")
	WebElement proPic;

	@FindBy(className = "icon-th-list")
	WebElement showList;
	
	@FindBy(className = "quick-view-mobile")
	WebElement mobileView;
	
	@FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
	WebElement fancyboX;
	
	@FindBy(id = "color_43")
	WebElement color1;
	
	
	public void selectQuickView() {
			if(proPic.isDisplayed())
			proPic.click();
	}
	
	public void pDetails() {
		if(color1.isEnabled())
			color1.click();
	}
	
	public void showList() {
		showList.click();
	}
	
	public void clzFancyBox() {
		fancyboX.click();
	}
}
