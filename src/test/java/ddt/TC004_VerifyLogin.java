package ddt;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;

import utilities.ExcelUtils;
import utilities.ExtentManager;

@Listeners(utilities.ExtentListeners.class)
public class TC004_VerifyLogin extends BaseClass {

	ExtentReports report;
	ExtentManager extentmanager;
	ExtentTest test;

	LandingPage landP;
	LoginPage logP;
	MyAccountPage myacc;
	String actual, expected;

	@BeforeTest
	public void setup() {
		report = new ExtentReports("C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC004_VerifyLogin.html");
		test = report.startTest("Verify Login");
	}

	@Test(dataProvider = "logindata", description = "To verify User Account, Read data from Excel and use the data ")
	public void VerifyLogin(String myEmail, String passwd) {

		test.log(LogStatus.INFO, "TC004_VerifyLogin");
		test.log(LogStatus.INFO, "Landing at Home!!!");
		log.info("Landing At HOME!!!");
		landP = new LandingPage(driver);

		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");
		log.info("Sign in button clicked");

		test.log(LogStatus.INFO, "Open Login Page");
		log.info("Open Login Page!!!");
		logP = new LoginPage(driver);
		test.log(LogStatus.INFO, "At Login Page");

		test.log(LogStatus.INFO, "Entered Email and Password");
		log.info("Entered Email and Password");
		logP.doLogin(myEmail, passwd);

		test.log(LogStatus.INFO, "Test verify using title");
		log.info("Assert with title");
		actual = driver.getTitle();
		expected = "My account - My Store";
		Assert.assertEquals(actual, expected);

		test.log(LogStatus.INFO, "Open MyAccount Page");
		log.info("Open MyAccount Page!!!");
		myacc = new MyAccountPage(driver);

		test.log(LogStatus.INFO, "Logout. Bye~");
		log.info("Logout !!!");
		myacc.doLogout();

	}

	@DataProvider(name = "logindata")
	public Object[][] getData() {
		String excelPath = "C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\excel\\profile.xlsx";

		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}

	public Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object[rowCount - 1][colCount - 1];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 1; j < colCount; j++) {

				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData + " | ");
				data[i - 1][j - 1] = cellData;
			}
			System.out.println();
		}
		return data;
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
