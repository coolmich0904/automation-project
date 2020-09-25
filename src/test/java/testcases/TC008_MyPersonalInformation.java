package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.PaymentPage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;
import utilities.ExtentManager;

public class TC008_MyPersonalInformation extends BaseClass {

	LandingPage landP;
	LoginPage logP;
	MyAccountPage myacc;
	CreateAccountPage caP;
	ProductDetailsPage dprodP;
	ShoppingCartPage cp;
	PaymentPage payP;

	String actual, expected;
	JavascriptExecutor jse;

	ExtentReports report;
	ExtentManager extentmanager;
	ExtentTest test;

	@BeforeTest
	public void setup() {
		report = new ExtentReports(
				"C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC008_MyPersonalInformation.html");
		test = report.startTest("My Personal Information");
	}

	@Test(priority = 1, description = "sample login data")
	public void login() {

		test.log(LogStatus.INFO, "TC008_MyPersonalInformation");
		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "Landing at Home!!!");
		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");

		logP = new LoginPage(driver);
		test.log(LogStatus.INFO, "At Login Page");
		logP.doLogin("a11@a11.com", "12345");
		test.log(LogStatus.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");
	}

	@Test(priority = 2, description = "Update or Edit Personal Information / demo - update password")
	public void myInformation() {

		myacc = new MyAccountPage(driver);
		myacc.btnInformation();
		test.log(LogStatus.INFO, "Clicked My Personal Information");
		log.info("Clicked My Personal Information ");

		test.log(LogStatus.INFO, "Open Personal Update Page");
		log.info("Open Personal Update Page");
		caP = new CreateAccountPage(driver);
		
		test.log(LogStatus.INFO, "Save Updated Information");
		log.info("Save Updated Information");
		caP.doUpdate();
		caP.btnSave();
		
		test.log(LogStatus.INFO, "Verified the test result");
		log.info("Verified the test result");
		String actual = myacc.successmsg();
		Assert.assertTrue(actual.contains("successfully updated"));
		
		test.log(LogStatus.INFO, "Let's go back home");
		log.info("Let's go back home");
		myacc.doLogout();
	}
	
	
	@Test(priority = 3, description = "sample login data")
	public void reverseLogin() {

		test.log(LogStatus.INFO, "TC008_MyPersonalInformation");
		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "Landing at Home!!!");
		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");

		logP = new LoginPage(driver);
		test.log(LogStatus.INFO, "At Login Page");
		logP.doLogin("a11@a11.com", "54321");
		test.log(LogStatus.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");
	}
	
	@Test(priority = 4, description = "Reverse the password to test personal information changing")
	public void reverseMyInformation() {

		myacc = new MyAccountPage(driver);
		myacc.btnInformation();
		test.log(LogStatus.INFO, "Clicked My Personal Information");
		log.info("Clicked My Personal Information ");

		test.log(LogStatus.INFO, "Open Personal Update Page");
		log.info("Open Personal Update Page");
		caP = new CreateAccountPage(driver);
		
		test.log(LogStatus.INFO, "Save Updated Information");
		log.info("Save Updated Information");
		caP.reverseUpdate();
		caP.btnSave();
		
		test.log(LogStatus.INFO, "Verified the test result");
		log.info("Verified the test result");
		String actual = myacc.successmsg();
		Assert.assertTrue(actual.contains("successfully updated"));
		
	}
	

	@AfterTest
	public void tearDown() {
		log.info("Close browser");
		test.log(LogStatus.INFO, "Close browser");
		driver.quit();
		log.info("Post-condition ");
		test.log(LogStatus.INFO, "Post-condition ");
		report.endTest(test);
		test.log(LogStatus.INFO, "Erase the previous data on the report");
		log.info("Erase the previous data on the report");
		report.flush();
	}

}
