package automation.talixPoc.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.talixPoc.common.BaseTest;
import automation.talixPoc.pages.HomePage;
import automation.talixPoc.pages.LoginPage;

public class HomePageTest extends BaseTest{
	HomePage homePage;
	
	@BeforeClass
	public void HomePage(){
		parent = report.startTest("Home Page","Home Page Test");
	}
	
	@Test
	public void openWorkList() throws InterruptedException
	{
		//Arrangement
		child = report.startTest("Verify worklist selection in worklists drop down");
		parent.appendChild(child);
		new LoginPage(eventDriver, handler).login(properties.getProperty("username"), properties.getProperty("password"),child);
		homePage = new HomePage(eventDriver, handler);
		
		
		//Act
		Map<String, String> lists = homePage.getDetails();
		homePage.openWorklist(lists, child);
		homePage.clickOnPatientInWorklist(child);
		
		//Assert
		Assert.assertTrue(homePage.verifyPatientDashboard());	
	}
}
