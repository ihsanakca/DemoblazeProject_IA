package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_StepDefs {
    ProductPage productPage=new ProductPage();
    CartPage cartPage=new CartPage();
    @When("The user adds {string} to cart from {string}")
    public void the_user_adds_to_cart_from(String product, String category) {
        productPage.addProduct_mtd(product,category);
    }
    @When("The user removes {string}  from cart")
    public void the_user_removes_from_cart(String product) {
        cartPage.removeProduct(product);
    }
    @When("The user places order and capture and log amount")
    public void the_user_places_order_and_capture_and_log_amount() {
        cartPage.finishPurchase_AndLogAmount();

    }
    @Then("The user verifies purchase  amount equal {int}")
    public void the_user_verifies_purchase_amount_equal(Integer expectedAmount) {
        cartPage.verifyPurchaseAmount_mtd(expectedAmount);
    }
}
