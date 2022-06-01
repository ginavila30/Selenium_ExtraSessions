package com.cydeo.tests.office_hours.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType){
        browserType=browserType.toLowerCase();
        WebDriver driver = null;
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();

                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver=new SafariDriver();

                break;
            default:
                System.out.println("Unknown Browser Type "+browserType);
        }
        driver.manage().window().maximize();

        return driver;
    }
}
