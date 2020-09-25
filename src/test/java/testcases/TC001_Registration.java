package testcases;

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
		report = new ExtentReports("C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC001_Registration.html");
		test = report.startTest("Registration");
	}

	@Test(priority = 1, description = "Create Account workflow : On Landing page, verify Email. Then Input User's Information and submit")
	public void register() {

		test.log(LogStatus.INFO, "TC001_Registration");
		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");
		log.info("Clicked Signin");

		test.log(LogStatus.INFO, "Open Login Page");
		log.info("Open Login Page!!!");
		logP = new LoginPage(driver);

		logP.doRegister("toto007@gmail.com");
		test.log(LogStatus.INFO, "Entered Email and submit to register");
		log.info("Enter Email and submit to register");

		test.log(LogStatus.INFO, "Open CreateAccount Page");
		log.info("Open CreateAccount Page!!!");
		caP = new CreateAccountPage(driver);

		test.log(LogStatus.INFO, "Fill out the registration form");
		log.info("Filled out the registration form");
		caP.doRegister();
		landP.pause(10000);
		test.log(LogStatus.INFO, "Created a New Account!!");
		log.info("Created a New Account!!");

		test.log(LogStatus.INFO, "Test verify using title");
		log.info("Assert with title name");
		actual = driver.getTitle();
		expected = "My account - My Store";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 2, description = "confirm to create the account")
	public void logout() {

		test.log(LogStatus.INFO, "Open MyAccount Page");
		log.info("Open MyAccount Page!!!");
		myacc = new MyAccountPage(driver);

		myacc.doLogout();
		test.log(LogStatus.INFO, "Logout. Bye~");
		log.info("Logout !!!");
		landP.pause(2000);

		test.log(LogStatus.INFO, "Test verify using title");
		log.info("Assert with title name");
		actual = driver.getTitle();
		expected = "Login - My Store";
		Assert.assertEquals(actual, expected);

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
