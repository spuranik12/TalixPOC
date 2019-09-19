package automation.tests;

import java.util.Map;

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
	public void verifySummaryTabinPatientDashboard() throws InterruptedException
	{
		//Arrangement
		child = report.startTest("Verify summary tab in patient dashboard.");
		parent.appendChild(child);
		new LoginPage(eventDriver, handler).login(properties.getProperty("username"), properties.getProperty("password"),child);
		homePage = new HomePage(eventDriver, handler);
		patientDashboardPage = new PatientDashboardPage(eventDriver, handler);
		
		//Act
		Map<String, String> lists = homePage.getDetails();
		homePage.openWorklist(lists, child);
		homePage.clickOnPatientInWorklist(lists, child);
		patientDashboardPage.clickOnSummaryTab(child);
	}
}
