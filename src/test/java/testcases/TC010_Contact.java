package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.ContactPage;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.ExtentManager;

@Listeners(utilities.ExtentListeners.class)
public class TC010_Contact extends BaseClass {

	ExtentReports report;
	ExtentManager extentmanager;
	ExtentTest test;

	LandingPage landP;
	LoginPage logP;
	CreateAccountPage caP;
	MyAccountPage myacc;
	ContactPage con;
	String actual, expected;

	@BeforeTest
	public void setup() {
		report = new ExtentReports("C:\\eclipse-workspace\\qaProject1\\resources\\reports\\TC002_VerifyLogin.html");
		test = report.startTest("Contact");
	}

	@Test(description = "Contact - send an email to the company and file upload")
	public void fileUpload() {

		test.log(LogStatus.INFO, "TC010_Contact");
		landP = new LandingPage(driver);
		test.log(LogStatus.INFO, "Landing at Home!!!");
		log.info("Landing at HOME");

		landP.doClick();
		test.log(LogStatus.INFO, "Clicked Signin button");
		log.info("Clicked Signin");

		test.log(LogStatus.INFO, "Open Login Page");
		log.info("Open Login Page");
		logP = new LoginPage(driver);

		logP.doLogin("a12@a12.com", "12345");
		test.log(LogStatus.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");

		test.log(LogStatus.INFO, "Open Contact Page");
		log.info("Open Contact Page");
		con = new ContactPage(driver);
		con.btnContact();
		test.log(LogStatus.INFO, "Clicked Contact");
		log.info("Clicked Contact");

		
		con.selectSubject();
		test.log(LogStatus.INFO, "Chose the subject of the message - Customer service");
		log.info("Chose the subject of the message - Customer service");

		con.btnMsg();
		test.log(LogStatus.INFO, "Entered Messages");
		log.info("Entered Messages");

		con.chooseFile();
		test.log(LogStatus.INFO, "Chosen a file to upload");
		log.info("Chosen a file to upload");

		con.btnSend();
		test.log(LogStatus.INFO, "Submitted the message");
		log.info("Submitted the message");

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
