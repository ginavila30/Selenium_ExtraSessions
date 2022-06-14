package com.cydeo.tests.gurhan_videos;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationFormTask extends TestBase {
    @Test
    public void test(){
        driver.get("https://practice.cydeo.com/registration_form");
        WebElement firstName = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        firstName.sendKeys("Gina");
        WebElement lastName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        lastName.sendKeys("Basil");
        WebElement username = driver.findElement(By.xpath("//input[@placeholder=\"username\"]"));
        username.sendKeys("ginabaa");
        WebElement email = driver.findElement(By.xpath("//input[@name=\"email\"]  "));
        email.sendKeys("ginaba@hotmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("giabasas");
        WebElement phone = driver.findElement(By.xpath(" //input[@name=\"phone\"]"));
        phone.sendKeys("202-401-4739");
        WebElement radioBtn= driver.findElement(By.xpath(" //input[@value=\"female\"]"));
        radioBtn.click();
        WebElement DOB =driver.findElement(By.xpath(" //input[@name=\"birthday\"]"));
        DOB.sendKeys("08/30/1985");
        Select select = new Select(driver.findElement(By.xpath("//select[@name=\"department\"] ")));
        select.selectByValue("DE");
        select= new Select(driver.findElement(By.xpath("//select[@name=\"job_title\"]")));
        select.selectByVisibleText("SDET");
        WebElement languageBox = driver.findElement(By.xpath("//input[@id=\"inlineCheckbox2\"]"));
        languageBox.click();
        WebElement signUpBtn = driver.findElement(By.xpath("//button[@id=\"wooden_spoon\"]"));
        signUpBtn.click();
        Assert.assertEquals(driver.findElement(By.xpath("//p[.=\"You've successfully completed registration!\"]")).getText(),"You've successfully completed registration!");






    }
}
