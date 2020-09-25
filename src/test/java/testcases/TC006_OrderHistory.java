package testcases;

import java.util.concurrent.TimeUnit;

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
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.ExtentManager;

@Listeners(utilities.ExtentListeners.class)
public class TC006_OrderHistory extends BaseClass {

	LandingPage landP;
	LoginPage logP;
	MyAccountPage myacc;
	CreateAccountPage caP;

	ExtentReports report;
	ExtentManager extentmanager;
	ExtentTest test;

	String actual, expected;
	JavascriptExecutor jse;

	@BeforeTest
	public void setup() {
		report = new ExtentReports("C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC006_OrderHistory.html");
		test = report.startTest("Order History / File Download Test");
	}

	@Test(priority = 1, description = "sample login data")
	public void login() {

		test.log(LogStatus.INFO, "TC006_OrderHistory");
		test.log(LogStatus.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP = new LandingPage(driver);

		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");
		log.info("Clicked Signin");

		test.log(LogStatus.INFO, "At Login Page");
		log.info("Open Login Page!!!");
		logP = new LoginPage(driver);

		logP.doLogin("a12@a12.com", "12345");
		test.log(LogStatus.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");
	}

	@Test(priority = 3, description = "Check Account Order History including PDF file download")
	public void invoice() {

		test.log(LogStatus.INFO, "Yeah! I came into My Account page");
		log.info("Open MyAccount Page");
		myacc = new MyAccountPage(driver);

		myacc.orderHistory();
		test.log(LogStatus.INFO, "Clicked Order History");
		log.info("Clicked Oreder History");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myacc.downloadFile();
		test.log(LogStatus.INFO, "1st file downloded");
		log.info("1st file downloded");
		landP.pause(5000);

		test.log(LogStatus.INFO, "Verified the download");
		log.info("Verified the download");
		Assert.assertTrue(myacc.isFileDownloaded("C:\\Users\\irene\\Downloads", "IN0080"));

	}

	@AfterTest
	public void tearDown() {

		log.info("Close browser");
		test.log(LogStatus.INFO, "Close Browser");
		driver.quit();

		test.log(LogStatus.INFO, "Post-condition");
		log.info("Post-condition ");
		report.endTest(test);

		test.log(LogStatus.INFO, "Erase the previous data on the report");
		log.info("Erase the previous data on the report");
		report.flush();
	}

}
