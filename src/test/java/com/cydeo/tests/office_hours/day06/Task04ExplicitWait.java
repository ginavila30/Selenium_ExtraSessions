package com.cydeo.tests.office_hours.day06;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Task 1

		- Go to "https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html"
		- Click buttons in order
		- Verify messages are equal after click all buttons
				- All Buttons Clicked
				- Clickable Buttons
				- Click Buttons In Order*/
public class Task04ExplicitWait {
    @Test
    public void task1(){
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        WebElement startBtn= Driver.getDriver().findElement(By.id("button00"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.visibilityOf(startBtn));
        startBtn.click();
        WebElement btn1=Driver.getDriver().findElement(By.id("button01"));
        wait.until(ExpectedConditions.elementToBeClickable(btn1));
        btn1.click();
        WebElement btn2=Driver.getDriver().findElement(By.id("button02"));
        wait.until(ExpectedConditions.elementToBeClickable(btn2));
        btn2.click();
        WebElement btn3=Driver.getDriver().findElement(By.id("button03"));
        wait.until(ExpectedConditions.elementToBeClickable(btn3));
        btn3.click();


    }
}
