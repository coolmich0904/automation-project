package testcases;

import java.util.concurrent.TimeUnit;

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
import pages.CategoriesPage;
import pages.LandingPage;
import pages.ProductsPage;

@Listeners(utilities.ExtentListeners.class)
public class TC002_SearchProduct extends BaseClass {

	LandingPage landP;
	ProductsPage productsP;
	CategoriesPage catP;
	JavascriptExecutor jse;

	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void setup() {

		report = new ExtentReports("C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC002_SearchProduct.html");
		test = report.startTest("Search Product");

	}

	@Test(description = "Using Serch box, find products, hidden QuickView (size,color)/ see the datails")
	public void searchProduct() {

		test.log(LogStatus.INFO, "TC002_SearchProduct");
		test.log(LogStatus.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP = new LandingPage(driver);

		test.log(LogStatus.INFO, "Enter Serach keyword - printed");
		log.info("Enter Serach keyword - printed");
		landP.doSearch();

		log.info("Open Product Page as the result of the serch");
		test.log(LogStatus.INFO, "Open Product Page as the result of the serch");
		productsP = new ProductsPage(driver);

		test.log(LogStatus.INFO, "Scroll down");
		log.info("Scroll down");
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(250,450)");

		test.log(LogStatus.INFO, "Global wait");
		log.info("Global wait");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		productsP.selectQuickView();
		test.log(LogStatus.INFO, "Displayed Quick View");
		log.info("Quick view displayed");

		// landP.pause(3000);
		String actual = driver.getTitle();
		String expected = "Search - My Store";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.INFO, "Verified Search function");
		log.info("Verified!!");

		productsP.clzFancyBox();
		test.log(LogStatus.INFO, "Closed Quick view");
		log.info("Closed Quick View");

		productsP.showList();
		test.log(LogStatus.INFO, "Display List View");
		log.info("Listview displayed");
		// landP.pause(3000);
		productsP.pDetails();
		test.log(LogStatus.INFO, "Display Product Details");
		log.info("Shoes Product details");
		// landP.pause(3000);
		actual = driver.getTitle();
		expected = "Printed Dress - My Store";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.INFO, "TC003_SearchProduct : completed and passed!!!");
		log.info("TC003_SearchProduct : completed and passed!!!");

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
