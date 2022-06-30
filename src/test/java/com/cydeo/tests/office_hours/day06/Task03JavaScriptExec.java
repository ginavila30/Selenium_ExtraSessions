package com.cydeo.tests.office_hours.day06;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

/*
	 Task 1


       - Go to  "https://techcrunch.com/"
       - Click TechCrunch from Footer > About > TechCrunch
       - Verify title contains "TechCrunch"*/
public class Task03JavaScriptExec {
@Test
    public void task1() {
    Driver.getDriver().get("https://techcrunch.com/");
    WebElement techCrunch = Driver.getDriver().findElement(By.xpath("//a[@data-ga-event-label=\"TechCrunch\"]"));
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    jse.executeScript("arguments[0].scrollIntoView(true)",techCrunch);
    techCrunch.click();
    Assert.assertTrue(Driver.getDriver().getTitle().contains("TechCrunch"));
    Driver.getDriver().close();
}

/*
	 Task 2
		- Go to https://www.etsy.com
		- Search for “wooden spoon”
		- Click on filters
		- Select free shipping  (use checkbox to click freeshipping. DON'T USE label tagged element to handle )
		- Click apply filters
		- Print count of results*/
    @Test
    public void task2() throws InterruptedException {
        Driver.getDriver().get("https://www.etsy.com");
        WebElement searchBox = Driver.getDriver().findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);
        WebElement filter = Driver.getDriver().findElement(By.cssSelector("#search-filter-button"));
        filter.click();
        WebElement freeShipping = Driver.getDriver().findElement(By.name("free_shipping"));
        JavascriptExecutor jse = (JavascriptExecutor)Driver.getDriver();
        jse.executeScript("arguments[0].click()",freeShipping);
        WebElement apply = Driver.getDriver().findElement(By.xpath("//button[contains(.,\"Apply\")]"));
        apply.click();
        WebElement results = Driver.getDriver().findElement(By.xpath("//span[@class=\"wt-display-inline-flex-sm\"]//span"));
        System.out.println(results.getText());
        Driver.closeDriver();
    }
}
