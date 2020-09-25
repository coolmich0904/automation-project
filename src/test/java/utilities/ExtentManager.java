package utilities;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance() {

		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/ExtentReports/";

		new File(directory).mkdirs();

		String path = directory + fileName;

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);

		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Test Result");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Irene");
		extent.setSystemInfo("Company", "busyQA");
		extent.setSystemInfo("Build", "Maven");

		return extent;
	}

	public static String getReportName() {
		Date d = new Date();
		String fileName = "AutomationReport_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return fileName;
	}

}
