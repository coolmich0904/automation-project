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
