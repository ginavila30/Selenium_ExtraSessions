package com.cydeo.tests.gurhan_videos;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RightClick_DoubleClick {
    @Test
    public static  void test1(){
        Driver.getDriver().get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_oncontextmenu");
        WebElement iframe = Driver.getDriver().findElement(By.id("iframeResult"));
        Driver.getDriver().switchTo().frame(iframe);
        WebElement box = Driver.getDriver().findElement(By.cssSelector("div[contextmenu=\"mymenu\"]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(box).perform();
        Alert alert =Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    @Test
    public static  void test2(){
        Driver.getDriver().get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
        WebElement iframe = Driver.getDriver().findElement(By.id("iframeResult"));
        Driver.getDriver().switchTo().frame(iframe);
        WebElement box = Driver.getDriver().findElement(By.xpath("//p[@ondblclick=\"myFunction()\"]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(box).perform();
        WebElement message = Driver.getDriver().findElement(By.id("demo"));
        Assert.assertTrue(message.isDisplayed());
    }
}
