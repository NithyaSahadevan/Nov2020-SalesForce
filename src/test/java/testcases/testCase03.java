package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pageFactory.homePage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase03 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/RemembeMe.html", "TC03");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc03");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		
		loginPage login = new loginPage(commonutils.driver);
		login.setUserName(email);
		login.setPassword(password);
		
		login.selectRememberMe();
		login.clickLogin();
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		home.logout();
		
		commonutils.isLoginPageLoaded();
		login.getSavedUserName().contains(email);
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
