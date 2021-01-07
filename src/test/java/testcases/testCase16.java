package testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homeAndAccountPages;
import pageFactory.loginPage;
import pageFactory.myOpportunitiesPage;
import utils.commonutils;

public class testCase16 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/new opportunity.html", "TC16");
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
		opportunities.clickNewOpportunity();
		opportunities.setOpportunityName("Developer");
		opportunities.setOpportAccountName("Rakaa R");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String datex = dateFormat.format(new Date());
		opportunities.setCloseDate(datex);
		opportunities.selectStage("Qualification");
		opportunities.selectLeadSource("Phone Inquiry");
		opportunities.clickSaveOpportunity();
		
		commonutils.logger.log(LogStatus.PASS, "new opportunity created");
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
