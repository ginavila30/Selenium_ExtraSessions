package com.cydeo.tests.office_hours.day04;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*- Open "https://demoqa.com/frames"
			- Verify child frames texts are equal : "This is a sample page"
*/
public class Iframe extends TestBase {
    @Test
    public void test(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        String msg1 = driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"]")).getText();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        String msg2 = driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"]")).getText();
        Assert.assertEquals(msg1,msg2);

    }
    /*- Open "http://practice.cybertekschool.com/nested_frames"
			- Switch to middle frame
			- Verify text is equal "MIDDLE"
		    - Switch to right frame
		    - Verify text is equal "RIGHT"
		    - Switch to bottom frame
		    - Verify text is equal "BOTTOM"
*/
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//div[.=\"MIDDLE\"]"));
        Assert.assertEquals(middle.getText(),"MIDDLE");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.tagName("body"));
        Assert.assertEquals(right.getText(),"RIGHT");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.tagName("body"));
        Assert.assertEquals(bottom.getText(),"BOTTOM");
    }

}
