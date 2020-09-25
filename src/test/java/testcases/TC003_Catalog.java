package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.CategoriesPage;
import pages.LandingPage;


public class TC003_Catalog extends BaseClass  {

	
	LandingPage landP;
	CategoriesPage catP;
	JavascriptExecutor jse;
	
	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void setup() {	    

		report = new ExtentReports();
		test = report.createTest("TC003 Catalog Function Test");
	}
	
	
	@Test(description = "Filter products using Catalog including size and slider range")
	public void catalogTest() throws Exception {
		
		test.log(Status.INFO, "TC003_Catalog");
		test.log(Status.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP = new LandingPage(driver);
		
		landP.menuTab1();
		test.log(Status.INFO, "Clicked Woman tab");
		log.info("Clicked Woman tab");
				
		test.log(Status.INFO, "Ready to filter from Category");
		log.info("Ready to filter from Category");
		catP = new CategoriesPage(driver);
		
		test.log(Status.INFO, "Chose Size");
		log.info("Chose Size");
		catP.sizeOption3();
		
		test.log(Status.INFO, "Scroll down");
		log.info("Scroll down");
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(600, 900)");
		
		landP.pause(4000);
		test.log(Status.INFO, "Move the Right Slider to Left to filter ");
		log.info("Move the Right Slider to Left to filter");
		catP.moveRight(driver);
		
		test.log(Status.INFO, "Verify through the movement checking");
		log.info("Verify through the movement checking");
		Assert.assertTrue(catP.movement() == true);
		Thread.sleep(2000);

	}
	
	
	@AfterTest
	public void tearDown() {

		log.info("Close browser");
		test.log(Status.INFO,"Close Browser");
		driver.quit();
		
		test.log(Status.INFO,"Post-condition");
		log.info("Post-condition ");
		
		test.log(Status.INFO,"Erase the previous data on the report");
		log.info("Erase the previous data on the report");
		report.flush();
	}
	
}
