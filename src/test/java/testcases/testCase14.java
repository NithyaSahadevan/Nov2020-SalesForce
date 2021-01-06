package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pageFactory.homePage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase14 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/CreateReport.html", "TC14");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc14");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		String dateText=(String) jObject.get("dateText");
		String reportName=(String) jObject.get("reportName");
		String reportUniqueName=(String) jObject.get("reportUniqueName");
			
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		
		home.createReport(dateText, reportName, reportUniqueName);
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
