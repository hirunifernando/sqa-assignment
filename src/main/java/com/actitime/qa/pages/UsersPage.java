package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class UsersPage extends TestBase  {

    @FindBy(xpath = "//table[contains(@class,'userListTable canEditUsers')]")
    WebElement userTable;
    @FindBy(className = "userListRow")
    List<WebElement> userProfilesList;
    @FindBy(xpath = "//*[@class='pagetitle']//span[text() = \"List of Users\"]")
    WebElement pageTitle;
    public static Logger logger = Logger.getLogger(UsersPage.class);
    // Call init
    public UsersPage() {
        PageFactory.initElements(driver, this);
    }
    // Methods
    public Boolean verifyUserPageTitle() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        return pageTitle.isDisplayed();
    }
    public Boolean verifyUserProfilesTable() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
        return userTable.isDisplayed();
    }
    public Boolean verifyUsersListCount() {
        logger.info("Getting user list count-----");
        if (userProfilesList.size() == 0)
        {
            return false;
        }
        else
            return true;
    }
}
