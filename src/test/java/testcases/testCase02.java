package testcases;


import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pageFactory.homePage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase02 {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/loginToSalesforce.html", "TC02");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc02");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
