package com.cydeo.tests.office_hours.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
	By.id

	1- Open a chrome browser
	2- Go to: https://practice.cydeo.com/
	3- Click to Multiple Buttons
	4- Click "Don't Click" button
	5- Verify Result is : "Now it's gone"*/
public class PracticeById {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/");
        WebElement multipleButtonsButton= driver.findElement(By.partialLinkText("Multiple"));
        multipleButtonsButton.click();
        WebElement dontClickButton= driver.findElement(By.id("disappearing_button"));
        dontClickButton.click();
        WebElement result= driver.findElement(By.id("result"));
        String actualTxt = result.getText();
        String expectedTxt="Now it's gone!";
        System.out.println(actualTxt.equals(expectedTxt));

        driver.quit();

    }
}
