package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pageFactory.loginPage;
import utils.commonutils;

public class testCase04 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/ForgotEmail.html", "TC04");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc04");
		String email=(String) jObject.get("email");
		//String password=(String) jObject.get("password");
		
		
		loginPage login = new loginPage(commonutils.driver);
		login.forgotPassword(email);
		
		commonutils.isLoginPageLoaded();
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
