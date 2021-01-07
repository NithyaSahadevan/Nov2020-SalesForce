package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homeAndAccountPages;
import pageFactory.loginPage;
import pageFactory.myOpportunitiesPage;
import utils.commonutils;

public class testCase18 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/stuckopportunity.html", "TC18");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc14");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
					
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homeAndAccountPages home =new homeAndAccountPages(commonutils.driver);
		home.isHomePageLoaded();
		home.clickAllTabs();

		myOpportunitiesPage opportunities= new myOpportunitiesPage(commonutils.driver);
		opportunities.clickOpportunities();
		home.clickAlertWindow();
		
		opportunities.clickStuckOpportunity();
		
		commonutils.logger.log(LogStatus.PASS, "Report page with opportunities that are stuck is dislayed ");
		commonutils.endReport();
		commonutils.quitBrowser();

	}

}
