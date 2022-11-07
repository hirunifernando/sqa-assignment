package com.actitime.qa.testcases;

import com.actitime.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	UsersPage usersPage;
	TimeTrackPage timeTrackPage;
	ReportsPage reportPage;

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
		reportPage = new ReportsPage();


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
	@Test(priority = 3)
	public void reportsLinkTest() {
		SoftAssert softAssert= new SoftAssert();
		homePage.clickOnReportsLink();
		softAssert.assertTrue(reportPage.verifyReportPageTitle(),"Cannot find the Reports section page title");
		softAssert.assertTrue(reportPage.verifyLeaveChartIsDisplayed(),"Cannot find the Leave Chart in Reports section");
		reportPage.clickPastMonthLeaveReport();

		//softAssert.assertEquals(reportPage.getReportName(),"Chart: Past Month's Leaves","Incorrect report name is displayed");
		reportPage.clickCreateChartCancelBtn();

		reportPage.clickAttendanceReport();
		softAssert.assertEquals(reportPage.getReportName(),"Scheduled vs. Worked Hours+Overtime","Incorrect report name is displayed");
		softAssert.assertAll();

	}
	@Test(priority = 4)
	public void timeSheetApprovalTest() {

		homePage.clickOnTimeTrackLink();
		Assert.assertTrue(timeTrackPage.verifyTimeTrackPageTitle(),"Time Track page title is not loaded");
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTrackTab(),"Approve time track tab is not loaded");
		timeTrackPage.clickApproveTimeTrackLink();

		Assert.assertTrue(timeTrackPage.verifyApproveTimeTrackPageTitle(),"Approve Time Track page title is not loaded");
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTable(),"Approve Time Track table is not loaded");
		Assert.assertTrue(timeTrackPage.verifyUserNameListCount(),"Empty users in Approve time track table");
		timeTrackPage.selectFirstUserCheckBox();
		timeTrackPage.clickTimeTrackApproveBtn();

	}
	@Test(priority = 5)
	public void timeSheetRejectTest() {

		homePage.clickOnTimeTrackLink();
		Assert.assertTrue(timeTrackPage.verifyTimeTrackPageTitle(),"Time Track page title is not loaded");
		Assert.assertTrue(timeTrackPage.verifyApproveTimeTrackTab(),"Approve time track tab is not loaded");
		timeTrackPage.clickApproveTimeTrackLink();

		Assert.assertTrue(timeTrackPage.verifyApproveTimeTrackPageTitle(),"Approve Time Track page title is not loaded");
		timeTrackPage.getNonRejectedTimeTrack();
		driver.navigate().refresh();

		Assert.assertTrue(timeTrackPage.verifyApproveTimeTable(),"Approve Time Track table is not loaded");
		Assert.assertTrue(timeTrackPage.verifyUserNameListCount(),"Empty users in Approve time track table");
		timeTrackPage.selectFirstUserCheckBox();
		timeTrackPage.clickTimeTrackRejectBtn();
		driver.navigate().refresh();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
