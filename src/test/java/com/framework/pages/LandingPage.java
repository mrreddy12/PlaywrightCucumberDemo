package com.framework.pages;


import com.framework.basepage.BasePage;
import com.framework.basetest.PicoFactory;
import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class LandingPage extends BasePage {

	PicoFactory picoFactory;
	Page page;
	public LandingPage(PicoFactory picoFactory) throws IOException {
		super(picoFactory);//calls super class constructor
		this.picoFactory=picoFactory;
		this.page= picoFactory.picoPage;//not required this...but to use driver..instead of pagefactory.picodriver
	}

	//===============================================Properties========================
String createAccountlink="//header[@class='page-header']/descendant::li[3]";
	String signIn="//header[@class='page-header']/descendant::li[2]";
//===============================================Objects========================
;


//===============================================Methods========================

	public void clickToCreateAccount()
	{

	clickElement(page.locator(createAccountlink), "Create an Account link");

	}

	public void clickToSignIn()
	{

		clickElement(page.locator(signIn), "Sign in link");

	}






}
