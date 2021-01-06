package testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.homePage;
import pageFactory.loginPage;
import pageFactory.myProfilePage;
import utils.commonutils;

public class testCase06 {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
		// TODO Auto-generated method stub

		
		commonutils.generateReport("/Users/nithya/eclipse-workspace/com.TekArch.Salesforce/salesForceReports/myProfile.html", "TC06");
		commonutils.launchBrowser();
		commonutils.gotoSalesForceUrl();
		
		commonutils.isLoginPageLoaded();
		
		JSONObject jObject = commonutils.readTestData("tc06");
		String email=(String) jObject.get("email");
		String password=(String) jObject.get("password");
		String lastName=(String) jObject.get("lastName");
		String photoUrl= (String) jObject.get("photoUrl");
		String comment= (String) jObject.get("comment");
		
		
		loginPage login = new loginPage(commonutils.driver);
		login.loginToSalesForce(email, password);
		
		homePage home =new homePage(commonutils.driver);
		home.isHomePageLoaded();
		
		home.clickUserNavigation();
		home.clickMyProfile();
		
		myProfilePage profile=new myProfilePage(commonutils.driver);
		profile.isMyProfilePageLoaded();
		
		profile.editProfile(lastName);
		Thread.sleep(2000);
		if(profile.getBreadCrumbName().trim().contains(lastName)) {
			commonutils.logger.log(LogStatus.PASS, "Last name changed in breadcrumb");
		}
		
		profile.postAComment(comment);
		
		profile.uploadPhoto(photoUrl);
		
		Thread.sleep(2000);
		commonutils.endReport();
		commonutils.quitBrowser();
	}

}
