package stepDefinitions;

import com.framework.basetest.PicoFactory;
import com.framework.pages.AccountPage;
import com.framework.pages.LandingPage;
import com.framework.util.GlobalUtil;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Account {
    PicoFactory picoFactory;
    Page page;
    public Account(PicoFactory picoFactory) throws IOException {
        this.picoFactory = picoFactory;
        this.page= picoFactory.picoPage;
    }



    @Given("User is on the Customer Account creation page")
    public void user_is_on_the_customer_account_creation_page() throws IOException {
        LandingPage landingPage=new LandingPage(picoFactory);
        landingPage.clickToCreateAccount();

    }
    @When("User enters Personal Information as {string},{string} and Sign-in information as {string},{string} and {string}")
    public void user_enters_personal_information_as_and_sign_in_information_as_and(String string, String string2, String string3, String string4, String string5) throws IOException {
        String n=RandomStringUtils.randomNumeric(4);
        String strEmail="testEmail"+n+"@gmail.com";
        GlobalUtil.email=strEmail;
         AccountPage accountPage=new AccountPage(picoFactory);
         accountPage.enterFirstname("rr");
         accountPage.enterLastName("ss");
         accountPage.enterEmail(strEmail);
         accountPage.enterPassword("Password123");
         accountPage.enterConfirmPassword("Password123");
    }
    @When("User clicks on Create an account button")
    public void user_clicks_on_create_an_account_button() throws IOException {
        AccountPage accountPage=new AccountPage(picoFactory);
        accountPage.clickCreateAccount();
    }
    @Then("User is on My Account page and verify SuccessMessage.")
    public void user_is_on_my_account_page_and_verify_SuccessMessage() throws IOException {
        AccountPage accountPage=new AccountPage(picoFactory);
        accountPage.accountSuccessMsg();
        //accountPage.clickAddressbook();

    }
}
