package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homeAndAccountPages;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase05 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/UserNavigationMenu.html", "TC05");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc05");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homeAndAccountPages home =new homeAndAccountPages(commonutils.driver);
		home.isHomePageLoaded();
		
		home.clickUserNavigation();
				
		commonutils.logger.log(LogStatus.PASS, home.textMyProfile());
		commonutils.logger.log(LogStatus.PASS, home.textMySettings());
		commonutils.logger.log(LogStatus.PASS, home.textLogout());
		commonutils.logger.log(LogStatus.PASS, home.textDeveloperConsole());
		
		commonutils.endReport();
		commonutils.quitBrowser();

	}

}
