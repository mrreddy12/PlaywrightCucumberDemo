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

public class ExtentReport {
    WebDriver driver = null;
    ExtentReports extentReports;// for attach,flush
    ExtentSparkReporter extentSparkReporter;//just for path
    ExtentTest extentTest;// to prvide test case details..like test case name and test case steps

    @Test
    public void   generateBasicReport() throws InterruptedException {
        extentSparkReporter=new ExtentSparkReporter("D:\\Training\\Selenium\\Report\\report.html");
         extentReports=new ExtentReports();

         extentReports.attachReporter(extentSparkReporter);
         extentReports.flush();

    }
    @Test
    public void   generateReportWithPassStatus() throws InterruptedException {
       // add testcase name and pass status
        extentSparkReporter=new ExtentSparkReporter("D:\\Training\\Selenium\\Report\\report.html");
         extentReports=new ExtentReports();

        extentReports.attachReporter(extentSparkReporter);
        ExtentTest extentTest= extentReports.createTest("generateReportWithTest-testcase  title");
        extentTest.pass("given test is passed");//step
        extentReports.flush();
    }
    @Test
    public void   generateReportWithFailSatus() throws InterruptedException {
        extentSparkReporter=new ExtentSparkReporter("D:\\Training\\Selenium\\Report\\report.html");
         extentReports=new ExtentReports();

        extentReports.attachReporter(extentSparkReporter);
        ExtentTest extentTest= extentReports.createTest("generateReportWithTest-testcase  title");
        extentTest.fail("given test is failed");
        extentReports.flush();
    }


    @Test
    public void   generateReportWithSteps() throws InterruptedException, IOException {
        extentSparkReporter=new ExtentSparkReporter("D:\\Training\\Selenium\\Report\\report.html");
        extentReports=new ExtentReports();

        extentReports.attachReporter(extentSparkReporter);

     //   ExtentTest extentTest= extentReports.createTest("generateReportWithTest");

        ExtentTest extentTest= extentReports.createTest("generateReportWithTest").assignCategory("regression").assignCategory("smoke");

     //   System.setProperty("webdriver.chrome.driver", "D:/Training/Selenium/drivers/chromedriver.exe");
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
        extentTest.info("enterd email is : user@testmail.com");
        extentTest.pass("Test is passed");
        extentReports.flush();

    }

    @Test
    public void   generateCustomeReportWithDarkThemeAndSummary() throws InterruptedException, IOException {
        extentSparkReporter=new ExtentSparkReporter("D:\\Training\\Selenium\\Report\\report.html");
        extentReports=new ExtentReports();

        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports.setSystemInfo("Tester","vishnu");
        extentReports.setSystemInfo("Tool","Selenium");
        extentReports.setSystemInfo("Browser","chrome");
        extentReports.setSystemInfo("OS","Win-10");
        extentSparkReporter.config().setReportName("ABCAutomationReport");//dont give space...graphs wont display

        ExtentTest extentTest= extentReports.createTest("generateReportWithTest");

       // System.setProperty("webdriver.chrome.driver", "D:/Training/Selenium/drivers/chromedriver.exe");
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



        extentReports.flush();

    }


}