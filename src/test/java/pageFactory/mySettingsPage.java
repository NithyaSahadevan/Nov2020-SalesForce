package pageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import utils.commonutils;

public class mySettingsPage {

	WebDriver driver;

	@FindBy(xpath = "//span[@id='PersonalInfo_font']")
	WebElement linkPersonal;

	@FindBy(css = "#LoginHistory_font")
	WebElement linkLoginHistory;

	@FindBy(xpath = "//a[contains(text(),'Download login history for last six months, includ')]")
	WebElement downloadLoginHistory;

	@FindBy(xpath = "//span[@id='DisplayAndLayout_font']")
	WebElement linkDisplayLayout;

	@FindBy(xpath = "//span[@id='CustomizeTabs_font']")
	WebElement linkCustomizeMyTabs;

	@FindBy(xpath = "//select[@id='p4']")
	WebElement dropdownCustomApp;

	@FindBy(xpath = "//select[@id='duel_select_0']")
	public
	WebElement dropdownAvailableTabs;

	@FindBy(xpath = "//img[@title='Add']")
	WebElement clickRightArrow;

	@FindBy(xpath = "//select[@id='duel_select_1']")
	WebElement dropdownSelectedTabs;

	@FindBy(xpath = "//span[@id='EmailSetup_font']")
	WebElement linkEmail;

	@FindBy(xpath = "//a[@id='EmailSettings_font']")
	WebElement linkEmailSettings;

	@FindBy(xpath = "//input[@id='sender_name']")
	WebElement textEmailName;

	@FindBy(xpath = "//input[@id='auto_bcc1']")
	WebElement radioYes;

	@FindBy(xpath = "//input[@id='auto_bcc0']")
	WebElement radioNo;

	@FindBy(xpath = "//input[@title='Save']")
	WebElement btnSaveEmailSettings;

	@FindBy(xpath = "//span[@id='CalendarAndReminders_font']")
	WebElement linkCalendar;

	@FindBy(xpath = "//a[@id='Reminders_font']")
	WebElement linkActivieReminder;

	@FindBy(xpath = "//input[@id='testbtn']")
	WebElement openTestReminder;
	
	
	@FindBy(css = "input[title='Customize My Tabs']")
	WebElement btnCustomizeMyTab;
	
	@FindBy(xpath = "//img[@title='Remove']")
	WebElement clickLeftArrow;
	
	
	public mySettingsPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
	// Click Left Arrow
		public void clickLeftArrow() {

			commonutils.waitExplicitly(5, clickLeftArrow);
			clickLeftArrow.click();
		}

	
	// Click CustomizeMyTab btn
		public void clickCustomizeMyTab() {

			commonutils.waitExplicitly(5, btnCustomizeMyTab);
			btnCustomizeMyTab.click();
		}


	// Click openTestReminder
	public void clickOpenTestReminder() {

		commonutils.waitExplicitly(5, openTestReminder);
		openTestReminder.click();
	}

	// Click Calendar link
	public void clickActiviyReminder() {

		commonutils.waitExplicitly(5, linkActivieReminder);
		linkActivieReminder.click();
	}

	// Click Calendar link
	public void clickCalendar() {

		commonutils.waitExplicitly(5, linkCalendar);
		linkCalendar.click();
	}

	// Click Save Email settings btn
	public void clickSaveEmailSettings() {

		commonutils.waitExplicitly(5, btnSaveEmailSettings);
		btnSaveEmailSettings.click();
	}

	// Click Email Name in email settings
	public void setEmailName(String emailName) {
		commonutils.waitExplicitly(5, textEmailName);
		textEmailName.clear();
		textEmailName.sendKeys(emailName);
	}

	// Click Email settingslink
	public void clickEmailSettings() {

		commonutils.waitExplicitly(5, linkEmailSettings);
		linkEmailSettings.click();
	}

	// Click Email link
	public void clickEmail() {

		commonutils.waitExplicitly(5, linkEmail);
		linkEmail.click();
	}

