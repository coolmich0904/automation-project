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
//	public static Logger log = Logger.getLogger(BaseClass.class);
	public static ExtentTest test;
	public static ExtentReports report;
	public static ExtentManager extentmanager;
		
	@BeforeSuite()
	public void init() throws IOException {		
		
				
		if (driver == null) {
			FileInputStream fs = new FileInputStream(
					"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\properities\\config.properities");
			config.load(fs);

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\exucutable\\chromedriver.exe");
				driver = new ChromeDriver();
				//test.log(LogStatus.INFO, "Using Chrome Browser");
				//log.info("Open Chrome Browser");
			} 
			else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\eclipse-workspace\\qaProject1\\resources\\exucutable\\geckodriver.exe");
				driver = new FirefoxDriver();
				//test.log(LogStatus.INFO, "Using Gecko Driver");
				//log.info("Open Firefox Browser");
			} 
			else if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver",
						"");
				driver = new EdgeDriver();
				//test.log(LogStatus.INFO, "Using Edge Driver");
				//log.info("Open Edge Browser");
			}

			driver.get(config.getProperty("testsiteURL"));
			//test.log(LogStatus.INFO, "Brough the website URL");
			driver.manage().window().maximize();
			//test.log(LogStatus.INFO, "Maximixed the Window size");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//test.log(LogStatus.INFO, "Global implicit wait");
		}
	}

	@AfterSuite()
	public void teardown() throws IOException {
		if (driver != null) {
			//test.log(LogStatus.INFO, "Closing Browser");
			driver.quit();			
		}
	}

}
