package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	UsersPage usersPage;

	public UserPageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.logging(properties.getProperty("username"), properties.getProperty("password"));
		usersPage = new UsersPage();
	}
	
	
	@Test
	public void userProfilesTest() {

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
