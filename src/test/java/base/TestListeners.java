package base;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utilities.ExtentManager;


public class TestListeners implements ITestListener {


	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	private static ExtentReports extent = ExtentManager.createInstance();

	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "  :: " + result.getMethod().getMethodName());
		testReport.set(test);
		System.out.println("*****   Test Started : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>\n"
						+ " \n");
		
		WebDriver driver = BaseClass.driver;
		String path = takeScreenshot(driver, result.getMethod().getMethodName());
		
		try {
			testReport.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>");
			MediaEntityBuilder.createScreenCaptureFromPath(path).build();
		} catch (IOException e) {
			testReport.get().fail("Test Failed, can't attach screenshot");
		}
	
		String failureLogg = "<b>Test Method " + methodName + " FAILED</b>";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
		System.out.println("Test Failed : " + result.getName());
		
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

		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " SUCCESSFUL<b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().log(Status.PASS, m);
		System.out.println("*****   Test Successed : " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {

		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " SKIPPED<b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		testReport.get().log(Status.SKIP, m);
		System.out.println("*****   Test Skipped : " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public String takeScreenshot(WebDriver driver, String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenscaptures/";
		
		new File(directory).mkdirs();
		String path = directory + fileName;
		
		
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			
			System.out.println("*********************************************** ");
			System.out.println("Screenshot saved at " + path);
			System.out.println("*********************************************** ");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
		
	}

	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}

}
