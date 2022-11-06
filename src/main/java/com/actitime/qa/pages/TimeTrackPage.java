package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TimeTrackPage extends TestBase  {

    @FindBy(xpath = "//td[@class='pagetitle'][text() = \"Enter Time-Track\"]")
    WebElement timeTrackPageTitle;
    @FindBy(linkText = "Approve Time-Track")
    WebElement approveTimeTrackTab;
    @FindBy(xpath = "//*[@class='pagetitle'][text() = 'Approve Time-Track']")
    WebElement approveTimeTrackPageTitle;

    @FindBy(id = "approveButton")
    WebElement approveTimeTrackBtn;

    @FindBy(id = "rejectButton")
    WebElement rejectTimeTrackBtn;

    @FindBy(id = "approveTTTable")
    WebElement approveTimeTrackTable;

    @FindBy(className = "userNameInfo")
    List<WebElement> userListInApproveTimeTrackTable;

    @FindBy(xpath = "//table[@id='approveTTTable']//tbody[@class='data']//td//input[@type='checkbox']")
    WebElement approveTimeTrackTableFirstUserCheckBox;

    // Call init
    public TimeTrackPage() {
        PageFactory.initElements(driver, this);
    }
    // Methods
    public Boolean verifyTimeTrackPageTitle() {
        return timeTrackPageTitle.isDisplayed();
    }
    public Boolean verifyApproveTimeTrackTab() {
        return approveTimeTrackTab.isDisplayed();
    }
    public void clickApproveTimeTrackLink() {
        approveTimeTrackTab.click();
    }

    public Boolean verifyApproveTimeTrackPageTitle() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        return approveTimeTrackPageTitle.isDisplayed();
    }
    public Boolean verifyApproveTimeTable() {
        return approveTimeTrackTable.isDisplayed();
    }
    public void clickTimeTrackApproveBtn() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        approveTimeTrackBtn.click();
    }
    public void clickTimeTrackRejectBtn() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        rejectTimeTrackBtn.click();
    }
    public void selectFirstUserCheckBox() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        if (userListInApproveTimeTrackTable.size() > 0) {
            approveTimeTrackTableFirstUserCheckBox.click();
        }
        else{
            System.exit(0);
        }
    }
    public Boolean verifyUserNameListCount() {
        return userListInApproveTimeTrackTable.size() != 0;
    }


}
