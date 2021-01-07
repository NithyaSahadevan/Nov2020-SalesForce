package testcases;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homeAndAccountPages;
import pageFactory.loginPage;
import pageFactory.mySettingsPage;
import utils.commonutils;

public class testCase35 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/removedtabs.html","TC35");
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
		
		home.clickAllTabs();
		mySettingsPage settings =new mySettingsPage(commonutils.driver);
		settings.clickCustomizeMyTab();
		settings.selectMultipleSelectedTabs("Content");
		settings.clickLeftArrow();
		Select select = new Select(settings.dropdownAvailableTabs);
		List<WebElement> allOptions = select.getOptions();
		for (WebElement ele : allOptions) {
			if (ele.getText().contains("Content")) {
				commonutils.logger.log(LogStatus.PASS, "Selected tab is added to Availabe tab");
				break;
			} else {
				commonutils.logger.log(LogStatus.FAIL, "Selected tab is not added to Availabe tab");
			}
		}
		
		settings.clickSaveEmailSettings();
		
		commonutils.logger.log(LogStatus.PASS, "Selected tab is added to Availabe tab ");
		
		home.logout();
		
		
		commonutils.endReport();
		commonutils.quitBrowser();
		
	}

}
