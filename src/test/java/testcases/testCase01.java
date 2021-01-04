package testcases;


import com.relevantcodes.extentreports.LogStatus;

import pageFactory.loginPage;


import utils.commonutils;

public class testCase01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/emptyPassword.html", "TC01");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		
		loginPage login = new loginPage(commonutils.driver);
		login.loginWithNoPassword("riya@cts.com", "password@123");
		
		
		System.out.println("Please enter your password");
		commonutils.logger.log(LogStatus.PASS, "Please enter your password");
		Thread.sleep(2000);
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
