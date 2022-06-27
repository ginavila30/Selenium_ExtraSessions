package com.cydeo.tests.pages;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GlobalsqaDragAndDropPage {
    public GlobalsqaDragAndDropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h5[.=\"High Tatras\"]")
    public WebElement highTatras;

    @FindBy(xpath = "//img[@src=\"images/high_tatras2_min.jpg\"]")
    public WebElement highTatras2;

    @FindBy(xpath = "//div[@class=\"ui-widget-content ui-state-default ui-droppable\"]")
    public  WebElement trash;

    @FindBy(xpath = "//li[@style=\"display: list-item; width: 48px;\"]")
    public List<WebElement>trashItems;

    @FindBy(xpath = "//iframe[@class=\"demo-frame lazyloaded\"]")
    public WebElement frame;


}
