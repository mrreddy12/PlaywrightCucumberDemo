package com.framework.basepage;

import com.framework.basetest.PicoFactory;
import com.framework.util.PropUtil;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;



public class BasePage {
	PicoFactory picoFactory;
	Page page;
	public BasePage(PicoFactory picoFactory) throws IOException {
	//	super(picoFactory);//calls super class constructor
		this.picoFactory=picoFactory;
		this.page= picoFactory.picoPage;//not required this...but to use driver..instead of pagefactory.picodriver
	}

	//private static final long TIMEOUT = 10;

	protected static String outgoingFileName = "";

	public HashMap<String, String> tableValues = new HashMap<String, String>();

	public HashMap<String, String> tableSpec = new HashMap<String, String>();


	public static List<File> fileBucket = new ArrayList<File>();

	public static String textFieldVal = " ";
    

//public boolean waitForElementClickable(Page element) {
//	boolean blnVal;
//	WebElement webElement = null;
//
//	try {
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
//		logInfo("element is presented");
//		blnVal= true;
//	} catch (Exception e) {
//		blnVal=false;
//		logInfo(" Wait failed for 30 seconds " + e.getMessage());
//	}
//
//	return blnVal;
//}
//	public boolean waitForElementClickable(WebElement element, long timeOut) {
//          boolean blnVal;
//		//WebElement webElement = null;
//
//		try {
//
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
//			 wait.until(ExpectedConditions.elementToBeClickable(element));
//			logInfo("element is presented");
//			blnVal= true;
//		} catch (Exception e) {
//			logInfo(" Wait failed for 30 seconds " + e.getMessage());
//			blnVal= false;
//		}
//
//		return blnVal;
//	}
//	public boolean waitForElementDisplay(WebElement webElement) {
//		boolean blnVal;
//				try {
//					webElement.isDisplayed();
//					blnVal= true;
//					logInfo("element is displayed");
//				} catch (Exception e) {
//
//				blnVal= true;
//					logInfo("element is not displayed"+e.getMessage());
//
//				}
//		return blnVal;
//			}


	public void enterText(Locator webElement, String textToEnter, String label) {
		try {
			      // waitForElementDisplay(webElement);
				//	waitForElementClickable(webElement);




			webElement.clear();
			sleep(1);
			webElement.fill(textToEnter);
			logInfo("Entered Text: "+textToEnter+" in "+label);
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}

	}

	public void clickElement(Locator webElement, String label) {
	//	waitForElementDisplay(webElement);
		//waitForElementClickable(webElement);
		try {
			webElement.click();
			logPass("Click action performed on :"+ label);
		}
		catch (Exception e)
		{
			logFail(label + " :  Click action is not performed on "+label +e.getMessage());
		}

	}

