package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.ContactPage;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.ExtentManager;


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

	@BeforeMethod
	public void setup() {

		report = new ExtentReports();
		test = report.createTest("TC010 Contact");
	}

	@Test(description = "Contact - send an email to the company and file upload")
	public void fileUpload() {

		test.log(Status.INFO, "TC010_Contact");
		landP = new LandingPage(driver);
		test.log(Status.INFO, "Landing at Home!!!");
		log.info("Landing at HOME");

		landP.doClick();
		test.log(Status.INFO, "Clicked Signin button");
		log.info("Clicked Signin");

		test.log(Status.INFO, "Open Login Page");
		log.info("Open Login Page");
		logP = new LoginPage(driver);

		logP.doLogin("a12@a12.com", "12345");
		test.log(Status.INFO, "Entered Email and Password");
		log.info("Enter Email and submit to register");

		test.log(Status.INFO, "Open Contact Page");
		log.info("Open Contact Page");
		con = new ContactPage(driver);
		con.btnContact();
		test.log(Status.INFO, "Clicked Contact");
		log.info("Clicked Contact");

		
		con.selectSubject();
		test.log(Status.INFO, "Chose the subject of the message - Customer service");
		log.info("Chose the subject of the message - Customer service");

		con.btnMsg();
		test.log(Status.INFO, "Entered Messages");
		log.info("Entered Messages");

		con.chooseFile();
		test.log(Status.INFO, "Chosen a file to upload");
		log.info("Chosen a file to upload");

		con.btnSend();
		test.log(Status.INFO, "Submitted the message");
		log.info("Submitted the message");
		
		test.log(Status.INFO, "Verified the test result");
		log.info("Verified the test result");
		String actual = con.successMsg();
		Assert.assertTrue(actual.contains("successfully"));
		

	}

	@AfterTest
	public void tearDown() {
		
		test.log(Status.INFO, "Close Browser");
		log.info("Close browser");
		driver.quit();
		test.log(Status.INFO, "Post-Condition");
		log.info("Post-condition ");
		test.log(Status.INFO, "Erase the previous data on the report");
		log.info("Erase the previous data on the report");
		report.flush();
	}

}
