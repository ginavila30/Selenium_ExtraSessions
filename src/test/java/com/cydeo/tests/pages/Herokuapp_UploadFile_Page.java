package com.cydeo.tests.pages;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Herokuapp_UploadFile_Page {
    public Herokuapp_UploadFile_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "fileinput")
    public WebElement uploadFile;

    @FindBy(css = "#itsafile")
    public WebElement generalFileRadioBtn;

    @FindBy (css = "[type=\"submit\"]")
    public WebElement uploadBtn;

    @FindBy (css = ".explanation")
    public WebElement confirmMessage;

}
