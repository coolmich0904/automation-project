package regression;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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

public class TC002_VerifyLogin extends BaseClass {

	ExtentReports report;
	ExtentManager extentmanager;
	ExtentTest test;

	LandingPage landP;
	LoginPage logP;
	MyAccountPage myacc;
	String actual, expected;
	
	
	@BeforeTest
	public void setup() {
		report = new ExtentReports(
				"C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC002_VerifyLogin.html");
		test = report.startTest("TC002 Verify Login");
	}

	@Test(dataProvider = "logindata")
	public void VerifyLogin(String myEmail, String passwd) {

		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "Landing at Home!!!");
		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");
//		log.info("Sign in button clicked");
		logP = new LoginPage(driver);
		test.log(LogStatus.INFO, "At Login Page");
		logP.doLogin(myEmail, passwd);
		test.log(LogStatus.INFO, "Entered Email and Password");
		
		actual = driver.getTitle();
		expected = "My account - My Store";
		Assert.assertEquals(actual, expected);
				
		myacc = new MyAccountPage(driver);
		test.log(LogStatus.INFO, "TC002_VerifyLogin : completed and passed!!!");
//		log.info("Logout");
		myacc.doLogout();		
		landP.pause(2000);
	}

	
	@DataProvider(name = "logindata")
	public Object[][] getData() {
		String excelPath = "C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\excel\\profile.xlsx";
		
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	
	
	public Object[][] testData (String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();		
		
		Object data[][] =  new Object[rowCount-1][colCount-1];
		
		for(int i = 1; i < rowCount; i++) {
			for(int j = 1; j < colCount; j++) {
				
				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData + " | " );
				data[i-1][j-1] = cellData;
			}
			System.out.println();
		}
		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
