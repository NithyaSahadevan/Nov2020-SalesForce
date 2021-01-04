package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import utils.commonutils;

public class homePage {
	WebDriver driver;

	@FindBy(id = "userNavLabel")
	WebElement userNavigtion;

	@FindBy(linkText = "Logout")
	WebElement linkLogout;

	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement linkMyProfile;

	@FindBy(xpath = "//a[contains(text(),'My Settings')]")
	WebElement linkMySettings;

	@FindBy(xpath = "//a[contains(text(),'Developer Console')]")
	WebElement linkDeveloperConsole;

	@FindBy(linkText = "Switch to Lightning Experience")
	WebElement linkLightningExp;

	public homePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	// Click User Navigation
	public void clickUserNavigation() {

		userNavigtion.click();

	}

	// Click Logout
	public void clickLogout() {

		linkLogout.click();

	}

	// Click My Profile
	public void clickMyProfile() {
		commonutils.waitExplicitly(10, linkMyProfile);
		linkMyProfile.click();
	}

	// Click My Settings
	public void clickMySettings() {
		linkMySettings.click();
	}

	// Click Developer Console
	public void clickDeveloperConsole() {
		linkDeveloperConsole.click();
	}

	// Click Lightning Exp
	public void clickLightningExp() {
		linkLightningExp.click();
	}

	// Return Logout text
	public String textLogout() {

		return linkLogout.getText();

	}

	// Return My Profile text
	public String textMyProfile() {
		return linkMyProfile.getText();
	}

	// Return My Settings text
	public String textMySettings() {
		return linkMySettings.getText();
	}

	// Return Developer Console text
	public String textDeveloperConsole() {
		return linkDeveloperConsole.getText();
	}

	// Return Lightning Exp text
	public String textLightningExp() {
		return linkLightningExp.getText();
	}

	public void isHomePageLoaded() {
		String hometitle = "Home Page ~ Salesforce";
		commonutils.wait = new WebDriverWait(commonutils.driver, 10);
		commonutils.wait.until(ExpectedConditions.titleContains(hometitle));

		String title = commonutils.driver.getTitle();
		System.out.println(title);
		if (title.contains(hometitle)) {
			commonutils.logger.log(LogStatus.PASS, "Home page is displayed");
		}
	}

	public void logout() {
		String logintitle = "Login | Salesforce";
		clickUserNavigation();
		clickLogout();
		commonutils.logger.log(LogStatus.PASS, "Clicked logout");
		String title = commonutils.driver.getTitle();
		System.out.println(title);
		if (title.contains(logintitle)) {
			commonutils.logger.log(LogStatus.PASS, "Login page is displayed");
		}
	}

}
