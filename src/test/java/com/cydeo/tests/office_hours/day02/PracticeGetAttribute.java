package com.cydeo.tests.office_hours.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*

	1- Open a chrome browser
	2- Go to: https://practice.cydeo.com/
	3- Click Registration Form
	4- Verify following fields has these default values
			- First name ---> first name
			- Last name  ---> last name
			- Username   ---> username */
public class PracticeGetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/");
        WebElement registrationFormButton= driver.findElement(By.linkText("Registration Form"));
        registrationFormButton.click();
        WebElement firstName= driver.findElement(By.cssSelector("input[name='firstname']"));
        System.out.println(firstName.getAttribute("placeholder").equals("first name") ? "Passed" : "Failed");
        WebElement lastName= driver.findElement(By.cssSelector("input[name='lastname']"));
        System.out.println(lastName.getAttribute("placeholder").equals("last name") ? "Passed" : "Failed");
        WebElement username= driver.findElement(By.cssSelector("input[name='username']"));
        System.out.println(username.getAttribute("placeholder").equals("username") ? "Passed" : "Failed");
        driver.quit();

    }
}
