package com.demoblaze.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy(id = "nameofuser")
    public WebElement welcomeUserName_loc;

    public void verifyLogin(String expectedUsername){
       String actualUsername = welcomeUserName_loc.getText();
        Assert.assertEquals("user does NOT message",expectedUsername,actualUsername);
        System.out.println("expectedUsername = " + expectedUsername);
        System.out.println("actualUsername = " + actualUsername);
    }
}
