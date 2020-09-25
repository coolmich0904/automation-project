package regression;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
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
import pages.MyAddress;
import utilities.ExtentManager;

@Listeners(utilities.ExtentListeners.class)
public class TC007_MyAddresses extends BaseClass {

	LandingPage landP;
	LoginPage logP;
	MyAccountPage myacc;
	CreateAccountPage caP;
	MyAddress add;

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

		test.log(LogStatus.INFO, "TC007_MyAddresses");
		test.log(LogStatus.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP = new LandingPage(driver);

		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");
		log.info("Clicked Signin");

		logP = new LoginPage(driver);
		test.log(LogStatus.INFO, "At Login Page");
		log.info("Open Login Page!!!");

		logP.doLogin("a11@a11.com", "54321");
		test.log(LogStatus.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");
	}

	@Test(priority = 2, description = "Edit My Address - State")
	public void UpdateAddress() {

		myacc = new MyAccountPage(driver);
		myacc.btnAddress();
		test.log(LogStatus.INFO, "Clicked My Addresses");
		log.info("Clicked My Addresse");

		add = new MyAddress(driver);
		test.log(LogStatus.INFO, "Opened My Addresses Page");
		log.info("Opened My Addresses Page");

		test.log(LogStatus.INFO, "Let's scroll down a little bit");
		log.info("Scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(250, 500)");

		add.btnMyUpdate();
		test.log(LogStatus.INFO, "Clicked Updatebutton of my Address");
		log.info("Clicked Updatebutton of my Address");

		add.myAddressUpdate("New York");
		add.btnSave();
		test.log(LogStatus.INFO, "Updated the state");
		log.info("Updated the state");

		test.log(LogStatus.INFO, "Back to My Addresses Page");
		log.info("Back to My Addresses Page");
		landP.pause(2000);
	}

	@Test(priority = 3, description = "Add a new Address")
	public void addNewAddress() {

		add.btnAddNew();
		test.log(LogStatus.INFO, "Clicked Add a New Address");
		log.info("Clicked Add a New Address");
		
		add.newAddress();
		add.btnSave();
		test.log(LogStatus.INFO, "Added a New Address for My Sister");
		log.info("Added a New Address for My Sister");

		test.log(LogStatus.INFO, "When the last item displays, the test is successful!");
		log.info("When the last item displays, the test is successful!");
		boolean actual = add.addressItem();
		Assert.assertTrue(actual);

		landP.pause(2000);
	}

	@Test(priority = 6, description = "Delete the New Added Address")
	public void delNewAddress() {

		test.log(LogStatus.INFO, "Delete the New Added Address");
		log.info("Delete the New Added Address");
		add.btnRemove();

		driver.switchTo().alert().accept();

		test.log(LogStatus.INFO, "When the last item displays, the test is FAILURE!");
		log.info("When the displays, the test is FAILURE!");
		boolean actual = add.afterRemovedItem();
		Assert.assertTrue(actual);

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