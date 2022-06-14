package com.cydeo.tests.office_hours.day04;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
			- Open "http://www.uitestpractice.com/Students/Switchto"
			- Click Alert
			- Click OK button from Alert
			- Verify message equals "You have clicked on ok button in alert window"
*/
public class Information extends TestBase {
    @Test
    public void test(){
        driver.get("http://www.uitestpractice.com/Students/Switchto");
        WebElement alertBtn = driver.findElement(By.xpath("//button[@id=\"alert\"]"));
        alertBtn.click();
        Alert alert =driver.switchTo().alert();
        alert.accept();
        WebElement msg = driver.findElement(By.xpath("//div[@id=\"demo\"]"));
        Assert.assertEquals(msg.getText(),"You have clicked on ok button in alert window");

    }
}
