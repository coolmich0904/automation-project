package testcases;

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

	@BeforeMethod
	public void setup() {

		report = new ExtentReports();
		test = report.createTest("TC008 My Personal Information");
	}

	@Test(priority = 1, description = "sample login data")
	public void login() {

		test.log(Status.INFO, "TC008 login process");
		landP = new LandingPage(driver);
		test.log(Status.INFO, "Landing at Home!!!");
		landP.doClick();
		test.log(Status.INFO, "Clicked Signin button");

		logP = new LoginPage(driver);
		test.log(Status.INFO, "At Login Page");
		logP.doLogin("a11@a11.com", "12345");
		test.log(Status.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");
	}

	@Test(priority = 2, description = "Update or Edit Personal Information / demo - update password")
	public void myInformation() {

		test.log(Status.INFO, "TC008 Update MyPersonal Information");
		myacc = new MyAccountPage(driver);
		myacc.btnInformation();
		test.log(Status.INFO, "Clicked My Personal Information");
		log.info("Clicked My Personal Information ");

		test.log(Status.INFO, "Open Personal Update Page");
		log.info("Open Personal Update Page");
		caP = new CreateAccountPage(driver);
		
		test.log(Status.INFO, "Save Updated Information");
		log.info("Save Updated Information");
		caP.doUpdate();
		caP.btnSave();
		
		test.log(Status.INFO, "Verified the test result");
		log.info("Verified the test result");
		String actual = myacc.successmsg();
		Assert.assertTrue(actual.contains("successfully updated"));
		
		test.log(Status.INFO, "Let's go back home");
		log.info("Let's go back home");
		myacc.doLogout();
	}
	
	
	@Test(priority = 3, description = "sample login data")
	public void reverseLogin() {

		test.log(Status.INFO, "TC008 login process");
		landP = new LandingPage(driver);
		test.log(Status.INFO, "Landing at Home!!!");
		landP.doClick();
		test.log(Status.INFO, "Clicked Signin button");

		logP = new LoginPage(driver);
		test.log(Status.INFO, "At Login Page");
		logP.doLogin("a11@a11.com", "54321");
		test.log(Status.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");
	}
	
	@Test(priority = 4, description = "Reverse the password to test personal information changing")
	public void reverseMyInformation() {

		test.log(Status.INFO, "TC008 Update MyPersonal Information");
		myacc = new MyAccountPage(driver);
		myacc.btnInformation();
		test.log(Status.INFO, "Clicked My Personal Information");
		log.info("Clicked My Personal Information ");

		test.log(Status.INFO, "Open Personal Update Page");
		log.info("Open Personal Update Page");
		caP = new CreateAccountPage(driver);
		
		test.log(Status.INFO, "Save Updated Information");
		log.info("Save Updated Information");
		caP.reverseUpdate();
		caP.btnSave();
		
		test.log(Status.INFO, "Verified the test result");
		log.info("Verified the test result");
		String actual = myacc.successmsg();
		Assert.assertTrue(actual.contains("successfully updated"));
		
	}
	

	@AfterTest
	public void tearDown() {
		
		log.info("Close browser");
		test.log(Status.INFO, "Close browser");
		driver.quit();
		log.info("Post-condition ");
		test.log(Status.INFO, "Post-condition ");
		test.log(Status.INFO, "Erase the previous data on the report");
		log.info("Erase the previous data on the report");
		report.flush();
	}

}