	public void selectItem(Locator webElement, String itemToSelect, String label) {
		try {
			//waitForElementDisplay(webElement);
			//waitForElementClickable(webElement);
			webElement.selectOption(new SelectOption().setLabel(itemToSelect));
			//page.locator("//select[@name='select']").selectOption(new SelectOption().setLabel("Cloud"));

			logInfo("Selected item: "+itemToSelect+" from "+label);
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}

	}
	public void isDisplayedThenActionClick(WebElement locator, String message) {
		try {
			waitUntilElementDisplayed(locator);
			if (locator.isDisplayed()) {
				actionClick(locator);
				logPass(message + " id Displayed and Clicked on it.");
			} else {
				logFail(message + " is Not Displayed");
			}
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}


	public void JSClick(WebElement locator, String message) {
		try {
			waitUntilElementDisplayed(locator);
			if (locator.isDisplayed()) {
			//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", locator);
				actionClick(locator);
				logPass(message + " id Displayed and JSClick is done.");
			} else {
				logFail(message + " is Not Displayed-JSClick is not done");
			}
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}

		public void JSEnterText(WebElement locator, String message, String sendText) {
			try {
				waitUntilElementDisplayed(locator);
				if (locator.isDisplayed()) {
				//	((JavascriptExecutor) driver).executeScript("arguments[0].value='" + sendText + "';", locator);
					logPass(message + " id Displayed and JSClick is done.");
				} else {
					logFail(message + " is Not Displayed-JSClick is not done");
				}
			} catch (Exception ex) {
				logFail(ex.getMessage());
			}
		}
		
		




	/**
	 * @param locator
	 * @param message
	 */
	public void isDisplayedThenClickRadioBTN(WebElement locator, String message) {
		try {
			waitUntilElementDisplayed(locator);
		//	isDisplayed(locator, message);
			boolean isEnabledORNot = locator.isSelected();
			if (!isEnabledORNot) {
				locator.click();
				logPass(message + " is selected");
			}

			else {
				logInfo(message + " already selected");
			}

		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}

	/**
	 * @param locator
	 * @param message
	 * @return
	 */
	public boolean isElementEnabled(WebElement locator, String message) {
		boolean isEnabledORNot = true;
		try {
			isEnabledORNot = locator.isEnabled();
			if (isEnabledORNot) {
				logInfo(message + " Enabled");
			}

		} catch (Exception ex) {

			isEnabledORNot = false;
			logInfo(message + " Not Enabled");
		}
		return isEnabledORNot;
	}




	public String getText(WebElement locator) {
		String text = "";
		try {

			if (locator.isDisplayed()) {

				text = locator.getText().trim();
				if (text == "") {
					text = locator.getAttribute("submittedvalue");

				}
			}
			return text;
		} catch (Exception ex) {
			logFail(ex.getMessage());
			return null;
		}
	}


	public void selectDropDownByIndex(WebElement locator, int index) {
		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.visibilityOf(locator));
			Select selectDropDown = new Select(locator);
			selectDropDown.selectByIndex(index);
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}




	/**
	 * @param msg
	 */
	public void logInfo(String msg) {
		//test.info(MarkupHelper.createLabel(msg, ExtentColor.BLUE));
	}


	public void logFail(String msg) {
		//test.fail(MarkupHelper.createLabel(msg, ExtentColor.RED));
		Assert.assertFalse(true, msg);
	}

	/**
	 * @param msg
	 */
	public void softFail(String msg) {
		SoftAssert softAssert = new SoftAssert();
	//	test.fail(MarkupHelper.createLabel(msg, ExtentColor.PINK));
		softAssert.assertFalse(true, msg);
	}


	public void logPass(String msg) throws IOException {
		//test.pass(MarkupHelper.createLabel(msg, ExtentColor.GREEN));
		String screenShotPath=null;
		String base64=null;
     // String s=PropUtils.getPropKeyVal("TakeScreenshot");
	 // String ss=PropUtils.getPropValue(configProp,"TakeScreenshot");
		//if(PropUtils.getPropValue(configProp,"TakeScreenshot").equalsIgnoreCase("True"))
			if(PropUtil.getPropKeyVal("TakeScreenshot").equalsIgnoreCase("True"))

		{
			try
			{
				//if(PropUtils.getPropValue(configProp,"Base64").equalsIgnoreCase("True"))
					if(PropUtil.getPropKeyVal("Base64").equalsIgnoreCase("True"))
				{

						//test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());//for base64 screenshot

				}
				else {
				//	test.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());// for normal screenshot
				}

			}
			catch(Exception  e){
				e.printStackTrace();}
		}
		Assert.assertTrue(true,msg);
	}

	/**
	 * @param seconds
	 */
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}



	public void selectDropDownByVisibleTextUsingValue(WebElement locator, String textToChoose) {
		try {
			Select selectDropDown = new Select(locator);
			selectDropDown.selectByValue(textToChoose);
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}


	public void compareTwoValues(String expValue,String actValue) throws IOException {
		if(expValue.equals(actValue))
		   logPass("Both values are equal - "+expValue+":"+actValue);
		else
			logFail("Both values are different - "+expValue+":"+actValue);
	}

	public void waitUntilElementDisplayed(final WebElement webElement) {
		// driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					webElement.isDisplayed();
					return true;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		//wait.until(elementIsDisplayed);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	public void actionClick(WebElement locator) {
		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.visibilityOf(locator));
//			Actions act = new Actions(driver);
//			act.moveToElement(locator).click(locator).build().perform();
		} catch (Exception ex) {
			logFail(ex.getMessage());
		}
	}
}
