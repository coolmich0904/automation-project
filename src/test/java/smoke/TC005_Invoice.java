package smoke;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.ExtentManager;

public class TC005_Invoice extends BaseClass {

	LandingPage landP;
	LoginPage logP;
	MyAccountPage myacc;
	
	ExtentReports report;
	ExtentManager extentmanager;
	ExtentTest test;
	
	@BeforeTest
	public void setup() {
		report = new ExtentReports(
				"C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC005_Invoice.html");
		test = report.startTest("File Download Test");
	}

	
	@Test (priority = 1)
	public void login() {
		test.log(LogStatus.INFO, "TC005_Invoice");
		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "Landing at Home!!!");
		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");
		logP = new LoginPage(driver);
		test.log(LogStatus.INFO, "At Login Page");
		logP.doLogin("a11@a11.com", "12345");
		test.log(LogStatus.INFO, "Entered Email and Password");
		//log.info("Enter Email and submit to register");
	}
	
	@Test (priority = 3)
	public void invoice() {
		myacc = new MyAccountPage(driver);
		test.log(LogStatus.INFO, "My Account Page!");
		
		myacc.orderHistory();
		test.log(LogStatus.INFO, "Clicked Order History");
		//log.info("Clicked Oreder History");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		myacc.downloadFile();
		test.log(LogStatus.INFO, "1st file downloded");
		//log.info("1st file downloded");
		landP.pause(5000);	
		test.log(LogStatus.INFO, "Paid the Order");
		 Assert.assertTrue(myacc.isFileDownloaded("C:\\Users\\irene\\Downloads", ".pdf"));
		test.log(LogStatus.INFO, "Verified TC005");
		//log.info("Verified TC005");
	}
	
	@AfterTest
	public void tearDown() {
		//log.info("Close browser");
		driver.quit();
		//log.info("Post-condition ");
		report.endTest(test);
		//log.info("erase the previous data on the report");
		report.flush();
	}
}
