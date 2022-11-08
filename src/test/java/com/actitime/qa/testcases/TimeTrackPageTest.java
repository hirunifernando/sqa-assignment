package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TimeTrackPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TimeTrackPage timeTrackPage;

	public TimeTrackPageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.logging(properties.getProperty("username"), properties.getProperty("password"));
		timeTrackPage = new TimeTrackPage();

	}


	@Test
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
	@Test
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
