package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class commonutils {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static WebDriverWait wait;
	public static void launchBrowser()
	{
		//System.setProperty("webdriver.gecko.driver", "/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/geckodriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver = new SafariDriver();
		driver.manage().window().maximize();
	}
	
	public static void gotoSalesForceUrl() {
		
		driver.get("https:login.salesforce.com/");
		
	}
	public static void isLoginPageLoaded() {
		String logintitle ="Login | Salesforce";
		String title=commonutils.driver.getTitle();
		System.out.println(title);
		if(title.contains(logintitle))
		{
			commonutils.logger.log(LogStatus.PASS, "Login page is displayed");
		}
	}
	

    public static void waitExplicitly(int iSeconds, WebElement ele) {
    	wait = new WebDriverWait(driver, iSeconds);
    	wait.until(ExpectedConditions.visibilityOf(ele));
	
    }
    
    public static void quitBrowser() {
		driver.quit();
	}
    
    public static void generateReport(String path, String tcName) {
    	report = new ExtentReports(path, true);
    	logger=report.startTest("Sales Force " + tcName);
    }
    
    public static void endReport() {
    	report.endTest(logger);
    	report.flush();
    	report.close();
    }
}