	// Click Right Arrow
	public void clickRightArrow() {

		commonutils.waitExplicitly(5, clickRightArrow);
		clickRightArrow.click();
	}

	// Select from dropdown Selected Tabs
	public void selectMultipleSelectedTabs(String selectedTabs) {

		commonutils.waitExplicitly(5, dropdownSelectedTabs);
		Select select = new Select(dropdownSelectedTabs);
		select.selectByVisibleText(selectedTabs);
	}

	// Select from dropdown Available Tabs
	public void selectMultipleAvailableTabs(String availableTabs) {

		commonutils.waitExplicitly(5, dropdownAvailableTabs);
		Select select = new Select(dropdownAvailableTabs);
		select.selectByVisibleText(availableTabs);
	}

	// Select from dropdown Custom App
	public void selectCustomApp(String customAppText) {

		commonutils.waitExplicitly(5, dropdownCustomApp);
		Select select = new Select(dropdownCustomApp);
		select.selectByVisibleText(customAppText);

	}

	// Click Customize My Tabs
	public void clickCustomizeMyTabs() {

		commonutils.waitExplicitly(5, linkCustomizeMyTabs);
		linkCustomizeMyTabs.click();

	}

	// Click Display Layout
	public void clickDisplayLayout() {

		commonutils.waitExplicitly(5, linkDisplayLayout);
		linkDisplayLayout.click();

	}

	// Click Download Login History
	public void clickDownloadLoginHistory() {

		commonutils.waitExplicitly(5, downloadLoginHistory);
		downloadLoginHistory.click();

	}

	// Click Login History
	public void clickLoginHistory() {

		commonutils.waitExplicitly(5, linkLoginHistory);
		linkLoginHistory.click();

	}

	// Click Personal
	public void clickPersonal() {

		commonutils.waitExplicitly(5, linkPersonal);
		linkPersonal.click();

	}

	public void isFileDownloaded(String downloadPath, String fileName) {
		fileName = fileName.replaceAll("\\d", "");
		System.out.println(fileName);
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			String downloadedFile = dirContents[i].getName().replaceAll("\\d", "");
			System.out.println(downloadedFile);
			if (downloadedFile.contains(fileName)) {
				commonutils.logger.log(LogStatus.PASS, "File is downloaded to Downloads folder ");
				break;
			} else {
				commonutils.logger.log(LogStatus.FAIL, "File is not downloaded ");
			}
		}
	}

	public void downloadLoginHistory() throws InterruptedException {
		clickPersonal();
		clickLoginHistory();
		clickDownloadLoginHistory();
		Thread.sleep(5000);
	}

	public void addCustomizeTabs(String customApp, String tab) {
		clickCustomizeMyTabs();
		selectCustomApp(customApp);
		commonutils.logger.log(LogStatus.PASS, "Custom app is selected ");
		selectMultipleAvailableTabs(tab);
		commonutils.logger.log(LogStatus.PASS, "Available tab is selected ");
		clickRightArrow();
		commonutils.logger.log(LogStatus.PASS, "Right arrow is clicked ");
	}

	public void isAvailableTabAddedToSelectedTab(String tab) {
		Select select = new Select(dropdownSelectedTabs);
		List<WebElement> allOptions = select.getOptions();
		for (WebElement ele : allOptions) {
			if (ele.getText().contains(tab)) {
				commonutils.logger.log(LogStatus.PASS, "Availabe tab is added to selected tab");
				break;
			} else {
				commonutils.logger.log(LogStatus.FAIL, "Availabe tab is not added to selected tab");
			}
		}
	}

	public void emailSetting(String emailName) {
		clickEmailSettings();
		setEmailName(emailName);
		radioYes.click();
		clickSaveEmailSettings();
		commonutils.logger.log(LogStatus.PASS, "Email name changed");
	}

	public void activityReminder() throws InterruptedException {
		clickActiviyReminder();
		clickOpenTestReminder();
		Thread.sleep(3000);
		commonutils.handleWindows();		
	}
}
