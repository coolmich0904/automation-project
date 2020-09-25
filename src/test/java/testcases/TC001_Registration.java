package testcases;

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

public class TC001_Registration extends BaseClass {

	ExtentReports report;
	ExtentManager extentmanager;
	ExtentTest test;

	LandingPage landP;
	LoginPage logP;
	CreateAccountPage caP;
	MyAccountPage myacc;
	String actual, expected;


	@BeforeMethod
	public void setup() {

		report = new ExtentReports();
		test = report.createTest("TC001 Registration");
	}

	@Test(priority = 1, description = "Create Account workflow : On Landing page, verify Email. Then Input User's Information and submit")
	public void register() {

		test.log(Status.INFO, "TC001_Registration");
		landP = new LandingPage(driver);
		test.log(Status.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP.doClick();
		test.log(Status.INFO, "Clicked Signin button");
		log.info("Clicked Signin");

		test.log(Status.INFO, "Open Login Page");
		log.info("Open Login Page!!!");
		logP = new LoginPage(driver);

		logP.doRegister("toto009@gmail.com");
		test.log(Status.INFO, "Entered Email and submit to register");
		log.info("Enter Email and submit to register");

		test.log(Status.INFO, "Open CreateAccount Page");
		log.info("Open CreateAccount Page!!!");
		caP = new CreateAccountPage(driver);

		test.log(Status.INFO, "Fill out the registration form");
		log.info("Filled out the registration form");
		caP.doRegister();
		landP.pause(10000);
		test.log(Status.INFO, "Created a New Account!!");
		log.info("Created a New Account!!");

		test.log(Status.INFO, "Test verify using title");
		log.info("Assert with title name");
		actual = driver.getTitle();
		expected = "My account - My Store";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 2, description = "confirm to create the account")
	public void logout() {

		test.log(Status.INFO, "TC001_Registration Confirmation");
		test.log(Status.INFO, "Open MyAccount Page");
		log.info("Open MyAccount Page!!!");
		myacc = new MyAccountPage(driver);

		myacc.doLogout();
		test.log(Status.INFO, "Logout. Bye~");
		log.info("Logout !!!");
		landP.pause(2000);

		test.log(Status.INFO, "Test verify using title");
		log.info("Assert with title name");
		actual = driver.getTitle();
		expected = "Login - My Store";
		Assert.assertEquals(actual, expected);

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
