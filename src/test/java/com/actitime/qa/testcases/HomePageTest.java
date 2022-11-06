package com.actitime.qa.testcases;

import com.actitime.qa.pages.UsersPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	UsersPage usersPage;
	public HomePageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		usersPage = new UsersPage();
		
		
	}
	
	
	@Test(priority = 1)
	public void homePageLogoTest() {
		
	boolean flag= homePage.validateTimeLogo();
	Assert.assertTrue(flag,"Cannot find the Logo");
		
	}


	@Test(priority = 2)
	public void homePageUsersLinkTest() {

		homePage.clickOnUsersLink();
		Assert.assertTrue(usersPage.verifyUserPageTitle(),"Users page title is not loaded");
		Assert.assertTrue(usersPage.verifyUserProfilesTable(),"Users Table is not found");
		Assert.assertTrue(usersPage.verifyUsersListCount(),"Users Table is empty");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
