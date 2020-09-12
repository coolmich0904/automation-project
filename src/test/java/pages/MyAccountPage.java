package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	public WebElement home;	
	
	@FindBy(xpath = "//div[@class='row addresses-lists']//div[1]//ul[1]//li[1]//a[1]")
	WebElement historylist;
	
	@FindBy(xpath = "//tr[contains(@class,'first_item')]//td[@class='history_invoice']//a[1]")
	WebElement download;
	
	@FindBy(xpath = "//div[@class='nav']//div[2]")
	public WebElement btnSignOut;
	
	public void gohome() {
		home.click();
	}
	
	public void doLogout() {		
		btnSignOut.click();
	}
	
	public void orderHistory() {
		historylist.click();
	}
	
	public void downloadFile() {
	    download.click();
	}
}
