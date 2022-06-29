package com.cydeo.tests.office_hours.day06;

import com.cydeo.tests.office_hours.utility.ConfigPropertiesReader;
import com.cydeo.tests.office_hours.utility.Driver;
import com.cydeo.tests.pages.AutomationPracticeIndexPage;
import com.cydeo.tests.pages.GlobalsqaDragAndDropPage;
import com.cydeo.tests.pages.SmartBearWebOrderLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.lang.module.Configuration;
import java.util.List;

/*
       - Go to  "http://automationpractice.com/index.php"
       - Hover over on Dresses button
       - Verify following subCategories are displayed

       				Casual Dresses
       				Evening Dresses
       				Summer Dresses
     */
public class Task02Actions {

    @Test
    public void task1() {
        AutomationPracticeIndexPage obj = new AutomationPracticeIndexPage();
        Driver.getDriver().get(ConfigPropertiesReader.getProperty("automationpractice.index.url"));
        for (WebElement category: obj.allCategories){
            category.isDisplayed();
        }
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(obj.DressesTab).perform();
       Assert.assertTrue(obj.allCategories.size()>0);
       for (WebElement category: obj.allCategories){
           Assert.assertTrue(category.isDisplayed());
       }
        Driver.getDriver().close();

    }

    /* Task 2

 	   - Go to  "https://www.globalsqa.com/demo-site/draganddrop/"
       - Drag and Drop "High Tatras" and "High Tatras 2" into "Trash"
       - Verify Trash has 2 photo
*/
    @Test
    public void task2() {
        GlobalsqaDragAndDropPage obj = new GlobalsqaDragAndDropPage();
        Driver.getDriver().get("https://www.globalsqa.com/demo-site/draganddrop/");
        Driver.getDriver().switchTo().frame(obj.frame);

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(obj.highTatras, obj.trash).perform();
        actions.dragAndDrop(obj.highTatras2, obj.trash).perform();
        //second option
       // actions.moveToElement(obj.highTatras).clickAndHold().moveToElement(obj.trash).pause(3000).perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//ul[@class=\"gallery ui-helper-reset\"]//li"),2));
        List<WebElement> trashItems = Driver.getDriver().findElements(By.xpath("//ul[@class=\"gallery ui-helper-reset\"]//li"));
        System.out.println(trashItems.size());
        Assert.assertEquals(trashItems.size(), 2);
        Driver.getDriver().close();
    }

    /*Task 3
	   - Go to  "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx"
       - Fill form with following information
			fullname : TEST
			email    : TEST
	   - Click Login Button
	   - Verify error message equals "Invalid Login or Password."
*/
    @Test
    public void task3(){
        SmartBearWebOrderLoginPage obj = new SmartBearWebOrderLoginPage();
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
        Actions actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.SHIFT).sendKeys("test").keyUp(Keys.SHIFT).perform();
       obj.usernameBox.sendKeys(Keys.chord(Keys.COMMAND,"a"));
       obj.usernameBox.sendKeys(Keys.chord(Keys.COMMAND,"c"));
       actions.sendKeys(Keys.TAB);
       obj.passwordBox.sendKeys(Keys.chord(Keys.COMMAND,"v"));
       obj.passwordBox.submit();
        //obj.login("TEST","TEST");
        //Assert.assertEquals(obj.invalidLoginMessage.getText(),"Invalid Login or Password.");
    }
}
