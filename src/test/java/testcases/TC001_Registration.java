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
				"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\reports\\TC001_Registration.html");
		test = report.startTest("File Download Test");
		driver.get("http://automationpractice.com");
	}

	@Test(priority = 1)
	public void register() {

		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "TC001-REGISTERATION");
		test.log(LogStatus.INFO, "Landing at Home!!!");
		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");
		logP = new LoginPage(driver);
		test.log(LogStatus.INFO, "At Login Page");
		logP.doRegister("hm009@gmail.com");
		test.log(LogStatus.INFO, "Entered Email to register");

		caP = new CreateAccountPage(driver);

		caP.doRegister();
		test.log(LogStatus.INFO, "Created a New Account!!");
		actual = driver.getTitle();
		expected = "My account - My Store";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.INFO,"test completed and passed!!!");
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
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
