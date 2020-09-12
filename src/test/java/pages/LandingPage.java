package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LandingPage extends BasePage{

	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@class='login']")
	public WebElement btnSignin;	
	
	@FindBy(linkText = "Women")
	public WebElement btnWoman;
	
	@FindBy(id = "layered_id_attribute_group_3")
	public WebElement sizeL;
	
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	public WebElement txtSearch;
	
	@FindBy(xpath="//a[@class='blockbestsellers']")
	public WebElement best;
	
	@FindBy(xpath = "//ul[@id='blockbestsellers']//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-tablet-line first-item-of-mobile-line']//div[@class='product-container']")
	public WebElement prod3;
		
	@FindBy(xpath = "//button[@name='submit_search']")
	public WebElement btnSearch;
	
	public void doClick() {
		btnSignin.click();
	}
	
	public void doSearch() {
		txtSearch.sendKeys("printed");
		btnSearch.click();
	}
	
	public void bestSeller() {
		best.click();
	}
	
	public void pickProd() {
		prod3.click();
	}
	
	public void menuTab1() {
		btnWoman.click();
	}
	
	
	public void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
