package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

	public static void launchBrowser() {
		// System.setProperty("webdriver.gecko.driver",
		// "/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/geckodriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver = new SafariDriver();
		driver.manage().window().maximize();
	}

	public static void gotoSalesForceUrl() {

		driver.get("https:login.salesforce.com/");

	}

	public static void isLoginPageLoaded() {
		String logintitle = "Login | Salesforce";
		String title = commonutils.driver.getTitle();
		System.out.println(title);
		if (title.contains(logintitle)) {
			commonutils.logger.log(LogStatus.PASS, "Login page is displayed");
		}
	}

	public static void waitExplicitly(int iSeconds, WebElement ele) {
		wait = new WebDriverWait(driver, iSeconds);
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public static void waitExplicitlyWebElements(int iSeconds, List<WebElement> selectAccounts) {
		WebDriverWait wait = new WebDriverWait(driver, iSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(selectAccounts));
	}
	
	
	public static void quitBrowser() {
		driver.quit();
	}

	public static void generateReport(String path, String tcName) {
		report = new ExtentReports(path, true);
		logger = report.startTest("Sales Force " + tcName);
	}

	public static void endReport() {
		report.endTest(logger);
		report.flush();
		report.close();
	}

	public static JSONObject readTestData(String tcName) throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		try {
			FileReader reader = new FileReader(
					"/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/src/test/java/DataFile/tcData.json");
			Object obj = jsonparser.parse(reader);
			JSONObject jObject = (JSONObject) obj;
			JSONObject tcObject = (JSONObject) jObject.get(tcName);
			return tcObject;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void handleWindows() {
		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		System.out.println(s1.size());
		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				// Closing the Child Window.
				driver.close();
				commonutils.logger.log(LogStatus.PASS, "Reminder window is opened");
			}
		}
		driver.switchTo().window(MainWindow);
	}
}
