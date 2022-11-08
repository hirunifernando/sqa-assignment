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

	public HomePageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.logging(properties.getProperty("username"), properties.getProperty("password"));

	}
	
	
	@Test
	public void homePageLogoTest() {
		
	boolean flag= homePage.validateTimeLogo();
	Assert.assertTrue(flag,"Cannot find the Logo");
		
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
