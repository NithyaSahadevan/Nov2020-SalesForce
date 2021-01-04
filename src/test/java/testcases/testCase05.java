package testcases;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homePage;
import pageFactory.loginPage;
import utils.commonutils;

public class testCase05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/UserNavigationMenu.html", "TC05");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce("riya@cts.com", "password@123");
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		
		home.clickUserNavigation();
				
		commonutils.logger.log(LogStatus.PASS, home.textMyProfile());
		commonutils.logger.log(LogStatus.PASS, home.textMySettings());
		commonutils.logger.log(LogStatus.PASS, home.textLogout());
		commonutils.logger.log(LogStatus.PASS, home.textDeveloperConsole());
		
		commonutils.endReport();
		commonutils.quitBrowser();

	}

}
