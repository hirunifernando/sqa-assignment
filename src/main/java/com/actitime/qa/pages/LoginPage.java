package com.actitime.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.actitime.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {
	
	//Page Factory - Object Repository
	
	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	WebElement userName;
	
	
	
	
	@FindBy(xpath = "//input[@type='password'and @name='pwd']")
	WebElement passWord;
	
	@FindBy(xpath = "//a[@id='loginButton']")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@name='remember']")
	WebElement keepmeLoggedinCheckBox;
	
	@FindBy(xpath = "//a[@id='toPasswordRecoveryPageLink']")
	WebElement forgotYourPasswordLink;
	
	
	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiTimeLogo;
	@FindBy(xpath = "//span[@class='errormsg']")
	WebElement loginErrorMsg;

	public static Logger logger = Logger.getLogger(LoginPage.class);

	//initialization
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	//Action/Methods
	
	public Boolean validateActiTimeLogo() {
		return actiTimeLogo.isDisplayed();

	}
	public String validateLoginErrorMessage() {
		if(loginErrorMsg.isDisplayed()) {
			logger.info("Login error msg is displayed-----");
			return loginErrorMsg.getText();
		}
		else
		{			logger.info("Login error msg is not displayed-----");
			return "";
		}
	}

	public HomePage logging(String uName, String password) {
		logger.info("Typing user Name-----");
		userName.sendKeys(uName);
		logger.info("Typing password-----");
		passWord.sendKeys(password);
		loginButton.click();
		logger.info("Clicking login button-----");
		return new HomePage();
		
	}
	public void invalidLogging(String uName, String password) throws InterruptedException {
		logger.info("Typing user Name-----");
		userName.sendKeys(uName);
		logger.info("Typing password-----");
		passWord.sendKeys(password);
		logger.info("Clicking login button-----");
		loginButton.click();
		Thread.sleep(300);

	}
}
