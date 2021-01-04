package pageFactory;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import utils.commonutils;

public class myProfilePage {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='contactInfo profileSection']//img[@src='/img/func_icons/util/pencil12.gif']")
	WebElement editProfile;

	@FindBy(xpath = "//li[@id='aboutTab']")
	WebElement aboutTab;

	@FindBy(xpath = "//iframe[@id='contactInfoContentId']")
	WebElement profileFrame;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement inputLastName;

	@FindBy(xpath = "//input[@value='Save All']")
	WebElement btnSaveAll;

	@FindBy(id = "tailBreadcrumbNode")
	WebElement breadcrumbName;

	public myProfilePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	// Get BreadCrumb Name
	public String getBreadCrumbName() {
		return breadcrumbName.getText();
	}

	// Set last name
	public void setLastName(String lname) {
		inputLastName.clear();
		inputLastName.sendKeys(lname);
	}

	// Click SaveAll button
	public void clickSaveAll() {
		btnSaveAll.click();
	}

	// Click Edit Profile
	public void clickEditProfile() throws InterruptedException {

		commonutils.wait = new WebDriverWait(commonutils.driver, 10);
		Thread.sleep(3000);
		commonutils.wait.until(ExpectedConditions.elementToBeClickable(editProfile));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", editProfile);
		editProfile.click();
	}

	// Click About Tab
	public void clickaboutTab() {

		commonutils.wait = new WebDriverWait(commonutils.driver, 10);
		commonutils.wait.until(ExpectedConditions.visibilityOf(aboutTab));
		commonutils.wait.until(ExpectedConditions.elementToBeClickable(aboutTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", aboutTab);
		aboutTab.click();

	}

	public void isMyProfilePageLoaded() {
		String hometitle = "User: ";
		commonutils.wait = new WebDriverWait(commonutils.driver, 10);
		commonutils.wait.until(ExpectedConditions.titleContains(hometitle));

		String title = commonutils.driver.getTitle();
		System.out.println(title);
		if (title.contains(hometitle)) {
			commonutils.logger.log(LogStatus.PASS, "Profile page is displayed");
		}
	}

	public void editProfile(String lName) throws InterruptedException {
		clickEditProfile();
		commonutils.logger.log(LogStatus.PASS, "Edit profile is clicked");
		driver.switchTo().frame(profileFrame);
		clickaboutTab();
		commonutils.logger.log(LogStatus.PASS, "About tab is clicked");
		setLastName(lName);
		commonutils.logger.log(LogStatus.PASS, "Last name changed");
		clickSaveAll();
	}
}
