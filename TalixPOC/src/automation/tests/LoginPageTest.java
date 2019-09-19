package automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation.common.BaseTest;
import automation.pages.LoginPage;

public class LoginPageTest extends BaseTest{
	LoginPage loginPage;
	@BeforeClass
	public void LoginPage(){
		parent = report.startTest("Login Page","Login Page Test");
	}
	@Test
	public void loginTest() throws InterruptedException{
		//Arrangement
		child = report.startTest("Verify Login functaionlity with valid credentials");
		parent.appendChild(child);
		loginPage = new LoginPage(eventDriver, handler);
		
		//Act
		loginPage.login(properties.getProperty("username"), properties.getProperty("password"),child);
		
		//Assert
		Assert.assertTrue(loginPage.isUserLoggedIn());
	}
}
