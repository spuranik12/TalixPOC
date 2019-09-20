package automation.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.common.BaseTest;
import automation.pages.HomePage;
import automation.pages.LoginPage;
import automation.pages.PatientDashboardPage;

public class PatientDashboardPageTest extends BaseTest{
	
	HomePage homePage;
	PatientDashboardPage patientDashboardPage;
	
	@BeforeClass
	public void PatientDashboardPage()
	{
		parent = report.startTest("Patient Dashboard Page","Patient Dashboard Page Test");
	}
	
	
	@Test
	public void verifySummaryTabInPatientDashboard() throws InterruptedException
	{
		//Arrangement
		child = report.startTest("Verify negative scores present in summary tab.");
		parent.appendChild(child);
		new LoginPage(eventDriver, handler).login(properties.getProperty("username"), properties.getProperty("password"),child);
		homePage = new HomePage(eventDriver, handler);
		patientDashboardPage = new PatientDashboardPage(eventDriver, handler);
		
		//Act
		Map<String, String> lists = homePage.getDetails();
		homePage.openWorklist(lists, child);
		homePage.clickOnPatientInWorklist(lists, child);
		patientDashboardPage.clickOnSummaryTab(child);
		//patientDashboardPage.summaryTab.click();
		
		
		
		//Assert
		Assert.assertTrue(patientDashboardPage.checkNegativeHccScoresPresent(child));
		Assert.assertTrue(patientDashboardPage.checkNegativeRxHccScoresPresent(child));
	}
	
	@Test
	public void verifyDeletedRecords() throws InterruptedException
	{
		//Arrangement
		child = report.startTest("Verify deleted records are seen as a strike through.");
		parent.appendChild(child);
		new LoginPage(eventDriver, handler).login(properties.getProperty("username"), properties.getProperty("password"),child);
		homePage = new HomePage(eventDriver, handler);
		patientDashboardPage = new PatientDashboardPage(eventDriver, handler);
		
		//Act 
		Map<String, String> lists = homePage.getDetails();
		homePage.openWorklist(lists, child);
		homePage.clickOnPatientInWorklist(lists, child);
		patientDashboardPage.clickOnSummaryTab(child);
				
		//Assert
		Assert.assertTrue(patientDashboardPage.checkDeletedRecordsWithStrike(child));	
	}
}
