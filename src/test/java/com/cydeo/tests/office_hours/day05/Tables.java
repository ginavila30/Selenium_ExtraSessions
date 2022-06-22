package com.cydeo.tests.office_hours.day05;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Tables {
    /*  Task 1  -- Example 1 Table

	        - Open "http://practice.cydeo.com/tables"
	        - Print out all table headers
	        - Verify
	        		- Table has 6 header */
    @Test
    public static  void test1(){
        Driver.getDriver().get("http://practice.cydeo.com/tables");
        List<WebElement>headers=Driver.getDriver().findElements(By.xpath("//table[@id=\"table1\"]//span"));
        headers.forEach(each -> System.out.println(each.getText()));
        Assert.assertTrue(headers.size()==6);
        Driver.closeDriver();
    }
    /* Task 2  -- Example 1 Table

	        - Open "http://practice.cydeo.com/tables"
	        - Print out all table information
	        - Verify
	        		- Table has 4 row*/
    @Test
    public static  void test2(){
        Driver.getDriver().get("http://practice.cydeo.com/tables");
        List<WebElement>tableInfo=Driver.getDriver().findElements(By.xpath("//table[@id=\"table1\"]//tbody//tr"));
        tableInfo.forEach(each-> System.out.println(each.getText()));
        Assert.assertTrue(tableInfo.size()==4);
        Driver.closeDriver();

    }
    /*Task 3  -- Example 1 Table

	        - Open "http://practice.cydeo.com/tables"
	        - Print out all information for firstname ="Frank"
	        - Verify
	        		- email equals "fbach@yahoo.com"

	       NOTE : This task needs to work for
	                firstname = Jason
	                email     = jdoe@hotmail.com
*/
    @Test
    public static void test3(){
        String name = "Frank";
        String expectedEmail = "fbach@yahoo.com";
        Driver.getDriver().get("http://practice.cydeo.com/tables");
        List<WebElement>allInfoByName1=Driver.getDriver().findElements(By.xpath("//table[@id='table1']//td[.='"+name+"']//following-sibling::td"));
        List<WebElement>allInfoByName2=Driver.getDriver().findElements(By.xpath("//table[@id='table1']//td[.='"+name+"']//preceding-sibling::td"));
        WebElement email= Driver.getDriver().findElement(By.xpath("//table[@id=\"table1\"]//tbody//td[.='"+name+"']//following-sibling::td[1]"));
        allInfoByName1.forEach(each-> System.out.println(each.getText()));
        allInfoByName2.forEach(each-> System.out.println(each.getText()));
        Assert.assertEquals(email.getText(),expectedEmail);
        Driver.closeDriver();
    }
    /*Task 4 -- Optional

			- Open "https://www.demoblaze.com/"
			- Navigate to "Phones"   →  Click "Samsung galaxy s6" and click on "Add to cart"
			- Navigate to "Monitors" →  "Apple monitor 24" and click on "Add to cart"
			- Navigate to "Cart"     →  Delete "Apple monitor 24" from cart.
			- Verify total equals Samsung galaxy s6 price ( 360 )*/
    @Test
    public static void test4(){
        Driver.getDriver().get("https://www.demoblaze.com/");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        WebElement phonesTab= Driver.getDriver().findElement(By.xpath("//a[.=\"Phones\"]"));
        phonesTab.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.=\"Samsung galaxy s6\"]")));
        WebElement phoneModel = Driver.getDriver().findElement(By.xpath("//a[.=\"Samsung galaxy s6\"]"));
        phoneModel.click();
        String expectedPrice=Driver.getDriver().findElement(By.cssSelector("h3.price-container")).getText();
        WebElement addToCartBtn= Driver.getDriver().findElement(By.xpath("//a[.=\"Add to cart\"]"));
        addToCartBtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        WebElement homeBtn= Driver.getDriver().findElement(By.xpath("//a[contains(.,\"Home\")]"));
        homeBtn.click();
        WebElement monitorsTab= Driver.getDriver().findElement(By.xpath("//a[.=\"Monitors\"]"));
        monitorsTab.click();
        WebElement monitorModel = Driver.getDriver().findElement(By.xpath("//a[@href=\"prod.html?idp_=10\"]"));
        monitorModel.click();
        addToCartBtn=Driver.getDriver().findElement(By.xpath("//a[.=\"Add to cart\"]"));
        addToCartBtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        homeBtn= Driver.getDriver().findElement(By.xpath("//a[contains(.,\"Home\")]"));
        homeBtn.click();
        WebElement cart = Driver.getDriver().findElement(By.xpath("//a[.=\"Cart\"]"));
        cart.click();
        WebElement deleteBtn= Driver.getDriver().findElement(By.xpath("//td[.=\"Apple monitor 24\"]//following-sibling::td[2]//a"));
        deleteBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(deleteBtn));
        WebElement totalPrice = Driver.getDriver().findElement(By.cssSelector("#totalp"));
        String actualPrice = totalPrice.getText();
        Assert.assertTrue(expectedPrice.contains(actualPrice));
        Driver.closeDriver();
    }

}
