package automation.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.common.BaseTest;
import automation.pages.HomePage;
import automation.pages.LoginPage;

public class HomePageTest extends BaseTest{
	HomePage homePage;
	
	@BeforeClass
	public void HomePage(){
		parent = report.startTest("Home Page","Home Page Test");
	}
	
	@Test
	public void openWorkListAndRedirectToPatientDashboard() throws InterruptedException
	{
		//Arrangement
		child = report.startTest("Verify worklists & redirect to patient dashboard for selected worklist");
		parent.appendChild(child);
		new LoginPage(eventDriver, handler).login(properties.getProperty("username"), properties.getProperty("password"),child);
		homePage = new HomePage(eventDriver, handler);
		
		
		//Act
		Map<String, String> lists = homePage.getDetails();
		homePage.openWorklist(lists, child);
		homePage.clickOnPatientInWorklist(lists, child);
		
		//Assert
		//Assert.assertTrue(homePage.clickOnPatientInWorklist(lists, child));	
	}
}
