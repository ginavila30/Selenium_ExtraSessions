package com.cydeo.tests.gurhan_videos;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUpload extends TestBase {
@Test
    public void fileUpload() {
    driver.get("https://practice.cydeo.com/upload");
    WebElement fileUpload = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
    String filePath= "C:\\Users\\majid\\OneDrive\\Desktop\\ReferenceCard.pdf";
    fileUpload.sendKeys(filePath);
    WebElement uploadBtn= driver.findElement(By.id("file-submit"));
    uploadBtn.click();
}
    @Test
    public void fileUpload2() throws InterruptedException {
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        WebElement fileUpload = driver.findElement(By.xpath("//input[@value=\"File Upload\"]"));
        String filePath= "C:\\Users\\majid\\OneDrive\\Desktop\\Agile__Scrum_Tip_Sheet.png";
        fileUpload.sendKeys(filePath);
        Thread.sleep(3000);


    }
}
