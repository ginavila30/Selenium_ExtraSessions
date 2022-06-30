package com.cydeo.tests.pages;

import com.cydeo.tests.office_hours.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DemoBlazeIndexPage {
    public  DemoBlazeIndexPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (linkText = "Phones")
    public WebElement phonesTab;

    @FindBy (linkText = "Laptops")
    public WebElement laptopsTab;

    @FindBy (linkText = "Monitors")
    public WebElement monitorsTab;

    @FindBy (xpath = "(//a[@href=\"prod.html?idp_=8\"])[1]")
    public WebElement sonyVaioI5;

    @FindBy(linkText = "Add to cart")
    public WebElement addToCart;

    @FindBy (linkText = "Samsung galaxy s6")
    public WebElement samsungGalaxyS6;

    @FindBy (linkText = "Apple monitor 24")
    public WebElement appleMonitor24;

    @FindBy (linkText = "Cart")
    public WebElement cart;

    @FindBy (xpath = "//td[.=\"Apple monitor 24\"]//following-sibling::td//a")
    public WebElement deleteBtnAppleMonitor;

    @FindBy (xpath = "//button[.=\"Place Order\"]")
    public WebElement placeOrderBtn;

    @FindBy (id = "name")
    public WebElement nameInput;

    @FindBy (id = "country")
    public WebElement countryInput;

    @FindBy (id = "city")
    public WebElement city;

    @FindBy (id = "card")
    public WebElement creditCardInput;

    @FindBy (id = "month")
    public WebElement monthInput;

    @FindBy (id = "year")
    public WebElement yearInput;

    @FindBy (xpath = "//button[@onclick=\"purchaseOrder()\"]")
    public WebElement purchaseBtn;

    @FindBy (xpath = "//p[@class=\"lead text-muted \"]")
    public WebElement orderConfirmation;

    @FindBy (css = ".confirm.btn.btn-lg.btn-primary")
    public WebElement okOrderConfirm;

    @FindBy (tagName = "tr")
    public List<WebElement> productsInCart; //should be more than 1 to have a product in the cart. 1 is empty cart.

    @FindBy (linkText = "Home ")
    public WebElement homeBtn;






}
