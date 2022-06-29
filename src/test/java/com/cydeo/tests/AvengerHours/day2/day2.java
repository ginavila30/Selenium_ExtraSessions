package com.cydeo.tests.AvengerHours.day2;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

/*Task 1  -- SliderCont

            1-Navigate to "http://www.uitestpractice.com/"
            2-Verify number "20" is not displayed in "Slider Control" part of the page
            3-Move to right the Slider Handle and make number "20" visible
            4-Now verify number "20" is displayed in "Slider Control" part of the page

*/
public class day2  extends TestBase {
    @Test
    public void  test() throws InterruptedException {
        Driver.getDriver().get("http://www.uitestpractice.com/");
        WebElement number20= Driver.getDriver().findElement(By.xpath("//div[.=\"20\"]"));
        Assert.assertFalse(number20.isDisplayed());
        WebElement handle = Driver.getDriver().findElement(By.cssSelector(".ui-slider-handle.ui-state-default" +
                ".ui-corner-all "));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(handle).clickAndHold(handle).moveByOffset(700,0).perform();
        Assert.assertTrue(number20.isDisplayed());
    }

    /*Task 2  -- TempMail

            Step 1. Go to "https://www.fakemail.net/"
            Step 2. Copy and save email as a string.
            Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
            Step 4. And click on “Sign Up For Mailing List"
            Step 5. Enter any valid name.
            Step 6. Enter email from the Step 2.
            Step 7. Click Sign Up
            Step 8. Verify that following message is displayed:
            “Thank you for signing up. Click the button below to return to the home page.”
            Step 9. Navigate back to the “https://www.fakemail.net/”
            Step 10. Verify that you’ve received an email from -> “do-not-reply@practice.cydeo.com”
            Step 11. Click on that email to open it.
            Step 12. Verify that email is from: “do-not-reply@practice.cydeo.com”
            Step 13. Verify that subject is: “Thanks for subscribing to practice.cydeo.com!”
*/

    @Test
    public void task2(){
        Driver.getDriver().get("https://www.fakemail.net/");
        WebElement email = Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]"));
        String emailStr = email.getText();
        Driver.getDriver().get("https://practice-cybertekschool.herokuapp.com");
        WebElement sigUpForEmailLink = Driver.getDriver().findElement(By.linkText("Sign Up For Mailing List"));
        sigUpForEmailLink.click();
        WebElement nameInput = Driver.getDriver().findElement(By.cssSelector("[name=\"full_name\"]"));
        //nameInput.sendKeys(faker.name().fullName()+ Keys.TAB+emailStr+Keys.TAB+Keys.ENTER);
        nameInput.sendKeys(faker.name().fullName());
        WebElement emailInput = Driver.getDriver().findElement(By.cssSelector("[name=\"email\"]"));
        emailInput.sendKeys(emailStr);
        WebElement signUpBtn = Driver.getDriver().findElement(By.cssSelector("[type=\"submit\"]"));
        signUpBtn.click();
        WebElement signUpMsg = Driver.getDriver().findElement(By.cssSelector("[name=\"signup_message\"]"));
        Assert.assertEquals(signUpMsg.getText(),"Thank you for signing up. Click the button below to return to the home page.");
        Driver.getDriver().get("https://www.fakemail.net/");
        WebElement cydeoEmail= Driver.getDriver().findElement(By.xpath("//tbody/tr[1]"));
        System.out.println(cydeoEmail.getText());
        Assert.assertTrue(cydeoEmail.getText().contains("do-not-reply@practice.cydeo.com"));
        cydeoEmail.click();
        WebElement mailFrom = Driver.getDriver().findElement(By.xpath("//span[@id=\"odesilatel\"]"));
        Assert.assertEquals(mailFrom.getText(),"do-not-reply@practice.cydeo.com");
        WebElement subject =Driver.getDriver().findElement(By.xpath("//span[@id=\"predmet\"]"));
        Assert.assertEquals(subject.getText(),"Thanks for subscribing to practice.cydeo.com!");

    }
}
