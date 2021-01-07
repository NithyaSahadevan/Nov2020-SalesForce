package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.commonutils;

public class leadsPage {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Leads']")
	WebElement linkLeads;

	@FindBy(xpath = "//select[@id='fcf']")
	WebElement dropdownViewLeads;

	@FindBy(xpath = "//input[@title='Go!']")
	WebElement btnGo;

	@FindBy(xpath = "//input[@title='New']")
	WebElement btnNewLead;

	@FindBy(xpath = "//input[@id='name_lastlea2']")
	WebElement textLastName;

	@FindBy(xpath = "//input[@id='lea3']")
	WebElement textCompanyName;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement btnSave;

	public leadsPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	// Click save
	public void clickSave() {

		commonutils.waitExplicitly(5, btnSave);
		btnSave.click();

	}

	// set Last name
	public void setCompanyName(String Companyname) {

		commonutils.waitExplicitly(5, textCompanyName);
		textCompanyName.sendKeys(Companyname);

	}

	// set Last name
	public void setLastName(String Lastname) {

		commonutils.waitExplicitly(5, textLastName);
		textLastName.sendKeys(Lastname);

	}

	// Click create new lead button
	public void clickNewLead() {

		commonutils.waitExplicitly(5, btnNewLead);
		btnNewLead.click();

	}

	// Click Go button
	public void clickGo() {

		commonutils.waitExplicitly(5, btnGo);
		btnGo.click();

	}

	// Select Lead view
	public void selectLeadSView(String leadText) {

		commonutils.waitExplicitly(5, dropdownViewLeads);
		Select select = new Select(dropdownViewLeads);
		select.selectByVisibleText(leadText);

	}

	// Click leads link
	public void clickLeadsLink() {

		commonutils.waitExplicitly(5, linkLeads);
		linkLeads.click();

	}

}
