package testcases;

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
import utilities.ExtentManager;

public class TC001_Registration extends BaseClass {

	ExtentReports report;
	ExtentManager extentmanager;
	ExtentTest test;

	LandingPage landP;
	LoginPage logP;
	CreateAccountPage caP;
	MyAccountPage myacc;
	String actual, expected;

	@BeforeTest
	public void setup() {
		report = new ExtentReports(
				"C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC001_Registration.html");
		test = report.startTest("TC001 Registration");
	}

	@Test(priority = 1)
	public void register() {

		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "Landing at Home!!!");
		landP.doClick();		
		test.log(LogStatus.INFO, "Clicked Signin button");
//		log.info("Clicked Signin");
		
		logP = new LoginPage(driver);
		test.log(LogStatus.INFO, "At Login Page");
		logP.doRegister("hm018@gmail.com");
		test.log(LogStatus.INFO, "Entered Email and submit to register");
//		log.info("Enter Email and submit to register");

		caP = new CreateAccountPage(driver);
		caP.doRegister();
//		log.info("Filled out the registration form");
		test.log(LogStatus.INFO, "Created a New Account!!");
//		log.info("Created a New Account!!");
		
		actual = driver.getTitle();
		expected = "My account - My Store";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.INFO,"test completed and passed!!!");
//		log.info("Verified TC001");
	}

	@Test(priority = 2)
	public void logout() {
		myacc = new MyAccountPage(driver);
		myacc.doLogout();
		test.log(LogStatus.INFO, "Logout. Bye~");
		landP.pause(2000);
		actual = driver.getTitle();
		expected = "Login - My Store";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.INFO,"test completed and passed!!!");
//		log.info("TC001 Verified");
	}
	
	@AfterTest
	public void tearDown() {
//		log.info("Close browser");
		driver.quit();
//		log.info("Post-condition ");
		report.endTest(test);
//		log.info("erase the previous data on the report");
		report.flush();
	}
}
