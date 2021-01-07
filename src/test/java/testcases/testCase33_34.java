package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homeAndAccountPages;
import pageFactory.loginPage;
import pageFactory.myProfilePage;
import utils.commonutils;

public class testCase33_34 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/click profile.html","TC33");
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
		home.clickProfileName();
		
		commonutils.logger.log(LogStatus.PASS, "This is same as myprofile page ");
		
		//TC34
		myProfilePage profile=new myProfilePage(commonutils.driver);
		profile.isMyProfilePageLoaded();
		
		profile.editProfile("Khanna");
		
		Thread.sleep(2000);
		if(profile.getBreadCrumbName().trim().contains("Khanna")) {
			commonutils.logger.log(LogStatus.PASS, "Last name changed in breadcrumb");
		}
		
		home.logout();
		
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}
}
