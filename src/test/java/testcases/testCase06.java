package testcases;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homePage;
import pageFactory.loginPage;
import pageFactory.myProfilePage;
import utils.commonutils;

public class testCase06 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String lName= "Raj";
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/UploadFilePhoto.html", "TC06");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce("riya@cts.com", "password@123");
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		
		home.clickUserNavigation();
		home.clickMyProfile();
		
		myProfilePage profile=new myProfilePage(commonutils.driver);
		profile.isMyProfilePageLoaded();
		profile.editProfile(lName);
		Thread.sleep(2000);
		if(profile.getBreadCrumbName().trim().contains(lName)) {
			commonutils.logger.log(LogStatus.PASS, "Last name changed in breadcrumb");
		}
		
		
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
