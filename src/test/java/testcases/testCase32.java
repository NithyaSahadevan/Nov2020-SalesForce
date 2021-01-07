package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.contactsPage;
import pageFactory.homeAndAccountPages;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase32 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/save and new -contact.html", "TC32");
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

		contactsPage contacts = new contactsPage(commonutils.driver);
		contacts.clickLinkContacts();
		home.clickAlertWindow();
		
		contacts.clickNewContacts();
		contacts.setLastName("Indian");
		contacts.setAccountName("Rakaa");
		contacts.clickSaveAndNew();
		
		commonutils.logger.log(LogStatus.PASS, "New account created ");
		
		home.logout();
		
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
