package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.ExtentManager;


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

	@BeforeMethod
	public void setup() {

		report = new ExtentReports();
		test = report.createTest("TC006 Order History / File Download Test");
	}

	@Test(priority = 1, description = "sample login data")
	public void login() {

		test.log(Status.INFO, "TC006_OrderHistory");
		test.log(Status.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP = new LandingPage(driver);

		landP.doClick();
		test.log(Status.INFO, "Clicked Signin button");
		log.info("Clicked Signin");

		test.log(Status.INFO, "At Login Page");
		log.info("Open Login Page!!!");
		logP = new LoginPage(driver);

		logP.doLogin("a12@a12.com", "12345");
		test.log(Status.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");
	}

	@Test(priority = 3, description = "Check Account Order History including PDF file download")
	public void invoice() {

		test.log(Status.INFO, "TC006 File download fron Order History");
		test.log(Status.INFO, "Yeah! I came into My Account page");
		log.info("Open MyAccount Page");
		myacc = new MyAccountPage(driver);

		myacc.orderHistory();
		test.log(Status.INFO, "Clicked Order History");
		log.info("Clicked Oreder History");

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		myacc.downloadFile();
		test.log(Status.INFO, "1st file downloded");
		log.info("1st file downloded");
		landP.pause(5000);

		test.log(Status.INFO, "Verified the download");
		log.info("Verified the download");
		Assert.assertTrue(myacc.isFileDownloaded("C:\\Users\\irene\\Downloads", "IN0080"));

	}

	@AfterTest
	public void tearDown() {

		log.info("Close browser");
		test.log(Status.INFO, "Close Browser");
		driver.quit();

		test.log(Status.INFO, "Post-condition");
		log.info("Post-condition ");

		test.log(Status.INFO, "Erase the previous data on the report");
		log.info("Erase the previous data on the report");
		report.flush();
	}

}
