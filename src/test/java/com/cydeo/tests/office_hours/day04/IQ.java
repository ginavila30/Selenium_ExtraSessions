package com.cydeo.tests.office_hours.day04;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
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
        driver.get("https://techcrunch.com/");
        List<WebElement>list =driver.findElements(By.xpath("//div[@class=\"river river--homepage \"]//article//span[@class=\"river-byline__authors\"]//a"));
        for (WebElement each:list) {
            Assert.assertTrue(!each.getText().isEmpty());
        }
        List<WebElement>imgs=driver.findElements(By.xpath("//div[@class=\"river river--homepage \"]//img"));
        for (WebElement each:imgs) {
            Assert.assertTrue(each.isDisplayed());
        }
        WebDriverWait wait = new WebDriverWait(driver,50);
        WebElement post = driver.findElement(By.xpath("//div[.=\"Celsius Network, one of the biggest crypto lenders, told customers Sunday evening that it is pausing withdrawals, swap, and transfers between accounts in a move that has sparked discussions and pro...\"]"));
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
