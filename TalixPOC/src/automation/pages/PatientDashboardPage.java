package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automation.common.AutoLogger;
import automation.common.BasePage;

public class PatientDashboardPage extends BasePage{

	@FindBy(linkText = "Summary")
	WebElement summaryTab;
	
	public PatientDashboardPage(WebDriver driver, AutoLogger handler) {
		super(driver);
		PageFactory.initElements(driver, this);
		super.handler = handler;
		handler.setCurrentPageClass(this.getClass());
	}
	
	public void clickOnSummaryTab(ExtentTest child) throws InterruptedException
	{
		Thread.sleep(2000);
		summaryTab.click();
		child.log(LogStatus.INFO,"Step 6 : Clicked on summary tab.");
		Thread.sleep(2000);
	}
}
