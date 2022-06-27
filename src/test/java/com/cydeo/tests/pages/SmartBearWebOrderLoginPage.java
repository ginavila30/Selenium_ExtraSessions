package com.cydeo.tests.pages;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearWebOrderLoginPage {
    public  SmartBearWebOrderLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "#ctl00_MainContent_username")
    public WebElement usernameBox;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordBox;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginBtn;

    @FindBy(css = "#ctl00_MainContent_status")
    public  WebElement invalidLoginMessage;

    public void login(String username, String password){
        this.usernameBox.sendKeys(username);
        this.passwordBox.sendKeys(password);
        this.loginBtn.click();
    }

}
