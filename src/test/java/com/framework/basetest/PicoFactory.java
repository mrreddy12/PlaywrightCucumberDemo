package com.framework.basetest;

import com.framework.util.PathUtil;
import com.framework.util.PropUtil;
import com.microsoft.playwright.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;



public class PicoFactory {

	public static String browserNameAndVersion;
	public static String configFile = PathUtil.CONFIG_DIR + PathUtil.CONFIG_FILE_NAME;
	public static Properties configProp = PropUtil.getProps(configFile);
       //public WebDriver picoDriver;
	public Playwright playwright;
	public Browser browser;
	public BrowserContext browserContext;
	public Page picoPage;

	@SuppressWarnings({"unused", "deprecation"})
	public  Page getPage() throws IOException
	{
		//InitExecution initExecution=new InitExecution();
		 playwright = Playwright.create();
		BrowserType.LaunchOptions launchOptions=new BrowserType.LaunchOptions();
		launchOptions.setChannel("chrome");
		launchOptions.setHeadless(false);
		//Browser browser=playwright.chromium().launch(launchOptions);
		 browser=playwright.chromium().launch(launchOptions);
		 browserContext=browser.newContext();
		picoPage=browserContext.newPage();

	//


				 return picoPage;

	}

	public void quitPlaywright()
	{
		picoPage.close();
		browserContext.close();
		browser.close();
		playwright.close();
	}
}

