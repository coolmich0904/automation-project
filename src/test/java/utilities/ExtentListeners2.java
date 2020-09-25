package utilities;

import java.io.IOException;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import base.BaseClass;

public class ExtentListeners2 extends BaseClass implements ITestListener, ISuiteListener {

	public 	String messageBody;
	
	public void onTestStart(ITestResult result) {

		test = rep.startTest(result.getName().toUpperCase());
		System.out.println("*****   Test Started : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		try {
			Screenshot.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Below is for extent report, it will attach screenshot in the extent report
				test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception : "+result.getThrowable());
				test.log(LogStatus.INFO, test.addScreenCapture(Screenshot.screenshotName));
				
				rep.endTest(test);
				rep.flush();
		
	}

	public void onFinish(ITestContext context) {

		if (rep != null) {
			rep.flush();
		}
		
		System.out.println("*****   Test Finished : " + context.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("*****   Test Successed : " + result.getName());
		//Below information will log into extent Report
				test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
				rep.endTest(test);
				rep.flush();
	}

	public void onTestSkipped(ITestResult result) {
		
		//below is for extent report
				test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
				rep.endTest(test);
				rep.flush();
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {

		
		
	}

}
