package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import utils.commonutils;

public class loginPage {
	WebDriver driver;
	
	@FindBy(id = "username")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "Login")
	WebElement login;
	
	@FindBy(id = "error")
	WebElement emptyPasswordError;
	
	@FindBy(id = "rememberUn")
	WebElement chkRememberMe;
	
	@FindBy(xpath = "//span[@id='idcard-identity']")
	WebElement savedUserName;
	
	@FindBy(id = "forgot_password_link")
	WebElement forgotPw;
	
	@FindBy(id="un")
	WebElement emailForgotPw;
	
	@FindBy(id="continue")
	WebElement btnContinue;
	
	@FindBy(id="header")
	WebElement textCheckYourEmail;
	
	@FindBy(xpath="//div [@id='forgotPassForm']/a")
	WebElement btnReturnToLogin;
	
	@FindBy(xpath="//div [@class='loginError'][@id='error']")
	WebElement errorInvalidUnPw;
	

	public loginPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void setUserName(String strUserName) {

		userName.sendKeys(strUserName);
	}

	// Set password in password Texbox
	public void setPassword(String strPassword) {

		password.sendKeys(strPassword);

	}

	public String getSavedUserName() {

		commonutils.waitExplicitly(10, savedUserName);
		return savedUserName.getText();
	}

	// Clear password in password Texbox
	public void clearPassword() {

		password.clear();

	}

	// Click on login button

	public void clickLogin() {

		login.click();

	}

	//Get password error text
	public String textPasswordError() {
		return emptyPasswordError.getText();
	}

	// Click forgot password link
	public void clickForgotPassword() {
		commonutils.waitExplicitly(10, forgotPw);
		forgotPw.click();
		
	}
	// Set email for forgot password 
	public void enterEmailForgotPw(String email) {
		commonutils.waitExplicitly(5, emailForgotPw);
		emailForgotPw.sendKeys(email);
		
	}
	
	//Click continue button
	public void clickContinue() {
		btnContinue.click();
	}
	
	//Return email after remember me 
	public String getcheckemailText() {
		return textCheckYourEmail.getText();
	}
	
	//Click ReturnToLogin button
	public void clickReturnToLogin() {
		btnReturnToLogin.click();
	}
	
	public String getInvalidErrorMsg() {
		commonutils.waitExplicitly(5, errorInvalidUnPw);
		return errorInvalidUnPw.getText();
	}
	
	/*
	 * Method to login to salesforce application
	 * 
	 **/
	public void loginToSalesForce(String strUserName, String strPasword) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();

	}

	/*
	 * Method to login to salesforce application with no password
	 * 
	 **/
	public void loginWithNoPassword(String strUserName, String strPasword) throws InterruptedException {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password
		this.setPassword(strPasword);

		commonutils.logger.log(LogStatus.INFO, "Clear the password");
		
		this.clearPassword();

		if (password.getText().trim().isEmpty()) {
			commonutils.logger.log(LogStatus.PASS, "Password is empty");
		} else {
			commonutils.logger.log(LogStatus.FAIL, "Password is not empty");
		}
		// Click Login button

		this.clickLogin();

	}

	/*
	 * Method to select remember me checkbox
	 */
	public void selectRememberMe() {
		if (chkRememberMe.isDisplayed()) {
			if (!chkRememberMe.isSelected()) {
				chkRememberMe.click();
			}
			commonutils.logger.log(LogStatus.PASS, "Remember Me is selected");
		} else {
			commonutils.logger.log(LogStatus.FAIL, "Remember Me could not be found");
		}
	}

	/*
	 * Method to Forgot Password
	 **/
	public void forgotPassword(String email) {
		clickForgotPassword();
		if(emailForgotPw.isDisplayed()) {
			commonutils.logger.log(LogStatus.PASS, "Salesforce forgot password page is displayed");
		} else
		{
			commonutils.logger.log(LogStatus.FAIL, "Salesforce forgot password page is not displayed");
		}
		enterEmailForgotPw(email);
		clickContinue();
		getcheckemailText().contains("Check Your Email");
		commonutils.logger.log(LogStatus.PASS, "Password reset message page is displayed. An email associated with the <username> account is sent.");
		clickReturnToLogin();
	}
}