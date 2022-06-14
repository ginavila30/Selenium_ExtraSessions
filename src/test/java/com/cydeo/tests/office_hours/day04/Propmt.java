package com.cydeo.tests.office_hours.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/*- Open "http://www.uitestpractice.com/Students/Switchto"
			- Click Prompt
			- Send name as "Mike" into this alert field
			- CLick OK
			- Verify  message contains "Mike*/
public class Propmt {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.get("http://www.uitestpractice.com/Students/Switchto");
        WebElement promptBtn= driver.findElement(By.xpath("//button[@id=\"prompt\"]"));
        promptBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Mike");
        alert.accept();
        WebElement msg = driver.findElement(By.xpath("//div[@id=\"demo\"]"));
        Assert.assertTrue(msg.getText().contains("Mike"));
        driver.quit();

    }
}
