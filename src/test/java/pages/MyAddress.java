package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class MyAddress extends BasePage {


	public MyAddress(WebDriver driver) {
		super(driver);		
	}
	
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement addrfname;
	
		@FindBy(xpath="//input[@id='lastname']")
	WebElement addrlname;
	
		@FindBy(xpath="//input[@id='company']")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement addr1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postal;
	
	@FindBy(xpath="//select[@id='id_country']")
	WebElement country;
	
	@FindBy(xpath="//textarea[@id='other']")
	WebElement txtOther;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement cellp;
	
	@FindBy(xpath="//input[@id='alias']")
	WebElement alias;
	
	@FindBy(xpath = "//button[@id='submitAddress']")
	WebElement btnsave;
	
	@FindBy(xpath = "//span[contains(text(),'Update')]")
	WebElement btnmyupdate;
	
	@FindBy(xpath = "//div[@class='clearfix main-page-indent']//a[@class='btn btn-default button button-medium']")
	WebElement btnAddAddress;
	
	@FindBy(xpath = "//ul[@class='last_item alternate_item box']")
	WebElement lastItem;
	
	@FindBy(xpath = "//ul[@class='last_item item box']")
	WebElement firstItem;
	
	
	@FindBy(xpath = "//ul[@class='last_item alternate_item box']//span[contains(text(),'Delete')]")
	WebElement btnremove;

	public void myAddressUpdate(String s) {
		
		Select st = new Select(state);
		st.selectByVisibleText(s);
	}
	
	
	public void newAddress() {
		addrfname.clear();
		addrfname.sendKeys("Sister");
		addrlname.clear();
		addrlname.sendKeys("Gorski");		
		
		company.clear();
		company.sendKeys("mike company");
		addr1.clear();
		addr1.sendKeys("716 W Rosecrans Ave");
		city.sendKeys("Compton");
		
		Select st = new Select(state);
		st.selectByVisibleText("California");
		
		postal.clear();
		postal.sendKeys("90222");
		
		//txtOther.sendKeys("nothing!!!!");
		phone.clear();
		phone.sendKeys("1234567890");
		alias.clear();
		alias.sendKeys("My Sister");
	}
	
	
	public void btnMyUpdate() {		
		btnmyupdate.click();
	}
	
	public void btnSave() {
		btnsave.click();
	}
	
	public void btnAddNew() {
		btnAddAddress.click();
	}
	
	public boolean addressItem() {
		if (lastItem.isDisplayed())
			return true;
		else return false;
	}
	
	public void btnRemove() {
		btnremove.click();
	}
	
	public boolean afterRemovedItem() {
		if (firstItem.isDisplayed())
			return true;
		else return false;
	}
	
}
