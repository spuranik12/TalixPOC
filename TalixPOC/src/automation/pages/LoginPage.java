package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automation.common.AutoLogger;
import automation.common.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(css = "#hlHccLoginInput-0")
	WebElement username;
	
	@FindBy(css = "#hlHccLoginInput-1")
	WebElement password;
	
	@FindBy(css = "#hlHccLoginSubmit")
	WebElement loginBtn;
	
	@FindBy(linkText = "Worklist")
	WebElement worklistsLink;
	
	public LoginPage(WebDriver driver, AutoLogger handler){
		super(driver);
		PageFactory.initElements(driver, this);
		super.handler = handler;
		handler.setCurrentPageClass(this.getClass());
	}
	
	public void login(String username, String password,ExtentTest child) throws InterruptedException{
		Thread.sleep(1000);
		actions.sendKeys(this.username, username);
		Thread.sleep(1000);
		Reporter.log("Step 1 : UserName enterd: "+username);
		child.log(LogStatus.INFO,"Step 1 : UserName enterd: "+username);
		actions.sendKeys(this.password, password);
		Thread.sleep(1000);
		Reporter.log("Step 1: Password enterd: "+password);
		child.log(LogStatus.INFO,"Step 2 : Password enterd: "+password);
		loginBtn.click();
		child.log(LogStatus.INFO,"Step 3 : Clicked on Login Button.");
		Thread.sleep(2000);
	}
	
	public boolean isUserLoggedIn() throws InterruptedException{
		Thread.sleep(3000);
		return actions.isDisplayed(worklistsLink);
	}
}
