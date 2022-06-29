package com.cydeo.tests.base;

import com.cydeo.tests.office_hours.utility.Driver;
import com.cydeo.tests.office_hours.utility.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;
    public Actions actions = new Actions(Driver.getDriver());
    public  WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
    public JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public Faker faker = new Faker();
    @BeforeMethod
    public void setUp(){

    // driver = WebDriverFactory.getDriver("chrome");
        // WebDriverManager.chromedriver().setup();
        //        driver = new ChromeDriver();
        //        driver.manage().window().maximize();
        //        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        //driver.quit();
    }
}
