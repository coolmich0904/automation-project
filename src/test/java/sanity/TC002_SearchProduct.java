package sanity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.CategoriesPage;
import pages.LandingPage;
import pages.ProductsPage;


public class TC002_SearchProduct extends BaseClass {

	LandingPage landP;
	ProductsPage productsP;
	CategoriesPage catP;
	JavascriptExecutor jse;

	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void setup() {

		report = new ExtentReports();
		test = report.createTest("TC002 Search Product");

	}

	@Test(description = "Using Serch box, find products, hidden QuickView (size,color)/ see the datails")
	public void searchProduct() {

		test.log(Status.INFO, "TC002_SearchProduct");
		test.log(Status.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP = new LandingPage(driver);

		test.log(Status.INFO, "Enter Serach keyword - printed");
		log.info("Enter Serach keyword - printed");
		landP.doSearch();

		log.info("Open Product Page as the result of the serch");
		test.log(Status.INFO, "Open Product Page as the result of the serch");
		productsP = new ProductsPage(driver);

		test.log(Status.INFO, "Scroll down");
		log.info("Scroll down");
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(250,450)");

		test.log(Status.INFO, "Global wait");
		log.info("Global wait");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		productsP.selectQuickView();
		test.log(Status.INFO, "Displayed Quick View");
		log.info("Quick view displayed");

		// landP.pause(3000);
		String actual = driver.getTitle();
		String expected = "Search - My Store";
		Assert.assertEquals(actual, expected);
		test.log(Status.INFO, "Verified Search function");
		log.info("Verified!!");

		productsP.clzFancyBox();
		test.log(Status.INFO, "Closed Quick view");
		log.info("Closed Quick View");

		productsP.showList();
		test.log(Status.INFO, "Display List View");
		log.info("Listview displayed");
		// landP.pause(3000);
		productsP.pDetails();
		test.log(Status.INFO, "Display Product Details");
		log.info("Shoes Product details");
		// landP.pause(3000);
		actual = driver.getTitle();
		expected = "Printed Dress - My Store";
		Assert.assertEquals(actual, expected);
		test.log(Status.INFO, "TC003_SearchProduct : completed and passed!!!");
		log.info("TC003_SearchProduct : completed and passed!!!");

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
