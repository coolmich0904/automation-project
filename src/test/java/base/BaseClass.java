package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.ExtentManager;

public class BaseClass {
	public static WebDriver driver = null;
	public static Properties config = new Properties();
	
	//public ExtentReports rep = ExtentManager.createInstance();
	public static ExtentTest test;
	
	
	
	@BeforeSuite()
	public void init() throws IOException {
		if (driver == null) {
			FileInputStream fs = new FileInputStream(
					"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\properties\\config.properties");
			config.load(fs);

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver",
						"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\executables\\msedgedriver.exe");
				driver = new EdgeDriver();
			}

			driver.get(config.getProperty("testsiteURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	@AfterSuite()
	public void teardown() throws IOException {
		if (driver != null) {
			driver.quit();
		}
	}

}
