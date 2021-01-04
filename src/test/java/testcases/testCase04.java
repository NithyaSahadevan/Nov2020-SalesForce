package testcases;

import pageFactory.loginPage;
import utils.commonutils;

public class testCase04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/ForgotEmail.html", "TC04");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		
		
		loginPage login = new loginPage(commonutils.driver);
		login.forgotPassword("riya@cts.com");
		
		commonutils.isLoginPageLoaded();
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
