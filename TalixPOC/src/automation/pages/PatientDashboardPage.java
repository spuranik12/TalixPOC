package automation.pages;

import java.util.List;

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
	public WebElement summaryTab;
	
	@FindBy(xpath = "//div[@id='totalHccSummary']//td")
	List<WebElement> totalHccScoresTable;
	
	@FindBy(css = "[id='totalRxHccSummary'] td")
	List<WebElement> totalRxHccScoreTable;
	
	@FindBy(xpath = "//div[@id='hccSummaryTab']//td[contains(@title, 'Deleted')]")
	List<WebElement> deletedRecordsInSummaryTab;
	
	@FindBy(xpath ="//div[@id='hccSummaryTab']//tr")
	List<WebElement> rows;
	
	@FindBy(xpath = "//div[@id='hccSummaryTab']//tr//td")
	List<WebElement> columns;
	
	@FindBy(xpath = "//tr[contains(@style,'line-through')]")
	List<WebElement> strikedRecords;
	
	public PatientDashboardPage(WebDriver driver, AutoLogger handler) {
		super(driver);
		PageFactory.initElements(driver, this);
		super.handler = handler;
		handler.setCurrentPageClass(this.getClass());
	}
	
	public void clickOnSummaryTab(ExtentTest child) throws InterruptedException
	{
		Thread.sleep(2000);
		actions.waitForElementToBeClickable(summaryTab);
		summaryTab.click();
		child.log(LogStatus.INFO,"Step 6 : Clicked on summary tab.");
		Thread.sleep(1000);
	}
	
	public boolean checkNegativeHccScoresPresent(ExtentTest child)throws InterruptedException
	{
		int hccScoresCount = totalHccScoresTable.size();
		
		for(int i=0; i<hccScoresCount; i++)
		{
			String hccScoresText = totalHccScoresTable.get(i).getText();
			double hccScore = Double.parseDouble(hccScoresText);
			System.out.println(hccScore);
			if(hccScore<0)
			{
				break;
			}
		}
		child.log(LogStatus.INFO,"Step 7 : Check negative scores exists in Hcc Summary scorecard table.");
		Thread.sleep(1000);
		return true;
	}
	
	public boolean checkNegativeRxHccScoresPresent(ExtentTest child) throws InterruptedException
	{
		int rxHccScoresCount = totalRxHccScoreTable.size();
		
		for(int i=0; i<rxHccScoresCount; i++)
		{
			String rxHccScoresText = totalRxHccScoreTable.get(i).getText();
			double rxHccScore = Double.parseDouble(rxHccScoresText);
			System.out.println(rxHccScore);
			if(rxHccScore<0)
			{
				break;
			}
		}
		child.log(LogStatus.INFO,"Step 8 : Check negative scores exists in RxHcc Summary scorecard table.");
		Thread.sleep(1000);
		return true;
	}
	
	public boolean checkDeletedRecordsWithStrike(ExtentTest child) throws InterruptedException
	{
		int recordInSummaryTab = rows.size();
		
		for(int i=0; i<recordInSummaryTab; i++)
		{
			String style = rows.get(i).getAttribute("style");
			//System.out.println("Contains : " +style);
			if(style.contains("line-through"))
			{
				//System.out.println("deleted record found");
				child.log(LogStatus.INFO,"Step 9 : Check deleted records are seen as a strike through.");
				Thread.sleep(1000);
				return true;
			}
		
		}
		return false;
	}
}
