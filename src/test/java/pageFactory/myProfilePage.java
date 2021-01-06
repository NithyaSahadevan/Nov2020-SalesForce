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

	@FindBy(xpath = "//a[@id='publisherAttachTextPost']")
	WebElement linkPost;

	@FindBy(css = "iframe[title='Rich Text Editor, publisherRichTextEditor']")
	WebElement postFrame;

	@FindBy(css = "body")
	WebElement inputComment;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	WebElement publishersharebutton;

	@FindBy(xpath = "//a[normalize-space()='Add your photo']")
	WebElement addPhoto;

	@FindBy(xpath = "//iframe[@id='uploadPhotoContentId']")
	WebElement addPhotoFrame;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadInputFile']")
	WebElement btnChooseFile;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	WebElement btnSaveImage;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	WebElement btnSavePhoto;

	@FindBy(xpath = "//a[@id='deletePhoto']")
	WebElement deletePhoto;

	public myProfilePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	// Click Delete photo
	public void clickDeletePhoto() {
		commonutils.waitExplicitly(5, btnSavePhoto);
		deletePhoto.click();
	}

	// Click Save photo button
	public void clickUploadProfilePhoto() {
		commonutils.waitExplicitly(5, btnSavePhoto);
		btnSavePhoto.click();
	}

	// Click Save photo button
	public void clickSavePhoto() {
		commonutils.waitExplicitly(5, btnSaveImage);
		btnSaveImage.click();
	}

	// Click Add Photo link
	public void clickAddPhoto() {
		commonutils.waitExplicitly(10, addPhoto);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addPhoto);
		addPhoto.click();
	}

	// Click Choose file button
	public void btnChooseFile(String path) {
		commonutils.waitExplicitly(10, btnChooseFile);
		btnChooseFile.sendKeys(path);
		;
	}

	// Click Share button to post the comment
	public void clickShare() {
		commonutils.waitExplicitly(10, publishersharebutton);
		publishersharebutton.click();
	}

	// Enter the comment to be posted
	public void setComment(String comment) {
		inputComment.sendKeys(comment);
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

	// Click PostLink
	public void postLink() {
		linkPost.click();
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

	public void postAComment(String comment) {
		postLink();
		driver.switchTo().frame(postFrame);
		setComment(comment);
		driver.switchTo().defaultContent();
		clickShare();
		commonutils.logger.log(LogStatus.PASS, "Entered the comment ");
	}

	public void uploadPhoto(String path) {	
		if(addPhoto.isDisplayed()) {
			clickAddPhoto();
		}
		else {
			driver.switchTo().frame(addPhotoFrame);
			clickDeletePhoto();
		}
		driver.switchTo().frame(addPhotoFrame);
		btnChooseFile(path);
		clickSavePhoto();
		clickUploadProfilePhoto();
		commonutils.logger.log(LogStatus.PASS, "Uploaded photo ");
	}
}
