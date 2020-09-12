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
import pages.ShoppingCartPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductDetailsPage;
import pages.PaymentPage;
import utilities.ExtentManager;

public class TC004_BuyProduct extends BaseClass {
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

	@BeforeTest
	public void setup() {
		report = new ExtentReports(
				"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\reports\\TC004_BuyProduct.html");
		test = report.startTest("Buyh Products");
		driver.get("http://automationpractice.com");
	}

	@Test(priority = 0)
	public void login() {
		test.log(LogStatus.INFO, "TC004_BuyProduct");
		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "Landing at Home!!!");
		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");
		logP = new LoginPage(driver);
		test.log(LogStatus.INFO, "At Login Page");
		logP.doLogin("a11@a11.com", "12345");
		test.log(LogStatus.INFO, "Entered Email and Password");
	}

	@Test(priority = 3)
	public void buyProducts() {

		myacc = new MyAccountPage(driver);
		test.log(LogStatus.INFO, "Yeah! I came into My Account page");
		myacc.gohome();
		test.log(LogStatus.INFO, "Welcome Home!!");
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(250,550)");
		test.log(LogStatus.INFO, "Let's scroll down a little bit");
		landP.pause(3000);
		landP.bestSeller();
		test.log(LogStatus.INFO, "tried to find BestSeller items");
		landP.pause(1000);
		landP.pickProd();
		test.log(LogStatus.INFO, "I wanted this because she said PICK ME UP");

		dprodP = new ProductDetailsPage(driver);
		test.log(LogStatus.INFO, "I jumped into Product Details Page");
		jse.executeScript("window.scrollBy(250,550)");
		test.log(LogStatus.INFO, "A little bit go down");
		landP.pause(2000);
		dprodP.selectSize();
		test.log(LogStatus.INFO, "I need a midium size");
		landP.pause(2000);
		dprodP.color();
		test.log(LogStatus.INFO, "Love White Color!!");
		landP.pause(2000);

		dprodP.addCart();
		test.log(LogStatus.INFO, "The item has been added in the shopping cart");
		dprodP.checkout();
		test.log(LogStatus.INFO, "try to check out");
		landP.pause(2000);

		cp = new ShoppingCartPage(driver);
		test.log(LogStatus.INFO, "Go Go Sing Shopping Cart!!");
		jse.executeScript("window.scrollBy(250,550)");
		test.log(LogStatus.INFO, "down down");
		cp.increaseQty();
		test.log(LogStatus.INFO, "I need one more because of my sister");
		cp.checkout();
		test.log(LogStatus.INFO, "Checkout shopping cart");

		payP = new PaymentPage(driver);
		test.log(LogStatus.INFO, "Wow, finally Payment Page");
		// Address section
		payP.txtBox();
		test.log(LogStatus.INFO, "I wrote a specific request");
		payP.btnAddCheckout();
		test.log(LogStatus.INFO, "passed Address section");

		// Shipping section
		jse.executeScript("window.scrollBy(250,450)");
		payP.checkbox();
		test.log(LogStatus.INFO, "Ticked the checkbox");
		payP.btnshippingCheckout();
		test.log(LogStatus.INFO, "passed Shipping section");

		// Payment section
		jse.executeScript("window.scrollBy(250,450)");
		test.log(LogStatus.INFO, "down a little bit");
		payP.payment();
		test.log(LogStatus.INFO, "Selected the Payment Option");
		// Order Confirm Section
		jse.executeScript("window.scrollBy(250,450)");
		test.log(LogStatus.INFO, "a little bit down");
		payP.btnConfirm();
		test.log(LogStatus.INFO, "Paid the Order");

		landP.pause(2000);
		actual = driver.getTitle();
		expected = "Order confirmation - My Store";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.INFO, "TC004_BuyProduct: completed and passed!!!");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
