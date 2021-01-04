package testcases;


import pageFactory.homePage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/loginToSalesforce.html", "TC02");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce("riya@cts.com", "password@123");
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
