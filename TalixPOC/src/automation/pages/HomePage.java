package automation.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automation.common.AutoLogger;
import automation.common.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(css = "#worklistSelect")
	WebElement worklists;
	
	@FindBy(xpath = "//tbody[@id='patientListBody']//tr")
	List<WebElement> patientRecords;
		
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
		Reporter.log("Step 4 : Worklist selected from drop down: "+workListDetails.get("workListName"));
		child.log(LogStatus.INFO,"Step 4 : Worklist selected: "+workListDetails.get("workListName"));
	}
	
	public HashMap<String, String> getDetails() throws InterruptedException
	{
		Thread.sleep(1000);
		HashMap<String, String> details = new HashMap<String, String>();
		details.put("workListName", "ClaimsTest (D)");
		details.put("patientName", "DEMO-LN-1");
		Thread.sleep(1000);
		return details;
	}
	
	public void clickOnPatientInWorklist(Map<String, String> patientDetails,ExtentTest child) throws InterruptedException
	{
		Thread.sleep(1000);
		int count = patientRecords.size();
		for(int i=0; i<count; i++)
		{
			String text = patientRecords.get(i).getText();
			if(text.contains(patientDetails.get("patientName")))
			{
				
				patientRecords.get(i).click();
				child.log(LogStatus.INFO,"Step 5 : Clicked on patient.");
				Thread.sleep(2000);	
			}
			
		}
		
	}
}
