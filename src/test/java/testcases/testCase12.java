package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import pageFactory.homePage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase12 {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/editview.html", "TC12");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		JSONObject jObject = commonutils.readTestData("tc12");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		String field=(String) jObject.get("field");
		String operator=(String) jObject.get("operator");
		String value=(String) jObject.get("value");
			
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();

		home.editView(field, operator, value);
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
