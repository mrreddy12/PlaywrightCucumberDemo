package com.framework.pages;

import com.framework.basepage.BasePage;
import com.framework.basetest.PicoFactory;
import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;



public class LoginPage extends BasePage {
	//===============================================Properties========================
	PicoFactory picoFactory;
	Page page;
	public LoginPage(PicoFactory picoFactory) throws IOException {
		super(picoFactory);//calls super class constructor
		this.picoFactory=picoFactory;
		this.page= picoFactory.picoPage;//not required this...but to use driver..instead of pagefactory.picodriver
	}
    String email="//input[@id='email']";
    String	password="//input[@title='Password']";
	String signIn="//button[@class='action login primary']";
 String signInConfirm="//div[@class='panel header']//span[@class='logged-in']";

	//===============================================Properties========================

	//===============================================Methods========================

	public void enterEmail(String uname)
	{
		enterText(page.locator(email),uname,"username field");

	}
	public void enterPassword(String pwd)
	{
		enterText(page.locator(password),pwd,"password filed field");

	}

	public void clickSignIn()
	{
		clickElement(page.locator(signIn), "Sign in Button");

	}
	public void isLoggedIn()
	{
		String s=page.locator(signInConfirm).innerText();
		System.out.println(s);

	}



	}





