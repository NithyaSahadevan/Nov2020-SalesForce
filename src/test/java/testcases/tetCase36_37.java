package testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homeAndAccountPages;
import pageFactory.loginPage;
import utils.commonutils;

public class tetCase36_37 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub

		commonutils.generateReport(
				"/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/create event.html", "TC36");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();

		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc14");
		String email = (String) jObject.get("email");
		String password = (String) jObject.get("password");

		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);

		homeAndAccountPages home = new homeAndAccountPages(commonutils.driver);
		home.isHomePageLoaded();

		home.clickHomeTab();
		home.clickAlertWindow();
		home.clickCurrentDate();
		home.clickLinkTime("8:00 PM");
		home.clickImageSubject();
		Thread.sleep(3000);
		
		String MainWindow = commonutils.driver.getWindowHandle();
		// To handle all new opened window.
		Set<String> s1 = commonutils.driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		System.out.println(s1.size());
		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// Switching to Child window
				commonutils.driver.switchTo().window(ChildWindow);
			}
		}
		home.clickSeletSubject();
		commonutils.driver.switchTo().window(MainWindow);
		
		home.setEndTime("9:00 PM");
		
		//TC37
		home.clickChkRecurrence();
		home.selectRadioRecurrence();
		home.setRecurrenceEndDate("1/05/2022");
		
		home.clickSaveEvent();
		
		commonutils.logger.log(LogStatus.PASS, "Event saved ");	
		home.logout();	
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
