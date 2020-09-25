package smoke;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.ShoppingCartPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductDetailsPage;
import pages.PaymentPage;
import utilities.ExtentManager;


public class TC005_BuyProduct extends BaseClass {

	LandingPage landP;
	LoginPage logP;
	MyAccountPage myacc;
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
		test = report.createTest("TC005 Buy Product");
	}

	@Test(priority = 1, description = "sample login")
	public void login() {

		test.log(Status.INFO, "TC005_login process");
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

	@Test(priority = 3, description = "The test shows whole workflow to buy products")
	public void buyProducts() {

		test.log(Status.INFO, "Buy products workflows");
		test.log(Status.INFO, "Yeah! I came into My Account page");
		log.info("Open MyAccount Page");
		myacc = new MyAccountPage(driver);

		test.log(Status.INFO, "Welcome Home!!");
		log.info("Welcome HOME!!");
		myacc.gohome();

		test.log(Status.INFO, "Let's scroll down a little bit");
		log.info("Scroll down");
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(250,550)");

		// landP.pause(3000);
		landP.bestSeller();
		test.log(Status.INFO, "tried to find BestSeller items");
		log.info("Clicked BestSeller Tab");
		// landP.pause(1000);

		landP.pickProd();
		test.log(Status.INFO, "I wanted this because she said PICK ME UP");
		log.info("Selected a product");

		test.log(Status.INFO, "I jumped into Product Details Page");
		log.info("Yeah! I came into the product Detailed page");
		dprodP = new ProductDetailsPage(driver);

		test.log(Status.INFO, "Let's scroll down a little bit once more");
		log.info("Scroll down one more time");
		jse.executeScript("window.scrollBy(250,550)");

		// landP.pause(2000);
		dprodP.selectSize();
		test.log(Status.INFO, "I need a midium size");
		log.info("Selected size M");
		// landP.pause(2000);

		dprodP.color();
		test.log(Status.INFO, "Love White Color!!");
		log.info("Selected White color");
		landP.pause(2000);

		dprodP.addCart();
		test.log(Status.INFO, "The item has been added in the shopping cart");
		log.info("Added the item in the shopping cart");

		dprodP.checkout();
		test.log(Status.INFO, "try to check out");
		log.info("Checkout");
		// landP.pause(2000);

		test.log(Status.INFO, "Go Go Sing Shopping Cart!!");
		log.info("Go Go Sing Shopping Cart!!");
		cp = new ShoppingCartPage(driver);

		jse.executeScript("window.scrollBy(250,550)");
		test.log(Status.INFO, "down down");
		log.info("Scroll down");

		cp.increaseQty();
		test.log(Status.INFO, "I need one more because of my sister");
		log.info("Added one more quantity");

		cp.checkout();
		test.log(Status.INFO, "Checkout shopping cart");
		log.info("Checkout the shopping cart");

		payP = new PaymentPage(driver);
		test.log(Status.INFO, "Wow, finally Payment Page");
		log.info("Wow, finally Payment Page");

		// Address section
		payP.txtBox();
		test.log(Status.INFO, "I wrote a specific request");
		log.info("Write a specific request");

		payP.btnAddCheckout();
		test.log(Status.INFO, "passed Address section");
		log.info("Done Address setting");

		// Shipping section
		jse.executeScript("window.scrollBy(250,450)");
		test.log(Status.INFO, "down down");
		log.info("Scroll down");

		payP.checkbox();
		test.log(Status.INFO, "Ticked the checkbox");
		log.info("Checked Terms of Service agreement");

		payP.btnshippingCheckout();
		test.log(Status.INFO, "Passed Shipping section");
		log.info("Proceed checkout");

		// Payment section
		jse.executeScript("window.scrollBy(250,450)");
		test.log(Status.INFO, "down a little bit");
		log.info("Scroll down");

		payP.payment();
		test.log(Status.INFO, "Selected the Payment Option");
		log.info("Selected Payment option");

		// Order Confirm Section
		jse.executeScript("window.scrollBy(250,450)");
		test.log(Status.INFO, "a little bit down");
		log.info("Scroll down");

		test.log(Status.INFO, "Pay the Order");
		log.info("Pay the order");
		payP.btnConfirm();

		landP.pause(2000);
		test.log(Status.INFO, "Test verify using title");
		log.info("Assert with title name");
		actual = driver.getTitle();
		expected = "Order confirmation - My Store";
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
