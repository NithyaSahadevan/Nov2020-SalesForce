package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pageFactory.homePage;
import pageFactory.loginPage;
import pageFactory.myOpportunitiesPage;
import utils.commonutils;

public class testCase15 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/opportunities.html", "TC15");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc14");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
					
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		home.clickAllTabs();
		
		myOpportunitiesPage opportunities= new myOpportunitiesPage(commonutils.driver);
		opportunities.clickOpportunities();
		home.clickAlertWindow();
		opportunities.viewOpportunities();
		
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
