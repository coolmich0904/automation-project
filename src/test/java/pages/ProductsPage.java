package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ProductsPage extends BasePage {
		
	private static final WebDriver driver = null;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "layered_id_attribute_group_3")
	WebElement sizeL;
	
	@FindBy(xpath = "//div[@id='left_column']//a[2]")
	WebElement range;
	
	@FindBy(xpath ="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']//div[@class='product-image-container']")
	WebElement proPic;

	@FindBy(className = "icon-th-list")
	WebElement showList;
	
	@FindBy(className = "quick-view-mobile")
	WebElement mobileView;
	
	@FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
	WebElement fancyboX;
	
	@FindBy(id = "color_43")
	WebElement color1;
	
	public void sizeOption3() {
		if (!sizeL.isSelected())
			sizeL.click();
	}
	
	public void rangeSlider() {
		Actions action = new Actions(driver);
		action.dragAndDropBy(range, 257, 1588).release().build().perform();
		range.click();
	}
	
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
