package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.apache.log4j.Logger;
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
    @FindBy(xpath = "//span[@id='statusFilterButton']")
    WebElement timeTrackStatuesPanel;
    @FindBy(xpath = "//input[@id='rejectedCbx']")
    WebElement rejectedCheckBox;
    @FindBy(xpath = "//span[@class='ui-button-text'] [text() = \"Apply\"]")
    WebElement applyBtn;
    @FindBy(xpath = "//span[@class='statusApprovalSelectorButtonTitle']")
    WebElement statusApprovalSelectorButtonTitle;
    public static Logger logger = Logger.getLogger(TimeTrackPage.class);
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

    public void getNonRejectedTimeTrack() {
        String heading = statusApprovalSelectorButtonTitle.getText();
        if(heading.contains("Rejected"))
        {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
            timeTrackStatuesPanel.click();
            rejectedCheckBox.click();
            applyBtn.click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

        }


    }
    public Boolean verifyApproveTimeTrackPageTitle() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        return approveTimeTrackPageTitle.isDisplayed();
    }
    public Boolean verifyApproveTimeTable() {
        return approveTimeTrackTable.isDisplayed();
    }
    public void clickTimeTrackApproveBtn() {
        logger.info("Clicking Approve Button-----");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        approveTimeTrackBtn.click();
    }

    public void clickTimeTrackRejectBtn() {
        logger.info("Clicking reject Button-----");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        rejectTimeTrackBtn.click();
    }
    public void selectFirstUserCheckBox() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        if (approveTimeTrackTableFirstUserCheckBox.isDisplayed()) {
            approveTimeTrackTableFirstUserCheckBox.click();
        }
        else{
            System.exit(0);
        }
    }
    public Boolean verifyUserNameListCount() {
        logger.info("UserNameListCount-----"+userListInApproveTimeTrackTable.size());
        return userListInApproveTimeTrackTable.size() != 0;
    }


}
