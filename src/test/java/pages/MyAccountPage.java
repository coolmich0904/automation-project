package pages;

import java.io.File;

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
	WebElement btnHistorylist;

	
	@FindBy(xpath = "//span[contains(text(),'My addresses')]")
	WebElement btnaddress;
	
	
	@FindBy(xpath = "//span[contains(text(),'My personal information')]")
	WebElement btnInfo;
	
		
	@FindBy(xpath  = "//p[@class='alert alert-success']")
	WebElement successMsg;
	
	
	@FindBy(xpath = "//li[@class='lnk_wishlist']")
	WebElement btnWishlist;
	
	
	@FindBy(id = "name")
	WebElement txtwish;
	
	@FindBy(xpath = "//td[1]")
	WebElement tablelist;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement btnSave;
	
	@FindBy(xpath = "//i[@class='icon-remove']")
	WebElement btnRemove;
	
	@FindBy(xpath = "//tr[contains(@class,'first_item')]//td[@class='history_invoice']//a[1]")
	WebElement download;
	
	@FindBy(xpath  ="//div[@class='columns-container']//li[1]//a[1]//span[1]")
	WebElement backAccount;
	
	@FindBy(xpath = "//a[@class='logout']") 
	public WebElement btnSignOut;
	
	
	
	public void gohome() {
		home.click();
	}
	
	public void doLogout() {		
		btnSignOut.click();
	}
	
	public void orderHistory() {
		btnHistorylist.click();
	}

	public void btnAddress() {
		btnaddress.click();
	}
	
	public void btnInformation() {
		btnInfo.click();
	}
	
	
	public void addWishList() {
		
		btnWishlist.click();
		txtwish.click();
		txtwish.sendKeys("Printed Chiffon Dress");	
	}
	
	public void btnsave() {
		btnSave.click();
	}
	
	public String tablewishlist() {
		return tablelist.getText();
	}
	
	public void btnremove() {
		btnRemove.click();
	}
	
	public String successmsg() {
		
		return successMsg.getText();
	}
	
	public void goMyAccount() {
		
		backAccount.click();
	}
	
	
	public void downloadFile() {
		
	    download.click();
	}
	
	
	/* Check the file from a specific directory with extension */
    public boolean isFileDownloaded_Ext(String dirPath, String ext){
        boolean flag = false;
        File dir = new File("C:\\Users\\irene\\Documents\\filedownloads");
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            flag = false;
        }
 
        for (int i = 1; i < files.length; i++) {
            if(files[i].getName().contains(ext)) {
                flag = true;
            }
        }
        return flag;
    }
	
    /* Check the file from a specific directory with extension */
    public boolean isFileDownloaded(String dirPath, String ext){
        boolean flag=false;
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            flag = false;
        }
 
        for (int i = 1; i < files.length; i++) {
            if(files[i].getName().contains(ext)) {
                flag=true;
            }
        }
        return flag;
    }
    
}
