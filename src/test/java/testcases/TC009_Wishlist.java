package testcases;

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
import pages.PaymentPage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;
import utilities.ExtentManager;

@Listeners(utilities.ExtentListeners.class)
public class TC009_Wishlist extends BaseClass {

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
		report = new ExtentReports("C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC009_Wishlist.html");
		test = report.startTest("Wishlist");
	}

	@Test(priority = 1, description = "sample login data")
	public void login() {

		test.log(LogStatus.INFO, "TC009_Wishlist");
		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		
		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");
		log.info("Clicked Signin");
		
		test.log(LogStatus.INFO, "Open Login Page");
		log.info("Open Login Page!!!");
		logP = new LoginPage(driver);

		logP.doLogin("a12@a12.com", "12345");
		test.log(LogStatus.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");
	}

	@Test(priority = 2, description = "Add wishlist in dynamic table")
	public void wishList() throws Exception {

		test.log(LogStatus.INFO, "Open My Account Page");
		log.info("Open My Account Page");
		myacc = new MyAccountPage(driver);

		myacc.addWishList();
		myacc.btnsave();
		test.log(LogStatus.INFO,
				"Clicked wishlist and in the test box - Printed Chiffon Dress - Added a product into Wishlist");
		log.info("Clicked wishlist and in the test box - Printed Chiffon Dress - Added a product into Wishlist");

		test.log(LogStatus.INFO, "scroll down");
		log.info("Scroll Down");
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(250, 500)");

		test.log(LogStatus.INFO, "Waiting for the loading of the wishlist");
		log.info("Waiting for the loading of the wishlist");
		Thread.sleep(3000);

		test.log(LogStatus.INFO, "Confirm to updated wishlist table by adding a product");
		log.info("Confirm to updated wishlist table by adding a product");
		Thread.sleep(3000);
		expected = "Printed Chiffon Dress";
		actual = myacc.tablewishlist();
		System.out.println(actual);
		Assert.assertTrue(actual.contains(expected));

		test.log(LogStatus.INFO, "Try to remove the added product");
		log.info("Try to remove the added product");
		myacc.btnremove();
		System.out.println("deleted");

		test.log(LogStatus.INFO, "Confirm the alert about the removing");
		log.info("Confirm the alert about the removing");
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		test.log(LogStatus.INFO, "I am going back to My Account Page");
		log.info("I am going back to My Account Page");
		myacc.goMyAccount();

	}

	@AfterTest
	public void tearDown() {
		log.info("Close browser");
		driver.quit();
		log.info("Post-condition ");
		report.endTest(test);
		log.info("erase the previous data on the report");
		report.flush();
	}

}
