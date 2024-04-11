package webobjects;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import java.awt.*;
import java.nio.file.Path;


public class Browsers {
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
        page.navigate("https://mrreddyautomation.com/playground/");
        System.out.println(page.title());
        Thread.sleep(5000);
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();



   }

    @Test
    public void firefoxBrowser() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("firefox"));
        Page page = browser.newPage();
        page.navigate("https://mrreddyautomation.com/playground/");
        System.out.println(page.title());
        Thread.sleep(5000);
        page.close();
        browser.close();
        playwright.close();


    }

    @Test
    public void edgeBrowser() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));

        Page page = browser.newPage();
        page.navigate("https://mrreddyautomation.com/playground/");
        System.out.println(page.title());
        Thread.sleep(5000);
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
