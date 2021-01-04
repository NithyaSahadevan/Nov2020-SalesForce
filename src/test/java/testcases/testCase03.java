package testcases;

import pageFactory.homePage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/RemembeMe.html", "TC03");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		
		loginPage login = new loginPage(commonutils.driver);
		login.setUserName("riya@cts.com");
		login.setPassword("password@123");
		
		login.selectRememberMe();
		login.clickLogin();
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		home.logout();
		
		commonutils.isLoginPageLoaded();
		login.getSavedUserName().contains("riya@cts.com");
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
