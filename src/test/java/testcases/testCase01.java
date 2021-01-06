package testcases;


import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.loginPage;


import utils.commonutils;

public class testCase01 {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
		// TODO Auto-generated method stub
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/emptyPassword.html", "TC01");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		JSONObject jObject = commonutils.readTestData("tc01");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		
		loginPage login = new loginPage(commonutils.driver);
		login.loginWithNoPassword(email, password);
		
		
		System.out.println("Please enter your password");
		commonutils.logger.log(LogStatus.PASS, "Please enter your password");
		Thread.sleep(2000);
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
