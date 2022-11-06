package com.actitime.qa.testcases;

import com.actitime.qa.pages.TimeTrackPage;
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
	TimeTrackPage timeTrackPage;
	public HomePageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		usersPage = new UsersPage();
		timeTrackPage = new TimeTrackPage();


	}
	
	
	@Test(priority = 1)
	public void homePageLogoTest() {
		
	boolean flag= homePage.validateTimeLogo();
	Assert.assertTrue(flag,"Cannot find the Logo");
		
	}


	@Test(priority = 2)
	public void userProfilesTest() {

		homePage.clickOnUsersLink();
		Assert.assertTrue(usersPage.verifyUserPageTitle(),"Users page title is not loaded");
		Assert.assertTrue(usersPage.verifyUserProfilesTable(),"Users Table is not found");
		Assert.assertTrue(usersPage.verifyUsersListCount(),"Users Table is empty");

	}
//	@Test(priority = 3)
//	}

	@Test(priority = 4)
	public void timeSheetApproveAndRejectTest() {

		homePage.clickOnTimeTrackLink();
		Assert.assertTrue(timeTrackPage.verifyTimeTrackPageTitle(),"Time Track page title is not loaded");
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTrackTab(),"Approve time track tab is not loaded");
		timeTrackPage.clickApproveTimeTrackLink();

		Assert.assertTrue(timeTrackPage.verifyApproveTimeTrackPageTitle(),"Approve Time Track page title is not loaded");
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTable(),"Approve Time Track table is not loaded");
		Assert.assertTrue(timeTrackPage.verifyUserNameListCount(),"Empty users in Approve time track table");
		timeTrackPage.selectFirstUserCheckBox();
		timeTrackPage.clickTimeTrackRejectBtn();

		driver.navigate().refresh();
		timeTrackPage.selectFirstUserCheckBox();
		timeTrackPage.clickTimeTrackApproveBtn();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
