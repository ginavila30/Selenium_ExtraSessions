package com.cydeo.tests.gurhan_videos;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyBoardActions {
    @Test
    public static void test(){
        Driver.getDriver().get("https://www.google.com/");
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        Actions actions = new Actions(Driver.getDriver());
        actions.click(searchBox).pause(1000).
                keyDown(Keys.SHIFT).
                sendKeys("typing by holding down shift").pause(1000).
                keyUp(Keys.SHIFT).sendKeys("typing after releasing shift").
                keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).pause(1000).perform();
        Driver.closeDriver();
    }
}
