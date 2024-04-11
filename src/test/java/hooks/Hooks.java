package hooks;

import com.framework.basetest.PicoFactory;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.framework.util.PropUtil;


import java.io.IOException;
import java.nio.file.Paths;

public class Hooks {
 Page page;
     PicoFactory picoFactory;///this is different from actual...we are getting driver from pico fact class and store in this via constroctor
    public Hooks(PicoFactory picoFactory) { ///from picofactory...driver instance
        this.picoFactory = picoFactory;
      //  this.driver= picoFactory.picoDriver;
    }


    @Before
    public void initDriver() throws IOException {
        String strURL=PropUtil.getPropKeyVal("url");
        picoFactory.getPage();
         page=picoFactory.picoPage;//here getting driver instance...but wont get in hooks constructor
       page.navigate(strURL);

    }
    @After
    public void quitDriver(Scenario sc) throws IOException {

        picoFactory.quitPlaywright();
    }

    @AfterStep
    public void stepScreenShot(Scenario scenario) throws IOException {
          String scnName=scenario.getName();
        byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshot/screenshot.png")));
        scenario.attach(screenshot, "image/png", "screenshot");
       // scenario.attach(screenshot, "image/png", scnName);

    }
}
