package com.cydeo.tests.office_hours.day04;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.office_hours.utility.ConfigPropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*IQ : TECH CRUNCH

Using any test automation framework, Java language (except record/play tools) and Maven dependency management, please do following:

	1- Go to https://techcrunch.com/
	2- For “The Latest News” list, verify followings;
		a. each news has an author
		b. each news has an image
	3- Click one of news from “The Latest News” list to reach the full content and verify followings;
		a. the browser title is the same with the news title
		b. the links within the news content

*/
public class IQ extends TestBase {
    @Test
    public void test() throws InterruptedException {

        driver.get(ConfigPropertiesReader.getProperty("url"));//https://techcrunch.com/
        List<WebElement>list =driver.findElements(By.xpath("//div[@class=\"river river--homepage \"]//article//span[@class=\"river-byline__authors\"]//a"));
        System.out.println(list.size());
        List<WebElement>imgs=driver.findElements(By.xpath("//div[@class=\"river river--homepage \"]//img"));
        for (int i = 0; i < list.size() ; i++) {
            Assert.assertTrue(list.get(i).isDisplayed());
            Assert.assertTrue(imgs.get(i).isDisplayed());
        }

        WebDriverWait wait = new WebDriverWait(driver,50);
        WebElement post = driver.findElement(By.xpath("(//div[@class=\"river river--homepage \"]//a[@class=\"post-block__title__link\"])[1]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", post);
        wait.until(ExpectedConditions.elementToBeClickable(post));
        post.click();
        String expectedTitle= post.getText();


        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        List<WebElement>linksInContent=driver.findElements(By.xpath("//div[@class=\"article-content\"]//p//a"));
        System.out.println(linksInContent.size());
        for (WebElement each:linksInContent) {
//            each.click();
//            System.out.println(driver.getTitle());
//            driver.navigate().back();
            System.out.println(each.getText());
        }
    }
}
