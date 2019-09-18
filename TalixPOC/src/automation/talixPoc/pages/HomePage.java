package automation.talixPoc.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automation.talixPoc.common.AutoLogger;
import automation.talixPoc.common.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(css = "#worklistSelect")
	WebElement worklists;
	
	@FindBy(xpath = "//a[@title='DEMO-LN-1']")
	WebElement patientRecord;
	
	@FindBy(css = "[class='patient-name ng-binding']")
	WebElement patientName;
	
	public HomePage(WebDriver driver, AutoLogger handler){
		super(driver);
		PageFactory.initElements(driver, this);
		super.handler = handler;
		handler.setCurrentPageClass(this.getClass());
	}
	
	public void openWorklist(Map<String, String> workListDetails, ExtentTest child) throws InterruptedException
	{
		Thread.sleep(1000);
		actions.selectDropdownByVisibleText(worklists, workListDetails.get("workListName"));
		Thread.sleep(1000);
		Reporter.log("Step 1: Worklist selected from drop down: "+workListDetails.get("workListName"));
		child.log(LogStatus.INFO,"Step 1: Worklist selected: "+workListDetails.get("workListName"));
	}
	
	public HashMap<String, String> getDetails() throws InterruptedException
	{
		Thread.sleep(1000);
		HashMap<String, String> worklistDetails = new HashMap<String, String>();
		worklistDetails.put("workListName", "ClaimsTest (D)");
		Thread.sleep(1000);
		return worklistDetails;
	}
	
	public boolean verifyPatientDashboard() throws InterruptedException
	{
		Thread.sleep(1000);
		actions.isWebelementVisible(patientName);
		return true;
	}
	
	public void clickOnPatientInWorklist(ExtentTest child) throws InterruptedException
	{
		Thread.sleep(1000);
		patientRecord.click();
		child.log(LogStatus.INFO,"Step 2 : Clicked on patient.");
		Thread.sleep(2000);
	}
}
