package com.cydeo.tests.office_hours.day04;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HTML_PopUp extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=5f126");
        WebElement confirmBtn = driver.findElement(By.xpath("//button[@id=\"j_idt311:j_idt312\"]"));
        confirmBtn.click();
        WebElement yesButton= driver.findElement(By.xpath("//button[@id=\"j_idt311:j_idt316\"]"));
        yesButton.click();
        WebElement alert = driver.findElement(By.xpath("//div[@class=\"ui-growl-message\"]//p[.=\"You have accepted\"]"));
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(alert));
        Assert.assertEquals(alert.getText(),"You have accepted");
    }
}
