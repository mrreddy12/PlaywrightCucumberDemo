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

public class ExtentReportNormalScreenshot {
    WebDriver driver = null;
    ExtentReports extentReports;// for attach,flush
    ExtentSparkReporter extentSparkReporter;//just for path
    ExtentTest extentTest;// to prvide test case details..like test case name and test case steps

    @Test
    public void   generateReportWithNormalScreenshotAtStep_Fail() throws InterruptedException, IOException {
        extentSparkReporter=new ExtentSparkReporter("D:\\Training\\Selenium\\Report\\report1.html");
        extentReports=new ExtentReports();

        extentReports.attachReporter(extentSparkReporter);

        ExtentTest extentTest= extentReports.createTest("generateReportWithTest");

      //  System.setProperty("webdriver.chrome.driver", "D:/Training/Selenium/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.navigate().to("file:///D:/AUT/AUT/AUTONE.htm");
        driver.manage().window().maximize();
        extentTest.info("Navigated to url: file:///D:/AUT/AUT/AUTONE.htm");
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("Test user");
        extentTest.info("enterd user is : test user");
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("tstpassword");
        extentTest.info("enterd password is : tstpassword");
        driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("user@testmail.com");
        extentTest.info("enterd password is : user@testmail.com");


        String path=takePageScreenshot("ss.jpg");

        extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());


        extentReports.flush();

    }

    @Test
    public void   generateReportWithNormalScreenshotAtEactStep_Fail() throws InterruptedException, IOException {
        extentSparkReporter=new ExtentSparkReporter("D:\\Training\\Selenium\\Report\\report1.html");
        extentReports=new ExtentReports();

        extentReports.attachReporter(extentSparkReporter);

        ExtentTest extentTest= extentReports.createTest("generateReportWithTest");

      //  System.setProperty("webdriver.chrome.driver", "D:/Training/Selenium/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.navigate().to("file:///D:/AUT/AUT/AUTONE.htm");
        driver.manage().window().maximize();
        String path=takePageScreenshot("ss.jpg");
        extentTest.info("Navigated to url: file:///D:/AUT/AUT/AUTONE.htm");
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("Test user");
        extentTest.info("enterd user is : test user",MediaEntityBuilder.createScreenCaptureFromPath(takePageScreenshot("ss1.jpg")).build());
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("tstpassword");
        extentTest.info("enterd password is : tstpassword",MediaEntityBuilder.createScreenCaptureFromPath(takePageScreenshot("ss2.jpg")).build());
        driver.findElement(By.xpath("//input[@id='mai']")).sendKeys("user@testmail.com");
            extentTest.info("enterd password is : user@testmail.com",MediaEntityBuilder.createScreenCaptureFromPath(takePageScreenshot("ss3.jpg")).build());




        extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(takePageScreenshot("ss3.jpg")).build());


        extentReports.flush();

    }

    public String   takePageScreenshot() throws IOException {

        //https://commons.apache.org/proper/commons-io/download_io.cgi
       TakesScreenshot scrShot =((TakesScreenshot)driver);
        String base64Code=scrShot.getScreenshotAs(OutputType.BASE64);
        return base64Code;
    }


    public String   takePageScreenshot(String fileName) throws IOException {

        //https://commons.apache.org/proper/commons-io/download_io.cgi


        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("D:\\Training\\Selenium\\Report\\screenshots\\"+fileName);
        FileUtils.copyFile(SrcFile, destFile);
        return destFile.getAbsolutePath();
    }
}