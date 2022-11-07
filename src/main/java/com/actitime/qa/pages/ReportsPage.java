package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ReportsPage extends TestBase  {

	
	// Web Element Xpath 

    @FindBy(xpath = "//*[@class='pagetitle'][text() = \"Reports Dashboard\"]")
    WebElement reportMainPageTitle;
    @FindBy(xpath = "//*[@id='reportConfig_119']")
    WebElement pastMonthsLeaveReportContainer;
    @FindBy(xpath = "//*[@id='reportConfig_90']")
    WebElement attendanceReportContainer;
    @FindBy(xpath = "//*[@class='reportName']")
    WebElement reportName;
    @FindBy(xpath = "//*[@id='closeCreateChartLightboxButton']")
    WebElement createCharCancelBtn;
    @FindBy(xpath = "//*[@id='createChartLightbox_content']")
    WebElement createChartLightboxContent;
    @FindBy(xpath = "//div[@class='reportNameWrapper']/div[@class='reportName']")
    WebElement reportTitle;


    // Call init
    public ReportsPage() {

        PageFactory.initElements(driver, this);

    }
    // Methods
    public Boolean verifyReportPageTitle() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        return reportMainPageTitle.isDisplayed();
    }
    public Boolean verifyLeaveChartIsDisplayed() {
        return pastMonthsLeaveReportContainer.isDisplayed();
    }
    public void clickPastMonthLeaveReport() {
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS) ;
        pastMonthsLeaveReportContainer.click();
    }
    public String getReportName() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
            return reportTitle.getText();

    }
    public void clickAttendanceReport() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        attendanceReportContainer.click();
    }
    public void clickCreateChartCancelBtn() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        createCharCancelBtn.click();
    }

	
}
