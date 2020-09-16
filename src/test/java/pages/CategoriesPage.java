package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CategoriesPage extends BasePage {
	
	private static final WebDriver driver = null;

	public CategoriesPage (WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "layered_id_attribute_group_3")
	WebElement sizeL;
	
	@FindBy(xpath = "//div[@id='left_column']//a[2]")
	WebElement sliderRange;
	
	public void sizeOption3() {
		if (!sizeL.isSelected())
			sizeL.click();
	}
	
	public void rangeSlider() {
		Actions slider = new Actions(driver);
		slider.clickAndHold(sliderRange)
		    .moveByOffset(-65, 0).release().perform();
	}
	
	
}
