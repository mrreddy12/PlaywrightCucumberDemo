package webobjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;


public class Login {
  // https://www.youtube.com/watch?v=f9_AbQ1-nEU&t=4s  --webdriver manager


    WebDriver driver = null;
    @Test
    public void chromeBrowser() throws InterruptedException {
//       opens browser headless and incognito mode by default
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions=new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);
        //Browser browser=playwright.chromium().launch(launchOptions);
        Browser browser=playwright.chromium().launch(launchOptions);
        BrowserContext browserContext=browser.newContext();
        Page page=browserContext.newPage();
//     Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
//         Page page = browser.newPage();
        page.navigate("https://facebook.com");
        page.locator("//input[@id='email']").fill("testUser");
        page.locator("//input[@id='pass']").fill("testPwd");
        page.locator("//button[@name='login']").click();
        Thread.sleep(5000);
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();



   }

    @Test
    public void firefoxBrowser()
    {
        Playwright playwright = Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        Page page = browser.newPage();
        page.navigate("https://mrreddyautomation.com/playground/");
        System.out.println(page.title());
        page.close();
        browser.close();
        playwright.close();


    }

    @Test
    public void edgeBrowser()
    {
        Playwright playwright = Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));

        Page page = browser.newPage();
        page.navigate("https://mrreddyautomation.com/playground/");
        System.out.println(page.title());
        page.close();
        browser.close();
        playwright.close();


    }
    @Test
    public void safariBrowser()
    {
        Playwright playwright = Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));

        Page page = browser.newPage();
        page.navigate("https://mrreddyautomation.com/playground/");
        System.out.println(page.title());
        page.close();
        browser.close();
        playwright.close();


    }
    @Test
    public void chromeBrowserMaximize() throws InterruptedException {
        Dimension demension=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int)demension.getWidth();//default it returns float...so convert to int
        int height=(int)demension.getHeight();
        System.out.println(height+": "+ width);

        Playwright playwright = Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext browserContext=browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
        Page page = browserContext.newPage();
        page.navigate("https://mrreddyautomation.com/playground/");

        System.out.println(page.title());
        page.close();
        browser.close();
        playwright.close();



    }
    // Misc
//   page.reload();
//page.goBack();
//page.goForward();
}
