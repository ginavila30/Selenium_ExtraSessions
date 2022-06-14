package com.cydeo.tests.office_hours.day04;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*- Open "http://www.uitestpractice.com/Students/Switchto"
			- Click Confirm
			- Click Cancel button from Alert
			- Verify message equals "You pressed Cancel in confirm window"*/
public class Confirmation extends TestBase {
@Test
    public void test(){
    driver.get("http://www.uitestpractice.com/Students/Switchto");
    WebElement confirm = driver.findElement(By.xpath("//button[.=\"Confirm\"]"));
    confirm.click();
    Alert alert = driver.switchTo().alert();
    alert.dismiss();
    WebElement msg = driver.findElement(By.xpath("//div[.=\"You pressed Cancel in confirm window\"]"));
    Assert.assertEquals(msg.getText(),"You pressed Cancel in confirm window");

}
}
