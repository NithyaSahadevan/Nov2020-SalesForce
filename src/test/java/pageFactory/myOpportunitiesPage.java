package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import utils.commonutils;

public class myOpportunitiesPage {

	WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Opportunities']")
	WebElement linkOpportunities;

	@FindBy(xpath = "//select[@id='fcf']")
	WebElement dropdownViewOpportunities;
	
	@FindBy(xpath = "//input[@title='New']")
	WebElement btnNewOpportunity;
	
	@FindBy(xpath = "//input[@id='opp3']")
	WebElement textOpportunityName;
	
	@FindBy(xpath = "//input[@id='opp4']")
	WebElement textAccountName;
	
	@FindBy(xpath = "//input[@name='opp9']")
	WebElement textCloseDate;
	
	@FindBy(xpath = "//select[@id='opp11']")
	WebElement dropdownStage;
	
	@FindBy(xpath = "//select[@id='opp6']")
	WebElement dropdownLeadSource;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement saveOpportunity;
	
	
	
	public myOpportunitiesPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
	// Click save opportunity
		public void clickSaveOpportunity() {

			commonutils.waitExplicitly(5, saveOpportunity);
			saveOpportunity.click();

		}
	
	// Select Lead Source
			public void selectLeadSource(String leadsource) {

				commonutils.waitExplicitly(5, dropdownLeadSource);
				Select select = new Select(dropdownLeadSource);
				select.selectByVisibleText(leadsource);

			}
	
	// Select stage
		public void selectStage(String stageName) {

			commonutils.waitExplicitly(5, dropdownStage);
			Select select = new Select(dropdownStage);
			select.selectByVisibleText(stageName);

		}
	
	// set close date
	public void setCloseDate(String date) {

		commonutils.waitExplicitly(5, textCloseDate);
		textCloseDate.sendKeys(date);

	}

	// set Opportunity account  name
			public void setOpportAccountName(String name) {

				commonutils.waitExplicitly(5, textAccountName);
				textAccountName.sendKeys(name);

			}
	
	// set Opportunity name
		public void setOpportunityName(String name) {

			commonutils.waitExplicitly(5, textOpportunityName);
			textOpportunityName.sendKeys(name);

		}
	
	// Click new Opportunities btn
	public void clickNewOpportunity() {

		commonutils.waitExplicitly(5, btnNewOpportunity);
		btnNewOpportunity.click();

	}

	// Click Opportunities link
	public void clickOpportunities() {

		commonutils.waitExplicitly(5, linkOpportunities);
		linkOpportunities.click();

	}

	public void viewOpportunities() {

		Select select = new Select(dropdownViewOpportunities);
		List<WebElement> op = select.getOptions();
		int size = op.size();
		for (int i = 0; i < size; i++) {
			String options = op.get(i).getText();
			System.out.println(options);
		}
		commonutils.logger.log(LogStatus.PASS, "viewed all pportunities");
	}
}
