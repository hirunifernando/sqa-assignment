package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.util.TestUtil;

public class LogonPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	String validTestDataSheetName = "ValidUsers";
	String invalidTestDataSheetName = "InvalidUsers";
	TestUtil testUtil;
	
	
	
	public LogonPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void seup() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	
	@Test
	public void loginPageLogoTest() {
		
	boolean flag= loginPage.validateActiTimeLogo();
	Assert.assertTrue(flag);
		
	}
	
	
	@DataProvider
	public Object[][] getValidLoginTestData() {
		Object data[][]=testUtil.getTestData(validTestDataSheetName);
		return data;
		
		
		
	}
	@DataProvider
	public Object[][] getInvalidLoginTestData() {
		Object data[][]=testUtil.getTestData(invalidTestDataSheetName);
		return data;



	}
	@Test(dataProvider="getValidLoginTestData")
	public void validUserLoginTest(String userName, String password) {

		homePage = loginPage.logging(userName, password);
	}
	@Test(dataProvider="getInvalidLoginTestData")
	public void invalidUserLoginTest(String userName, String password) throws InterruptedException {

		loginPage.invalidLogging(userName, password);
		Assert.assertEquals(loginPage.validateLoginErrorMessage(),"Username or Password is invalid. Please try again.","Invalid login error msg is not displayed");

	}


	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
