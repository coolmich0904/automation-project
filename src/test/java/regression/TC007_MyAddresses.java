package regression;

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
import pages.MyAddress;
import utilities.ExtentManager;


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

	@BeforeMethod
	public void setup() {

		report = new ExtentReports();
		test = report.createTest("TC007 My Addressess CRUD ");
	}

	@Test(priority = 1, description = "sample login data")
	public void login() {

		test.log(Status.INFO, "TC007 login process");
		test.log(Status.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP = new LandingPage(driver);

		landP.doClick();
		test.log(Status.INFO, "Clicked Signin button");
		log.info("Clicked Signin");

		logP = new LoginPage(driver);
		test.log(Status.INFO, "At Login Page");
		log.info("Open Login Page!!!");

		logP.doLogin("a11@a11.com", "12345");
		test.log(Status.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");
	}

	@Test(priority = 2, description = "Edit My Address - State")
	public void UpdateAddress() {

		test.log(Status.INFO, "TC006 Update My Address Information");
		myacc = new MyAccountPage(driver);
		myacc.btnAddress();
		test.log(Status.INFO, "Clicked My Addresses");
		log.info("Clicked My Addresse");

		add = new MyAddress(driver);
		test.log(Status.INFO, "Opened My Addresses Page");
		log.info("Opened My Addresses Page");

		test.log(Status.INFO, "Let's scroll down a little bit");
		log.info("Scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(250, 500)");

		add.btnMyUpdate();
		test.log(Status.INFO, "Clicked Updatebutton of my Address");
		log.info("Clicked Updatebutton of my Address");

		add.myAddressUpdate("New York");
		add.btnSave();
		test.log(Status.INFO, "Updated the state");
		log.info("Updated the state");

		test.log(Status.INFO, "Back to My Addresses Page");
		log.info("Back to My Addresses Page");
		landP.pause(2000);
	}

	@Test(priority = 3, description = "Add a new Address")
	public void addNewAddress() {

		test.log(Status.INFO, "TC006 Add a New Address");
		add.btnAddNew();
		test.log(Status.INFO, "Clicked Add a New Address");
		log.info("Clicked Add a New Address");
		
		add.newAddress();
		add.btnSave();
		test.log(Status.INFO, "Added a New Address for My Sister");
		log.info("Added a New Address for My Sister");

		test.log(Status.INFO, "When the last item displays, the test is successful!");
		log.info("When the last item displays, the test is successful!");
		boolean actual = add.addressItem();
		Assert.assertTrue(actual);

		landP.pause(2000);
	}

	@Test(priority = 6, description = "Delete the New Added Address")
	public void delNewAddress() {

		test.log(Status.INFO, "TC006 Delete the New Added Address");
		log.info("Delete the New Added Address");
		add.btnRemove();

		driver.switchTo().alert().accept();

		test.log(Status.INFO, "When the last item displays, the test is FAILURE!");
		log.info("When the displays, the test is FAILURE!");
		boolean actual = add.afterRemovedItem();
		Assert.assertTrue(actual);

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