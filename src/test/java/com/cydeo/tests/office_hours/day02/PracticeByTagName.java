package com.cydeo.tests.office_hours.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*By.tagName

	1- Open a chrome browser
	2- Go to: https://practice.cydeo.com/
	3- Verify first link text is "Home" */
public class PracticeByTagName {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/");
        WebElement firstLink=driver.findElement(By.tagName("a"));
        String actualText =firstLink.getText();
        System.out.println(actualText);
        String expectedText="Home";
        System.out.println(actualText.equals(expectedText)?"Passed":"Failed");
        driver.quit();

    }
}
