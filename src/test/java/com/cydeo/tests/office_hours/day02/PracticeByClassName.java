package com.cydeo.tests.office_hours.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*By.className

	1- Open a chrome browser
	2- Go to: https://practice.cydeo.com/
	3- Get Text of Test Automaton Practice
	4- Locate A/B Testing
	5- Click on A/B Testing
	6- Verify title is "No A/B Test"*/
public class PracticeByClassName {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/");
        WebElement text=driver.findElement(By.className("h1y"));
        String actualText =text.getText();
        System.out.println(actualText);
        WebElement abTesting = driver.findElement(By.linkText("A/B Testing"));
        abTesting.click();
        String expectedTitle="No A/B Test";
        String actualTitle= driver.getTitle();
        System.out.println(actualTitle.equals(expectedTitle)?"True":"False");

        driver.quit();



    }
}
