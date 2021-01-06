package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pageFactory.homePage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase11 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/newview.html", "TC11");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc11");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		String viewName=(String) jObject.get("viewName");
		String uniqueViewName=(String) jObject.get("uniqueViewName");
			
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		
		
		home.createNewView(viewName, uniqueViewName);
		
		commonutils.endReport();
		commonutils.quitBrowser();
		
	}

}
