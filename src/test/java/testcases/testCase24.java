package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homeAndAccountPages;
import pageFactory.leadsPage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase24 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/createnewlead.html", "TC24");
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
		
		leads.clickNewLead();
		leads.setLastName("Dan");
		leads.setCompanyName("Google");
		leads.clickSave();
		
		home.logout();
		
		commonutils.logger.log(LogStatus.PASS, "New lead created ");
		commonutils.endReport();
		commonutils.quitBrowser();
		
	}

}
