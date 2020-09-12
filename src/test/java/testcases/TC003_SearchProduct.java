package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.LandingPage;
import pages.ProductsPage;
import utilities.ExtentManager;

public class TC003_SearchProduct extends BaseClass {

	LandingPage landP;
	ProductsPage productsP;
	JavascriptExecutor jse;
	
	ExtentReports report;
	ExtentManager extentmanager;
	ExtentTest test;

	@BeforeTest
	public void setup() {
		report = new ExtentReports(
				"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\reports\\TC003_SearchProduct.html");
		test = report.startTest("Search Product");
		driver.get("http://automationpractice.com");
	}

	@Test
	public void searchProduct() {

		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "TC003_SearchProduct");
		landP.doSearch();
		test.log(LogStatus.INFO, "Searched products");
		productsP = new ProductsPage(driver);
		test.log(LogStatus.INFO, "Open Products page");
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(250,450)");
		test.log(LogStatus.INFO, "Scroll down");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		productsP.selectQuickView();
		test.log(LogStatus.INFO, "Display Quick View");

		landP.pause(3000);
		String actual = driver.getTitle();
		String expected = "Search - My Store";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.INFO, "Verified Search function");

		productsP.clzFancyBox();
		test.log(LogStatus.INFO, "Closed Quick view");

		productsP.showList();
		test.log(LogStatus.INFO, "Display List View");
		landP.pause(3000);
		productsP.pDetails();
		test.log(LogStatus.INFO, "Display Product Details");
		landP.pause(3000);
		actual = driver.getTitle();
		expected = "Printed Dress - My Store";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.INFO, "TC003_SearchProduct : completed and passed!!!");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
