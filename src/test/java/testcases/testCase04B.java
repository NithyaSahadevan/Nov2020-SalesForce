package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.loginPage;
import utils.commonutils;

public class testCase04B {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/InvalidCredentials.html", "TC04B");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc4b");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		
		loginPage login = new loginPage(commonutils.driver);
		login.setUserName(email);
		login.setPassword(password);
		login.clickLogin();
		
		String str = login.getInvalidErrorMsg();
		if (str.contains("Please check your username and password. If you still can't log in, contact your Salesforce administrator.")) {
			commonutils.logger.log(LogStatus.PASS, "Invalid username or pw");
		} else {
			commonutils.logger.log(LogStatus.FAIL, "valid username and pw");
		}

		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
