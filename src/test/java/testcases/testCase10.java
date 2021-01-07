package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pageFactory.homeAndAccountPages;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase10 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/newaccount.html", "TC10");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc10");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		String accountName=(String) jObject.get("accountName");
		String accountType=(String) jObject.get("accountType");
		String accountPriority=(String) jObject.get("accountPriority");
		
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homeAndAccountPages home =new homeAndAccountPages(commonutils.driver);
		home.isHomePageLoaded();
		
		home.createNewAccount(accountName, accountType, accountPriority);
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
