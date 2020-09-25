package sanity;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.CategoriesPage;
import pages.LandingPage;

@Listeners(utilities.ExtentListeners.class)
public class TC003_Catalog extends BaseClass  {

	
	LandingPage landP;
	CategoriesPage catP;
	JavascriptExecutor jse;
	
	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void setup() {	    
		report = new ExtentReports(
				"C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC003_Catalog.html");
		test = report.startTest("Catalog");
		
	}
	
	
	@Test(description = "Filter products using Catalog including size and slider range")
	public void catalogTest() throws Exception {
		
		test.log(LogStatus.INFO, "TC003_Catalog");
		test.log(LogStatus.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP = new LandingPage(driver);
		
		landP.menuTab1();
		test.log(LogStatus.INFO, "Clicked Woman tab");
		log.info("Clicked Woman tab");
				
		test.log(LogStatus.INFO, "Ready to filter from Category");
		log.info("Ready to filter from Category");
		catP = new CategoriesPage(driver);
		
		test.log(LogStatus.INFO, "Chose Size");
		log.info("Chose Size");
		catP.sizeOption3();
		
		test.log(LogStatus.INFO, "Scroll down");
		log.info("Scroll down");
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(600, 900)");
		
		test.log(LogStatus.INFO, "Move the Right Slider to Left to filter ");
		log.info("Move the Right Slider to Left to filter");
		catP.moveRight(driver);
		
		test.log(LogStatus.INFO, "Verify through the movement checking");
		log.info("Verify through the movement checking");
		Assert.assertTrue(catP.movement() == true);
		Thread.sleep(2000);

	}
	
	
	@AfterTest
	public void tearDown() {

		log.info("Close browser");
		test.log(LogStatus.INFO,"Close Browser");
		driver.quit();
		
		test.log(LogStatus.INFO,"Post-condition");
		log.info("Post-condition ");
		report.endTest(test);
		
		test.log(LogStatus.INFO,"Erase the previous data on the report");
		log.info("Erase the previous data on the report");
		report.flush();
	}
	
}
