package com.cydeo.tests.gurhan_videos;

import com.cydeo.tests.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationFormTask extends TestBase {
    @Test
    public void test() throws InterruptedException {
        Faker faker = new Faker();
        driver.get("https://practice.cydeo.com/registration_form");
        WebElement firstName = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        firstName.sendKeys(faker.name().firstName());
        WebElement lastName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        lastName.sendKeys(faker.name().lastName());
        WebElement username = driver.findElement(By.xpath("//input[@placeholder=\"username\"]"));
        username.sendKeys(faker.bothify("?????###"));
        WebElement email = driver.findElement(By.xpath("//input[@name=\"email\"]  "));
        email.sendKeys(faker.internet().emailAddress());
        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys(faker.internet().password());
        WebElement phone = driver.findElement(By.xpath(" //input[@name=\"phone\"]"));
        phone.sendKeys(faker.phoneNumber().cellPhone().replace("(","").replace(")",""));
        WebElement radioBtn= driver.findElement(By.xpath(" //input[@value=\"female\"]"));
        radioBtn.click();
        WebElement DOB =driver.findElement(By.xpath(" //input[@name=\"birthday\"]"));
        DOB.sendKeys(faker.numerify("05/25/2000"));
        Select select = new Select(driver.findElement(By.xpath("//select[@name=\"department\"] ")));
        select.selectByValue("DE");
        select= new Select(driver.findElement(By.xpath("//select[@name=\"job_title\"]")));
        select.selectByVisibleText("SDET");
        WebElement languageBox = driver.findElement(By.xpath("//input[@id=\"inlineCheckbox2\"]"));
        languageBox.click();
        WebElement signUpBtn = driver.findElement(By.xpath("//button[.=\"Sign up\"]"));
        Thread.sleep(3000);
        signUpBtn.click();
        Assert.assertEquals(driver.findElement(By.xpath("//p[.=\"You've successfully completed registration!\"]")).getText(),"You've successfully completed registration!");






    }
}
