package com.cydeo.tests.office_hours.day03;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DynamicElementPractice extends TestBase {
    @Test
    public void test01() {
        driver.get("https://practice.cydeo.com/dynamic_loading/4");
        String helloText= driver.findElement(By.xpath("//h4[.=\"Hello World!\"]")).getText();
    }
    @Test
    public void test02(){
        driver.get("https://practice.cydeo.com/registration_form");
        WebElement errorMessage =driver.findElement(By.xpath("//small[.=\"first name must be more than 2 and less than 64 characters long\"]"));
        System.out.println(errorMessage.isDisplayed()); //Element is not display until I face the error
        WebElement firstNameBox = driver.findElement(By.name("firstname"));
        firstNameBox.sendKeys("a");// forcing error
        System.out.println(errorMessage.isDisplayed());//Element is displayed now since the error is already happening
        System.out.println(errorMessage.getText());// I can get the message of the error because it is already happening
        //Note->in html when I see style="display: none;" I can delete it and then on the page I will be able to see the element.
        WebElement errorMessage2= driver.findElement(By.xpath("//small[.=\"first name can only consist of alphabetical letters\"]"));
        System.out.println(errorMessage2.isDisplayed());
        firstNameBox.clear();
        firstNameBox.sendKeys("@");
        System.out.println(errorMessage2.isDisplayed());
        System.out.println(errorMessage2.getText());
    }

}
