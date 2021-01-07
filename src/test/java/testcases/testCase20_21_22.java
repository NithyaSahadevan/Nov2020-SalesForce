package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homeAndAccountPages;
import pageFactory.leadsPage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase20_21_22 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/leadslnk.html", "TC20,21,22");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc14");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
					
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		//Test 20
		homeAndAccountPages home =new homeAndAccountPages(commonutils.driver);
		home.isHomePageLoaded();
		home.clickAllTabs();
		
		leadsPage leads= new leadsPage(commonutils.driver);
		leads.clickLeadsLink();
		
		home.clickAlertWindow();
		
		//Test 21,Test 22
		leads.selectLeadSView("My Unread Leads");
		Thread.sleep(3000);
		home.logout();
		
		login.loginToSalesForce(email, password);
		home.clickAllTabs();
		leads.clickLeadsLink();
		leads.clickGo();
		
		home.logout();
		
		commonutils.logger.log(LogStatus.PASS, "leads link clicked ");
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
