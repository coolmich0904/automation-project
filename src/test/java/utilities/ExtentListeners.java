package utilities;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;

public class ExtentListeners extends BaseClass implements ITestListener, ISuiteListener {

	utilities.Screenshot scr;
	
	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	private static ExtentReports extent = ExtentManager
			.createInstance(System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\" + fileName);

	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "  : " + result.getMethod().getMethodName());
		testReport.set(test);
		System.out.println("*****   Test Started : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");

		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
		System.out.println("Test Failed : " + result.getName());
		scr = new utilities.Screenshot();
		try {
			Screenshot.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onFinish(ITestContext context) {

		if (extent != null) {
			extent.flush();
		}
		Markup m = MarkupHelper.createLabel("Test Finished", ExtentColor.BLUE);
		testReport.get().log(Status.INFO, m);
		System.out.println("*****   Test Finished : " + context.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		//test.log(LogStatus.PASS, "SUCCESS");
		Markup m = MarkupHelper.createLabel("Test Successed", ExtentColor.GREEN);
		testReport.get().log(Status.PASS, m);
		System.out.println("*****   Test Successed : " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(LogStatus.SKIP, "Test Skipped");
		Markup m = MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE);
		testReport.get().log(Status.SKIP, m);
		System.out.println("*****   Test Skipped : " + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {

		
		
	}

}
