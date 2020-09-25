


package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.ExtentManager2;



public class BaseClass {
	
	public static WebDriver driver = null;
	public static Properties config = new Properties();
	public static Logger log = Logger.getLogger("IRqaLogger");
	public static ExtentTest test;
	public static ExtentReports report;
	public static ExtentReports rep = ExtentManager2.getInstance();
		
	@BeforeSuite()
	public void init() throws IOException {		
		
				
		if (driver == null) {
			FileInputStream fs = new FileInputStream(
					"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\properities\\config.properities");
			config.load(fs);
			log.debug("loading the config property file");
			
			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\exucutable\\chromedriver.exe");
				driver = new ChromeDriver();
							
				log.info("Open Chrome Browser");
			} 
			else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\eclipse-workspace\\qaProject1\\resources\\exucutable\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.info("Open Firefox Browser");
			} 
			else if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver",
						"");
				driver = new EdgeDriver();
				log.info("Open Edge Browser");
			}

			log.info("Get Website URL");
			driver.get(config.getProperty("testsiteURL"));
			log.info("Maximize the Browser");
			driver.manage().window().maximize();
			log.info("Global Wait");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	@AfterSuite()
	public void teardown() throws IOException {
		if (driver != null) {
			log.info("Close the Browser");
			driver.quit();			
		}
	}

}
