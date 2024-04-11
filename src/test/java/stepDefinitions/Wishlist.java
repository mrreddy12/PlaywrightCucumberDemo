package stepDefinitions;

import com.framework.basetest.PicoFactory;
import com.framework.pages.WistlistPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Wishlist {
    PicoFactory picoFactory;
    Page page;
    public Wishlist(PicoFactory picoFactory) throws IOException {
        this.picoFactory = picoFactory;
        this.page= picoFactory.picoPage;
    }


    @Given("User is on the Products page")
        public void user_is_on_the_products_page() {
            page.navigate("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
        }
        @When("User Selects the required product")
        public void user_selects_the_required_product() throws IOException {
            WistlistPage wistlistPage=new WistlistPage(picoFactory);
            wistlistPage.chooseProduct();
        }
    @When("User Selects the Size as medium")
    public void user_selects_the_size_as_medium() throws IOException {
        WistlistPage wistlistPage=new WistlistPage(picoFactory);
        wistlistPage.chooseProductSize();
    }
    @When("User Selects the Color as black")
    public void user_selects_the_color_as_black() throws IOException {
        WistlistPage wistlistPage=new WistlistPage(picoFactory);
        wistlistPage.chooseProductColor();
    }
    @When("User Selects the quantity")
    public void user_selects_the_quantity() throws IOException {
        WistlistPage wistlistPage=new WistlistPage(picoFactory);
        wistlistPage.enterQuanity("1");
    }
        @When("User Selects Add to Wishlist")
        public void user_selects_add_to_wishlist() throws IOException {
            WistlistPage wistlistPage=new WistlistPage(picoFactory);
            wistlistPage.addToWishList();
        }
        @Then("Products should be added to My WishList")
        public void products_should_be_added_to_my_wish_list() throws IOException {
            WistlistPage wistlistPage=new WistlistPage(picoFactory);
            wistlistPage.verifyQuanity();
        }


    }


