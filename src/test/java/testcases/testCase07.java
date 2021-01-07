package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pageFactory.homeAndAccountPages;
import pageFactory.loginPage;
import pageFactory.mySettingsPage;
import utils.commonutils;

public class testCase07 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/mySettings.html", "TC07");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		
		JSONObject jObject = commonutils.readTestData("tc07");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		String filePath=(String) jObject.get("filePath");
		String fileName=(String) jObject.get("fileName");
		String customApp=(String) jObject.get("customApp");
		String availableTabs=(String) jObject.get("availableTabs");
		String emailName=(String) jObject.get("emailName");
		
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homeAndAccountPages home =new homeAndAccountPages(commonutils.driver);
		home.isHomePageLoaded();		
		home.clickUserNavigation();
		home.clickMySettings();
		
		mySettingsPage settings =new mySettingsPage(commonutils.driver);
		settings.downloadLoginHistory();
		settings.isFileDownloaded(filePath, fileName);
		
		settings.clickDisplayLayout();
		settings.addCustomizeTabs(customApp, availableTabs);
		settings.isAvailableTabAddedToSelectedTab(availableTabs);
		
		settings.clickEmail();
		settings.emailSetting(emailName);
		
		settings.clickCalendar();
		settings.activityReminder();
		
		Thread.sleep(2000);
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
