package com.cydeo.tests.office_hours.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class P01_LinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/");
       WebElement multipleButtons= driver.findElement(By.linkText("Multiple Buttons"));
       multipleButtons.click();
       Thread.sleep(3000);
       String expectedTitle="Multiple Buttons";
       String actualTitle =driver.getTitle();
       if(actualTitle.equals(expectedTitle)){
           System.out.println("Passed");
       }else{
           System.out.println("Failed");
       }
       driver.navigate().back();
       Thread.sleep(3000);
       driver.quit();


    }
}
