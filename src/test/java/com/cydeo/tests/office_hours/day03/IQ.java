package com.cydeo.tests.office_hours.day03;

import com.cydeo.tests.office_hours.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*Task IQ :
        1. Navigate to: https://moneygaming.qa.gameaccount.com/
        2. Click the JOIN NOW button to open the registration page
        3. Select a title value from the dropdown
        4. Enter your first name and surname in the form
        5. Check the tickbox with text "I accept the Terms and Conditions and certify that I am over the age of 18.
        6. Submit the form by clicking the JOIN NOW button
        7. Validate that a validation message with text "This field is required" appears under the date of birth box
*/
public class IQ {
    public static void main(String[] args) {

        WebDriver driver =WebDriverFactory.getDriver("chrome");
        driver.get("https://moneygaming.qa.gameaccount.com/");
        WebElement joinNowButton = driver.findElement(By.xpath("//a[.=\"Join Now!\"]"));
        joinNowButton.click();
        Select select= new Select(driver.findElement(By.xpath("//select[@id=\"title\"]")));
        select.selectByValue("Mrs");
        WebElement nameBox= driver.findElement(By.xpath("//input[@id=\"forename\"]"));
        nameBox.sendKeys("Gina");
        WebElement lastNameBox= driver.findElement(By.xpath("//input[@name=\"map(lastName)\"]"));
        lastNameBox.sendKeys("Avila");
        WebElement tickBox= driver.findElement(By.xpath("//input[@name=\"map(terms)\"]"));
        tickBox.click();
        WebElement joinNow2Button = driver.findElement(By.xpath("//input[@id=\"form\"]"));
        joinNow2Button.click();
        WebElement validationMsg = driver.findElement(By.xpath("//label[@for=\"dob\"]"));
        String actualResult = validationMsg.getText();
        String expectedResult = "This field is required";
        System.out.println(actualResult.equals(expectedResult) ? "Passed" : "Failed");
        System.out.println(validationMsg.isDisplayed()?"Passed":"Failed");
        driver.quit();

    }

}
