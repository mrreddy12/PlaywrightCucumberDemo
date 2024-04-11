package stepDefinitions;

import com.framework.basetest.PicoFactory;
import com.framework.pages.AddressPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Address {
    PicoFactory picoFactory;
    Page page;
    public Address(PicoFactory picoFactory) throws IOException {
        this.picoFactory = picoFactory;
        this.page= picoFactory.picoPage;
    }

    @Given("User is on the Address page")
    public void user_is_on_the_address_page() {
        page.navigate("https://magento.softwaretestingboard.com/customer/address/new/");
    }
    @When("User provides the address details")
    public void user_provides_the_address_details() throws IOException {
        AddressPage addressPage=new AddressPage(picoFactory);
        addressPage.enterPhoneNumber("12345");
        addressPage.enterStreetAddress("abc street,Andhra");
        addressPage.enterCity("hyd");
        addressPage.selectCountry("India");
        addressPage.selectState("Andhra Pradesh");
        addressPage.enterZIP("12345");


    }
    @When("User clicks on Save Adress button")
    public void user_clicks_on_save_adress_button() throws IOException {
        AddressPage addressPage=new AddressPage(picoFactory);
        addressPage.clickSave();

    }
    @Then("Address should be added to the adress book")
    public void address_should_be_added_to_the_adress_book() throws IOException {
        System.out.println("hi");
        AddressPage addressPage=new AddressPage(picoFactory);
               addressPage.saveMessage();;


    }
}
