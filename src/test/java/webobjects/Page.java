package webobjects;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Page {
    WebDriver driver = null;

    @Test
    public void verifyTitle() {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions=new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");//instead of channel
        launchOptions.setHeadless(false);
        Browser browser=playwright.chromium().launch(launchOptions);
        com.microsoft.playwright.Page page = browser.newPage();
        page.navigate("https://mrreddyautomation.com/playground/");
        String actTitle = page.title();
        System.out.println(actTitle);

    }

    @Test
    public void verifyURL() {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions=new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");//instead of channel
        launchOptions.setHeadless(false);
        Browser browser=playwright.chromium().launch(launchOptions);
        com.microsoft.playwright.Page page = browser.newPage();
        page.navigate("https://mrreddyautomation.com/playground/");
        String actTitle = page.url();
        System.out.println(actTitle);

    }

    @Test
    public void verifyPageSource() {
       // System.setProperty("webdriver.chrome.driver", "D:/Training/Selenium/drivers/chromedriver.exe");
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions=new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");//instead of channel
        launchOptions.setHeadless(false);
        Browser browser=playwright.chromium().launch(launchOptions);
        com.microsoft.playwright.Page page = browser.newPage();
        page.navigate("https://mrreddyautomation.com/playground/");
        String pageSource = page.content();

        System.out.println("page source:"+pageSource);
        //String expText="Portal";
        String expText="Web Table";
      if(pageSource.contains(expText))

        {
            System.out.println(expText +" is exists in webpage");
           // Assert.assertEquals("Portal","Portal");
        }
        else
        {
            System.out.println(expText +" is not exists in webpage");
            //.assertEquals("Portal",expText);
        }

    }
}