package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CategoriesPage extends BasePage {

	public CategoriesPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "layered_id_attribute_group_3")
	WebElement sizeL;

	@FindBy(xpath = "//span[@id='layered_price_range']")
	WebElement range;

	@FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']")
	WebElement slider;

	@FindBy(xpath = "//div[@id='left_column']//a[2]")
	WebElement sliderRight;

	@FindBy(xpath = "//*[@id=\"layered_price_slider\"]/a[1]")
	WebElement sliderLeft;

	public void sizeOption3() {
		if (!sizeL.isSelected())
			sizeL.click();
	}

	public void moveRight(WebDriver driver) {

		Actions action = new Actions(driver);
		action.dragAndDropBy(sliderRight, -160, 0).perform();
	}

	public boolean movement() {
		String text = range.getText();
		if (text.contains("$28.58"))
			return true;
		else
			return false;
	}
}
