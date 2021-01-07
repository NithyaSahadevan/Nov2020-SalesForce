package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homeAndAccountPages;
import pageFactory.leadsPage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase23 {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/Todaysleads.html", "TC23");
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
		
		leadsPage leads= new leadsPage(commonutils.driver);
		leads.clickLeadsLink();
		
		home.clickAlertWindow();
		
		
		leads.selectLeadSView("Today's Leads");
		leads.clickGo();
		
		home.logout();
		
		commonutils.logger.log(LogStatus.PASS, "Todays leads link clicked ");
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
