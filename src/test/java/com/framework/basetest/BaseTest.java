package com.framework.basetest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.framework.basepage.BasePage;
import com.framework.util.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

//	protected WebDriver driver;
	//public ExtentHtmlReporter htmlReporter;
	//public ExtentSparkReporter extentSparkReporter;
	//public static ExtentReports extent;

	//protected ExtentTest test;

   // public static String  configFile = PathGBuilders.CONFIG_DIR+PathGBuilders.CONFIG_FILE_NAME;
	//public static Properties configProp = PropUtils.getProps(configFile);


SystemUtil systemUtil=new SystemUtil();
	public static String resultFile;
	public static String indexFile;
	public static String reportsFolder;
	public static String instancereportsFolder;
	public static String ssFolder;
	BasePage basePage;

	//public static Reader reader;

	@BeforeSuite(alwaysRun = true)
	public void initializeReport() throws Exception {


	}

	@BeforeMethod(alwaysRun = true)
	public void initializeDriver() throws Exception {



	}


	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {

//
	}


	
	@AfterSuite(alwaysRun = true)
	public void tearDownReports() {

		try {


		
		//	driver=null;
		//extent =null;

			if (systemUtil.getOSDetails().contains("WINDOWS")) {
				Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
			} else {
				//// Other operating system logic should come here
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	

}
