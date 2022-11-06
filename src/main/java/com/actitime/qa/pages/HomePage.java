package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

public class HomePage extends TestBase {


    //Page Factory - Object Repository
    @FindBy(xpath = "//a[@class='content tasks']")
    WebElement tasksLink;
    @FindBy(xpath = "//a[@class='content users']")
    WebElement usersProfileLink;
    @FindBy(xpath = "//a[@class='content reports']")
    WebElement reportsLink;
    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement timeLogo;
    @FindBy(xpath = "//a[@class='content selected tt']")
    WebElement timeTrackContainerLink;

    //initialization
    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    //Action/Methods
    public Boolean validateTimeLogo() {
        return timeLogo.isDisplayed();
    }


    public TasksPage clickOnTaskLink() {

        tasksLink.click();
        return new TasksPage();

    }

    public UsersPage clickOnUsersLink() {

        usersProfileLink.click();
        return new UsersPage();

    }

    public ReportsPage clickOnReportsLink() {
        reportsLink.click();
        return new ReportsPage();

    }
    public TimeTrackPage clickOnTimeTrackLink() {
        timeTrackContainerLink.click();
        return new TimeTrackPage();

    }

}
