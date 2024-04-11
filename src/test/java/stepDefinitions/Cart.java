package stepDefinitions;

import com.framework.basetest.PicoFactory;
import com.framework.pages.CartPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Cart {
    PicoFactory picoFactory;
    Page page;
    public Cart(PicoFactory picoFactory) throws IOException {
        this.picoFactory = picoFactory;
        this.page= picoFactory.picoPage;
    }


    @When("User Selects Add to Cart")
    public void user_selects_add_to_cart() throws IOException {
        CartPage cartPage=new CartPage(picoFactory);
        cartPage.addToCart();

    }
    @Then("Products should be added to Cart")
    public void products_should_be_added_to_cart() throws IOException {
        CartPage cartPage=new CartPage(picoFactory);
        cartPage.verifyQuanity();
    }
}
