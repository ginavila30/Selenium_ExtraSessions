package com.cydeo.tests.AvengerHours.day1;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*Task 1  -- isDisplayed/isEnabled


            1-Navigate to "http://www.uitestpractice.com/"
            2-Verify main page is launched;
             -"Testing Controls" Tab should be displayed on left top (visible and enabled)


		Task 2  -- SearchName inputBox

            1-Navigate to website "http://www.uitestpractice.com/";
            2-Click on Home tab
            3-Search for the name "Mike Johnson"
            4-Verify "There are zero students with this search text Page 0 of 0" msg displayed on page


        Task 3  -- iframe

            1- Navigate to "http://www.uitestpractice.com/"
            2- Type the name into "Enter your name" inputbox -> "Mike Johnson"
            3- Retrieve the name from inputbox -> "Mike Johnson"
            4- Click on the link "uitestpractice.com"
            5- Verify "Drag and Drop control" menu is displayed in iframe
*/
public class ExtraPractice1 extends TestBase {
    @Test
    public void test1(){
        driver.get("http://www.uitestpractice.com/");
        WebElement testingControls = driver.findElement(By.xpath("//a[.=\"Testing Controls \"]"));
        Assert.assertTrue(testingControls.isDisplayed());
        Assert.assertTrue(testingControls.isEnabled());
    }
    @Test
    public void test2(){
        driver.get("http://www.uitestpractice.com/");
        WebElement homeTab = driver.findElement(By.xpath("//a[.=\"Home\"]"));
        homeTab.click();
        WebElement searchBox= driver.findElement(By.cssSelector("input[id=\"Search_Data\"]"));
        searchBox.sendKeys("Mike Johnson", Keys.ENTER);
        WebElement msg = driver.findElement(By.xpath("//div[2]/div[1]"));
        Assert.assertTrue(msg.getText().contains("There are zero students with this search text Page 0 of 0"));
        Assert.assertTrue(msg.isDisplayed());
    }
    @Test
    public void test3(){
        driver.get("http://www.uitestpractice.com/");
       driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name=\"iframe_a\"]")));
       WebElement nameInputBox = driver.findElement(By.xpath("//input[@id=\"name\"]"));
       nameInputBox.sendKeys("Mike Johnson");
       String text = nameInputBox.getText();
        System.out.println(text);
        driver.switchTo().defaultContent();
        WebElement link = driver.findElement(By.xpath("//a[.=\"uitestpractice.com\"]"));
        link.click();
        driver.switchTo().frame("iframe_a");
        WebElement drag = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        Assert.assertTrue(drag.isDisplayed());
        WebElement drop = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
        Assert.assertTrue(drop.isDisplayed());
    }
}
