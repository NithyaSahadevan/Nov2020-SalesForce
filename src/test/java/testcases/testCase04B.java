package testcases;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.loginPage;
import utils.commonutils;

public class testCase04B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/InvalidCredentials.html", "TC04B");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		loginPage login = new loginPage(commonutils.driver);
		login.setUserName("riy@cts.com");
		login.setPassword("password");
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
