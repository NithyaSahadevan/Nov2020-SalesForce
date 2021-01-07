package pageFactory;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import utils.commonutils;

public class homeAndAccountPages {
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

	@FindBy(xpath = "//li[@id='AllTab_Tab']//img")
	WebElement linkAllTabs;

	@FindBy(xpath = "//a[normalize-space()='Accounts']")
	WebElement linkAccounts;

	@FindBy(xpath = "//input[@title='New']")
	WebElement btnNewAccount;

	@FindBy(xpath = "//input[@id='acc2']")
	WebElement textAccountName;

	@FindBy(xpath = "//select[@id='acc6']")
	WebElement dropdownType;

	@FindBy(xpath = "//select[@id='00N4x00000DdurB']")
	WebElement dropdownPriority;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//div[@id='tryLexDialog']//a[@title='Close']")
	WebElement alertWindow;

	@FindBy(xpath = "//a[normalize-space()='Create New View']")
	WebElement linkCreateNewView;

	@FindBy(xpath = "//input[@id='fname']")
	WebElement textViewName;

	@FindBy(xpath = "//input[@id='devname']")
	WebElement textUniqueViewName;

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@value=' Save ']")
	WebElement btnSaveView;

	@FindBy(xpath = "//select[@id='fcol1']")
	WebElement dropdownField;

	@FindBy(xpath = "//select[@id='fop1']")
	WebElement dropdownContains;

	@FindBy(xpath = "//input[@id='fval1']")
	WebElement inputValue;

	@FindBy(xpath = "//a[normalize-space()='Edit']")
	WebElement linkEditView;

	@FindBy(xpath = "//a[normalize-space()='Merge Accounts']")
	WebElement linkMergeAccount;

	@FindBy(xpath = "//input[@id='srch']")
	WebElement textSearchAccount;

	@FindBy(xpath = "//input[@value='Find Accounts']")
	WebElement btnFindAccounts;

	@FindBy(xpath = "//table[@class='list']//tr")
	List<WebElement> selectAccounts;

	@FindBy(xpath = "//div[contains(@class,'pbBottomButtons')]//input[contains(@title,'Next')]")
	WebElement btnNext;

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Merge']")
	WebElement btnMerge;

	@FindBy(xpath = "//a[normalize-space()='Accounts with last activity > 30 days']")
	WebElement linkAccWithLastActivity;

	@FindBy(xpath = "//img[@id='ext-gen148']")
	WebElement imgDateField;

	@FindBy(xpath = "//img[@id='ext-gen152']")
	WebElement dateFrom;

	@FindBy(xpath = "//img[@id='ext-gen152']")
	WebElement dateTo;

	@FindBy(xpath = "//input[@id='ext-comp-1042']")
	WebElement dateFromTextbox;

	@FindBy(xpath = "//input[@id='ext-comp-1045']")
	WebElement dateToTextbox;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSaveReport;

	@FindBy(xpath = "//div[contains(text(),'Created Date')]")
	WebElement textCreatedDate;

	@FindBy(xpath = "//input[@name='reportName']")
	WebElement txtReportName;

	@FindBy(xpath = "//input[@name='reportDevName']")
	WebElement txtReportUniqueName;

	@FindBy(xpath = "//button[contains(text(),'Save and Run Report')]")
	WebElement btnSaveAndRunReport;

	@FindBy(xpath = "//li[@id='home_Tab']")
	WebElement homeTab;

	@FindBy(xpath = "//h1[@class='currentStatusUserName']")
	WebElement linkProfileName;

	@FindBy(css = "span[class='pageDescription'] a")
	WebElement linkCurrentDate;

	@FindBy(css = "img[title='Subject Combo (New Window)']")
	WebElement imageSubject;

	@FindBy(xpath = "//li[@class='listItem4']//a")
	WebElement selectSubject;

	@FindBy(xpath = "//input[@id='EndDateTime_time']")
	WebElement textEndTime;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Save']")
	WebElement btnSaveEvent;

	@FindBy(xpath = "//input[@id='IsRecurrence']")
	WebElement chkRecurrence;
	
	@FindBy(xpath = "//label[normalize-space()='Weekly']")
	WebElement radioRecurrence;
	
	@FindBy(xpath = "//input[@id='RecurrenceEndDateOnly']")
	WebElement inputRecurrenceEndDate;
	
	private String linkTime = "//a[normalize-space()='XXXX']";
	

	public homeAndAccountPages(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	// set close date
		public void setRecurrenceEndDate(String date) {

			commonutils.waitExplicitly(5, inputRecurrenceEndDate);
			inputRecurrenceEndDate.sendKeys(date);

		}
		
	// Click Save Event
			public void selectRadioRecurrence() {

				commonutils.waitExplicitly(10, radioRecurrence);
				radioRecurrence.click();

			}
			
	// Click Save Event
		public void clickChkRecurrence() {

			commonutils.waitExplicitly(10, chkRecurrence);
			chkRecurrence.click();

		}
		
	// Click Save Event
	public void clickSaveEvent() {

		commonutils.waitExplicitly(10, btnSaveEvent);
		btnSaveEvent.click();

	}

	// set close date
	public void setEndTime(String endtime) {

		commonutils.waitExplicitly(5, textEndTime);
		textEndTime.clear();
		textEndTime.sendKeys(endtime);

	}

	// Click selet Subject
	public void clickSeletSubject() {

		commonutils.waitExplicitly(10, selectSubject);
		selectSubject.click();

	}

	// Click imageSubject
	public void clickImageSubject() {

		commonutils.waitExplicitly(10, imageSubject);
		imageSubject.click();

	}

	private WebElement prepareWebElementWithDynamicXpath(String xpathValue, String substitutionValue) {

		return driver.findElement(By.xpath(linkTime.replace("XXXX", substitutionValue)));
	}

	public void clickLinkTime(String time) {

		WebElement linkDynTime = prepareWebElementWithDynamicXpath(linkTime, time);
		commonutils.waitExplicitly(10, linkDynTime);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkDynTime);
		linkDynTime.click();

	}

	// Click current date
	public void clickCurrentDate() {

		commonutils.waitExplicitly(10, linkCurrentDate);
		linkCurrentDate.click();

	}

	// ClickProfile name
	public void clickProfileName() {

		commonutils.waitExplicitly(10, linkProfileName);
		linkProfileName.click();

	}

	// Click home tab
	public void clickHomeTab() {

		commonutils.waitExplicitly(5, homeTab);
		homeTab.click();

	}

	// Click save and run report
	public void clickSaveAndRunReport() {

		commonutils.waitExplicitly(5, btnSaveAndRunReport);
		btnSaveAndRunReport.sendKeys(Keys.RETURN);
		// Actions action = new Actions(driver);
		// action.moveToElement(btnSaveAndRunReport).build().perform();
		// action.perform();

	}

	// set unique report name
	public void setUniqueReportName(String reportUniqueName) {

		commonutils.waitExplicitly(5, txtReportUniqueName);
		txtReportUniqueName.sendKeys(reportUniqueName);

	}

	// set report name
	public void setReportName(String reportName) {

		commonutils.waitExplicitly(5, txtReportName);
		txtReportName.sendKeys(reportName);

	}

	// Click save report
	public void clickCreatedDate() {

		commonutils.waitExplicitly(5, textCreatedDate);
		textCreatedDate.click();

	}

	// Click save report
	public void clickSaveReport() {

		commonutils.waitExplicitly(5, btnSaveReport);
		btnSaveReport.click();

	}

	// Select To Date
	public void selectToDate(String dateText) {
		dateToTextbox.clear();
		dateToTextbox.sendKeys(dateText);
	}

	// Select from Date
	public void selectFromDate(String dateText) {
		dateFromTextbox.clear();
		dateFromTextbox.sendKeys(dateText);
	}

	// Click AccWithLastActivity
	public void clickAccWithLastActivity() {

		commonutils.waitExplicitly(5, linkAccWithLastActivity);
		linkAccWithLastActivity.click();

	}

	// Select Field
	public void selectDateField() {

		commonutils.waitExplicitly(10, imgDateField);
		imgDateField.click();
		/*
		 * Select select = new Select(dropdownDateField);
		 * select.selectByVisibleText(accgeneral);
		 */

	}

	// Click merge
	public void clickMerge() {

		commonutils.waitExplicitly(5, btnMerge);
		btnMerge.click();

	}

	// Click next btn
	public void clickNext() {

		commonutils.waitExplicitly(5, btnNext);
		btnNext.click();

	}

	// Click Select Accounts
	public void clickSelectAccounts(String name) {
		commonutils.waitExplicitlyWebElements(5, selectAccounts);

		Iterator<WebElement> it = selectAccounts.iterator();

		while (it.hasNext()) {
			WebElement ele = it.next();

			if (ele.getText().contains(name)) {
				ele.click();
			}
		}

	}

	// Click Find Accounts
	public void clickFindAccounts() {

		commonutils.waitExplicitly(5, btnFindAccounts);
		btnFindAccounts.click();

	}

	// Set Search Value
	public void setSearchValue(String searchtext) {

		commonutils.waitExplicitly(5, textSearchAccount);
		textSearchAccount.sendKeys(searchtext);

	}

	// Click edit view
	public void clickMergeAccount() {

		commonutils.waitExplicitly(5, linkMergeAccount);
		linkMergeAccount.click();

	}

	// Click edit view
	public void clickEditView() {

		commonutils.waitExplicitly(10, linkEditView);
		linkEditView.click();

	}

	// Set value
	public void setValue(String value) {

		commonutils.waitExplicitly(5, inputValue);
		inputValue.sendKeys(value);

	}

	// Select Field
	public void selectOperator(String operator) {

		commonutils.waitExplicitly(5, dropdownContains);
		Select select = new Select(dropdownContains);
		select.selectByVisibleText(operator);

	}

	// Select Field
	public void selectField(String field) {

		commonutils.waitExplicitly(5, dropdownField);
		Select select = new Select(dropdownField);
		select.selectByVisibleText(field);

	}

	// Click save view
	public void clickSaveView() {

		commonutils.waitExplicitly(10, btnSaveView);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnSaveView);
		btnSaveView.click();

	}

	// Set unique view name
	public void setUniqueViewName(String uniqueViewName) {

		commonutils.waitExplicitly(5, textUniqueViewName);
		textUniqueViewName.sendKeys(uniqueViewName);

	}

	// Set View name
	public void setViewName(String viewName) {

		commonutils.waitExplicitly(10, textViewName);
		textViewName.clear();
		textViewName.sendKeys(viewName);

	}

	// Click create new view link
	public void clickCreateNewView() {

		commonutils.waitExplicitly(5, linkCreateNewView);
		linkCreateNewView.click();

	}

	// Click alert window
	public void clickAlertWindow() {

		commonutils.waitExplicitly(5, alertWindow);
		alertWindow.click();

	}

	// Click save
	public void clickSave() {

		commonutils.waitExplicitly(5, btnSave);
		btnSave.click();

	}

	// Select Priority
	public void selectCustomerPriority(String accPriority) {

		commonutils.waitExplicitly(5, dropdownPriority);
		Select select = new Select(dropdownPriority);
		select.selectByVisibleText(accPriority);

	}

	// Select type
	public void selectAccountType(String accType) {

		commonutils.waitExplicitly(5, dropdownType);
		Select select = new Select(dropdownType);
		select.selectByVisibleText(accType);

	}

	// Set Account name
	public void setAccountName(String accName) {

		commonutils.waitExplicitly(5, textAccountName);
		textAccountName.sendKeys(accName);

	}

	// Click New Account
	public void clickNewAccount() {

		commonutils.waitExplicitly(5, btnNewAccount);
		btnNewAccount.click();

	}

	// Click Accounts link
	public void clickAccounts() {

		commonutils.waitExplicitly(5, linkAccounts);
		linkAccounts.click();

	}

	// Click All tabs
	public void clickAllTabs() {

		commonutils.waitExplicitly(10, linkAllTabs);
		linkAllTabs.click();

	}

	// Click User Navigation
	public void clickUserNavigation() {

		commonutils.waitExplicitly(5, userNavigtion);
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
		commonutils.waitExplicitly(10, linkDeveloperConsole);
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

	public void logout() throws InterruptedException {
		String logintitle = "Login | Salesforce";
		clickUserNavigation();
		clickLogout();
		commonutils.logger.log(LogStatus.PASS, "Clicked logout");
		String title = commonutils.driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		if (title.contains(logintitle)) {
			commonutils.logger.log(LogStatus.PASS, "Login page is displayed");
		}
	}

	public void createNewAccount(String accName, String accType, String accPriority) {
		clickAllTabs();
		clickAccounts();
		clickAlertWindow();
		clickNewAccount();
		setAccountName(accName);
		selectAccountType(accType);
		selectCustomerPriority(accPriority);
		clickSave();
		commonutils.logger.log(LogStatus.PASS, "New account created");
	}

	public void createNewView(String viewName, String uniqueViewName) {
		clickAllTabs();
		clickAccounts();
		clickAlertWindow();
		clickCreateNewView();
		setViewName(viewName);
		setUniqueViewName(uniqueViewName);
		clickSaveView();
		commonutils.logger.log(LogStatus.PASS, "New view created");
	}

	public void editView(String field, String operator, String value) {
		clickAllTabs();
		clickAccounts();
		clickAlertWindow();
		clickEditView();
		selectField(field);
		selectOperator(operator);
		setValue(value);
		commonutils.logger.log(LogStatus.PASS, "Edited view");
	}

	public void mergeAccount(String name) {
		clickAllTabs();
		clickAccounts();
		clickAlertWindow();
		clickMergeAccount();
		setSearchValue(name);
		clickFindAccounts();
		clickSelectAccounts(name);
		clickNext();
		clickMerge();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		commonutils.logger.log(LogStatus.PASS, "Merged the accounts");
	}

	public void createReport(String dateText, String reportName, String reportUniqueName) throws InterruptedException {
		clickAllTabs();
		clickAccounts();
		clickAlertWindow();
		clickAccWithLastActivity();
		selectDateField();
		clickCreatedDate();
		Thread.sleep(2000);
		selectFromDate(dateText);
		Thread.sleep(2000);
		selectToDate(dateText);
		Thread.sleep(2000);
		clickSaveReport();
		setReportName(reportName);
		setUniqueReportName(reportUniqueName);
		commonutils.logger.log(LogStatus.PASS, "Report saved");
		Thread.sleep(3000);
		clickSaveAndRunReport();
		Thread.sleep(3000);

		commonutils.logger.log(LogStatus.PASS, "Report generated");
	}
}
