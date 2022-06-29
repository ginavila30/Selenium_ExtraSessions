package com.cydeo.tests.pages;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutomationPracticeIndexPage {
    public AutomationPracticeIndexPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@title=\"Dresses\"])[2]")
    public WebElement DressesTab;

    @FindBy(xpath = "(//a[@title=\"Dresses\"])[2]/..//li")
    public List<WebElement> allCategories;





}
