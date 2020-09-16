package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.BaseClass;
import pages.CategoriesPage;
import pages.LandingPage;
import pages.ProductsPage;
import utilities.ExtentManager;

public class TC006_Catalog extends BaseClass {

	LandingPage landP;
	CategoriesPage catP;
	JavascriptExecutor jse;
	
	ExtentReports report;
	ExtentManager extentmanager;
	ExtentTest test;
	
	@BeforeTest
	public void setup() {
		report = utilities.ExtentManager.createInstance("C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\reports\\TC004_BuyProduct.html");
		test = report.createTest("TC006_Catalog");
	}
	
	@Test
	public void catalogTest() {
		
		test.log(Status.INFO, "TC005_Invoice");
		landP = new LandingPage(driver);
		test.log(Status.INFO, "Landing at Home!!!");
		landP.menuTab1();
		test.log(Status.INFO, "Clicked Woman tab");
		
		catP = new CategoriesPage(driver);
		catP.sizeOption3();
		landP.pause(3000);
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(260, 350)");
		
		catP.rangeSlider();
		landP.pause(3000);
	}
}
