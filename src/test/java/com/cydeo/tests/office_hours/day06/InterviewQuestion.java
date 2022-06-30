package com.cydeo.tests.office_hours.day06;

import com.cydeo.tests.office_hours.utility.ConfigPropertiesReader;
import com.cydeo.tests.office_hours.utility.Driver;
import com.cydeo.tests.pages.DemoBlazeIndexPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*== Interview Task ( Demoblaze ) ==


SHOP: https://www.demoblaze.com/index.html


	• Customer navigation through product categories: Phones, Laptops and Monitors
	• Navigate to "Laptops" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
	• Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
	• Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.
	• Navigate to "Cart" → Delete "Apple monitor 24" from cart.
	• Click on "Place order".
	• Fill in all web form fields.
	• Click on "Purchase"
	• Capture and log purchase Id and Amount.
	• Assert purchase amount equals expected.
	• Click on "Ok"
	• Verify that there is no product in the cart


NOTE : We will create Page Object Model (POM) to solve this task


*/
public class InterviewQuestion {
    DemoBlazeIndexPage obj = new DemoBlazeIndexPage();

    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigPropertiesReader.getProperty("demoblaze.index.url"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        Faker faker = new Faker();
        obj.laptopsTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(obj.sonyVaioI5));
        JavascriptExecutor jse =(JavascriptExecutor)Driver.getDriver();
        jse.executeScript("arguments[0].click()",obj.sonyVaioI5);
        obj.addToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();
        obj.phonesTab.click();
        //wait.until(ExpectedConditions.elementToBeClickable(obj.samsungGalaxyS6));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click()",obj.samsungGalaxyS6);
        wait.until(ExpectedConditions.visibilityOf(obj.addToCart));
        obj.addToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();
        obj.monitorsTab.click();
        wait.until(ExpectedConditions.visibilityOf(obj.appleMonitor24));
        obj.appleMonitor24.click();
        obj.addToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();
        wait.until(ExpectedConditions.visibilityOf(obj.cart));
        obj.cart.click();
        obj.deleteBtnAppleMonitor.click();
        obj.placeOrderBtn.click();
        obj.nameInput.sendKeys(faker.name().fullName());
        obj.countryInput.sendKeys(faker.country().name());
        obj.city.sendKeys(faker.country().capital());
        obj.creditCardInput.sendKeys(faker.finance().creditCard());
        obj.monthInput.sendKeys("January");
        obj.yearInput.sendKeys("2023");
        obj.purchaseBtn.click();
        String confirmation = obj.orderConfirmation.getText();
        System.out.println(confirmation);
        obj.okOrderConfirm.click();
        Assert.assertTrue(obj.productsInCart.size()==1);




    }
}
