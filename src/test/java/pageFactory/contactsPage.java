package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.commonutils;

public class contactsPage {

	WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Contacts']")
	WebElement linkContacts;

	@FindBy(xpath = "//input[@title='New']")
	WebElement btnNewContacts;

	@FindBy(xpath = "//input[@id='name_lastcon2']")
	WebElement inputLastName;

	@FindBy(xpath = "//input[@id='con4']")
	WebElement inputAccountName;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//a[normalize-space()='Create New View']")
	WebElement linkNewView;

	@FindBy(xpath = "//input[@id='fname']")
	WebElement inputViewName;

	@FindBy(xpath = "//input[@id='devname']")
	WebElement inputUniqueViewName;

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@value=' Save ']")
	WebElement btnSaveView;

	@FindBy(xpath = "//select[@id='hotlist_mode']")
	WebElement dropdownRecentContacts;

	@FindBy(xpath = "//select[@id='fcf']")
	WebElement dropdownContactList;

	@FindBy(xpath = "//tbody/tr[2]/th[1]//a")
	WebElement linkRecentContactName;

	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[2]")
	WebElement errMsgViewName;

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@value='Cancel']")
	WebElement btnCancelView;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save & New']")
	WebElement btnSaveAndNew_Contact;

	public contactsPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	// Click btn save and new in create new contact
	public void clickSaveAndNew() {

		commonutils.waitExplicitly(5, btnSaveAndNew_Contact);
		btnSaveAndNew_Contact.click();

	}

	// Click cancel view btn
	public void clickCancelView() {

		commonutils.waitExplicitly(5, btnCancelView);
		btnCancelView.click();

	}

	// Click view name error msg
	public String getViewnameErrorMsg() {

		commonutils.waitExplicitly(5, errMsgViewName);
		return errMsgViewName.getText();

	}

	// Click recent contact name
	public void clickRecentContactName() {

		commonutils.waitExplicitly(5, linkRecentContactName);
		linkRecentContactName.click();

	}

	// Select contact list
	public void selectContactsList(String contactlist) {

		commonutils.waitExplicitly(5, dropdownContactList);
		Select select = new Select(dropdownContactList);
		select.selectByVisibleText(contactlist);

	}

	// Select recentcontacts
	public void selectContactsCreated(String recentcontact) {

		commonutils.waitExplicitly(5, dropdownRecentContacts);
		Select select = new Select(dropdownRecentContacts);
		select.selectByVisibleText(recentcontact);

	}

	// Click save view btn
	public void clickSaveView() {

		commonutils.waitExplicitly(5, btnSaveView);
		btnSaveView.click();

	}

	// set unique view name
	public void setUniqueViewName(String uviewname) {

		commonutils.waitExplicitly(5, inputUniqueViewName);
		inputUniqueViewName.sendKeys(uviewname);

	}

	// set view name
	public void setViewName(String viewname) {

		commonutils.waitExplicitly(5, inputViewName);
		inputViewName.sendKeys(viewname);

	}

	// Click new view link
	public void clickCreateNewView() {

		commonutils.waitExplicitly(5, linkNewView);
		linkNewView.click();

	}

	// Click nsave btn
	public void clickSave() {

		commonutils.waitExplicitly(5, btnSave);
		btnSave.click();

	}

	// set account name
	public void setAccountName(String accountname) {

		commonutils.waitExplicitly(5, inputAccountName);
		inputAccountName.sendKeys(accountname);

	}

	// set Last name
	public void setLastName(String lastname) {

		commonutils.waitExplicitly(5, inputLastName);
		inputLastName.sendKeys(lastname);

	}

	// Click new contacts btn
	public void clickNewContacts() {

		commonutils.waitExplicitly(5, btnNewContacts);
		btnNewContacts.click();

	}

	// Click contacts link
	public void clickLinkContacts() {

		commonutils.waitExplicitly(5, linkContacts);
		linkContacts.click();

	}
}
