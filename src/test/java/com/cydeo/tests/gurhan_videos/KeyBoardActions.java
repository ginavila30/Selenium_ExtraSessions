package com.cydeo.tests.gurhan_videos;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class KeyBoardActions {
    @Test
    public static void test(){
        Driver.getDriver().get("https://www.google.com/");
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

    }
}
