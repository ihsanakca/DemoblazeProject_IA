package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrder_loc;

    @FindBy(id = "name")
    public WebElement name_loc;

    @FindBy(id = "country")
    public WebElement country_loc;

    @FindBy(id = "city")
    public WebElement city_loc;

    @FindBy(id = "card")
    public WebElement creditCard_loc;

    @FindBy(id = "month")
    public WebElement month_loc;

    @FindBy(id = "year")
    public WebElement year_loc;

    @FindBy(xpath = "//button[text()='Purchase']")
    public WebElement purchaseButton_loc;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    public WebElement confirmationMessage_loc;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement okBtn_loc;

    int actualAmount;
    public void removeProduct(String product){
        BrowserUtils.waitForClickablility(cartPage_loc,3).click();
        WebElement deleteProduct = Driver.get().findElement(By.xpath("//td[text()='"+product+"']//..//a"));
        BrowserUtils.waitFor(3);
        BrowserUtils.waitForClickablility(deleteProduct,3);
        deleteProduct.click();
        BrowserUtils.waitFor(3);
        ProductPage.sum-=1;
    }
    public void fillForm_mtd(){
        Faker faker=new Faker();
        BrowserUtils.waitFor(1);
        name_loc.sendKeys(faker.name().fullName());
        BrowserUtils.waitFor(1);
        country_loc.sendKeys(faker.country().name());
        BrowserUtils.waitFor(1);
        city_loc.sendKeys(faker.country().capital());
        BrowserUtils.waitFor(1);
        creditCard_loc.sendKeys(faker.finance().creditCard());
        BrowserUtils.waitFor(1);
        month_loc.sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        BrowserUtils.waitFor(1);
        year_loc.sendKeys(String.valueOf(faker.number().numberBetween(2022,2030)));
        BrowserUtils.waitFor(1);
    }
    public void finishPurchase_AndLogAmount(){
        BrowserUtils.waitForClickablility(placeOrder_loc,3).click();
        fillForm_mtd();
        BrowserUtils.waitForClickablility(purchaseButton_loc,3).click();
        String confirmationMessage = confirmationMessage_loc.getText();
        System.out.println("confirmationMessage = " + confirmationMessage);

        String[] confirmationArray = confirmationMessage.split("\n");

       actualAmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);
       BrowserUtils.waitFor(2);
       okBtn_loc.click();
    }
    public void verifyPurchaseAmount_mtd(int expectedAmount){
        Assert.assertEquals(expectedAmount,actualAmount);
        System.out.println("expectedAmount = " + expectedAmount);
        System.out.println("actualAmount = " + actualAmount);
        System.out.println("ProductPage.sum = " + ProductPage.sum);
    }
}
