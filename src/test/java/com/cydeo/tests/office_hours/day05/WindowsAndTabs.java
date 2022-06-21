package com.cydeo.tests.office_hours.day05;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/*Task 1

			- Open "http://automationpractice.com/index.php"
			- Click twitter from Follow us
			- Switch to twitter tab
			- Verify title contains "Selenium Framework"
			- Switch to original tab
			- Verify title equals "My Store"*/
public class WindowsAndTabs {
   @Test
    public static void windowsAndTabs(){
       Driver.getDriver().get("http://automationpractice.com/index.php");
       String initialWindow= Driver.getDriver().getWindowHandle();
       WebElement twitterLogo = Driver.getDriver().findElement(By.xpath("//a[@href=\"https://twitter.com/seleniumfrmwrk\"]"));
       twitterLogo.click();
       Set<String> windows =Driver.getDriver().getWindowHandles();
       WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
       String afterTwitterTitle="Selenium Framework";
       String initialPageTitle="My Store";
       for (String each:windows) {
           if(!each.equals(initialWindow)){
           Driver.getDriver().switchTo().window(each);
           wait.until(ExpectedConditions.titleContains(afterTwitterTitle));
               Assert.assertTrue(Driver.getDriver().getTitle().contains("Selenium Framework"));}
           }
       Driver.getDriver().switchTo().window(initialWindow);
       Assert.assertTrue(Driver.getDriver().getTitle().equals(initialPageTitle));
       Driver.closeDriver();

       }

   }


