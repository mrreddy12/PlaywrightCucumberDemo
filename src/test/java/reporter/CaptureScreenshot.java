package reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {
    WebDriver driver = null;

    @Test
    public void   takePageScreenshot() throws IOException, InterruptedException {

        //https://commons.apache.org/proper/commons-io/download_io.cgi
      //  System.setProperty("webdriver.chrome.driver", "D:/Training/Selenium/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.navigate().to("file:///D:/AUT/AUT/AUTONE.htm");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        TakesScreenshot takesScreenshot =((TakesScreenshot)driver);
        File fileType=takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("D:\\Training\\Selenium\\Report\\screenshots\\rr.png");
        FileUtils.copyFile(fileType, destFile);

    }
}