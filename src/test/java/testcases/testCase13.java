package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pageFactory.homePage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase13 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/MergeAccounts.html", "TC13");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc13");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		String searchText=(String) jObject.get("searchText");
		
			
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		
		home.mergeAccount(searchText);

		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
