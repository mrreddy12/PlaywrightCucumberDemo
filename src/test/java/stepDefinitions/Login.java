package stepDefinitions;

import com.framework.basetest.PicoFactory;
import com.framework.pages.LandingPage;
import com.framework.pages.LoginPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Login {
  PicoFactory picoFactory;
  Page page;
  public Login(PicoFactory picoFactory) throws IOException {
    this.picoFactory = picoFactory;
    this.page= picoFactory.picoPage;
  }

  @Given("User is on the login page")
    public void user_is_on_the_login_page() throws IOException {
        LandingPage landingPage=new LandingPage(picoFactory);
        landingPage.clickToSignIn();

    }
    @When("User enters user id as {string} and passowrd as {string}")
    public void user_enters_user_id_as_and_passowrd_as(String email, String pwd) throws IOException {
      LoginPage loginPage=new LoginPage(picoFactory);
      loginPage.enterEmail(email);
      loginPage.enterPassword(pwd);

    }
    @When("User clicks on sign-in button")
    public void user_clicks_on_signin_button() throws IOException {
      LoginPage loginPage=new LoginPage(picoFactory);
                loginPage.clickSignIn();
    }
    @Then("User is on home page.")
    public void user_is_on_home_page() throws IOException {
      LoginPage loginPage=new LoginPage(picoFactory);
      //loginPage.isLoggedIn();
    }

}
