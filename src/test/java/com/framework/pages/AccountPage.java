package com.framework.pages;


import com.framework.basepage.BasePage;
import com.framework.basetest.PicoFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class AccountPage extends BasePage {
	PicoFactory picoFactory;
	Page page;
	public AccountPage(PicoFactory picoFactory) throws IOException {
		super(picoFactory);//calls super class constructor
		this.picoFactory=picoFactory;
		this.page= picoFactory.picoPage;//not required this...but to use driver..instead of pagefactory.picodriver
	}
//
//	public AccountPage(PicoFactory picoFactory) throws IOException {
//		this.picoFactory = picoFactory;}
//===============================================Properties========================
	String firstName="//input[@id='firstname']";
	String	lastName="//input[@id='lastname']";
	String email="//input[@id='email_address']";
	String 	password="//input[@id='password']";
	String confirmPassword="//input[@id='password-confirmation']";
	String createAccount="//button[@title='Create an Account']//span[contains(text(),'Create an Account')]";
	String accountSuccessmMsg="//div[contains(@class,'message-success')]";


	//String addressBook="//a[text()='Address Book']";

   //===============================================Methods=================================
	public void enterFirstname(String inputData)
	{
		enterText(page.locator(firstName),inputData,"first name");
	}
	public void enterLastName(String pwd)
	{
		enterText(page.locator(lastName),pwd,"last name");

	}
	public void enterEmail(String pwd)
	{
		enterText(page.locator(email),pwd,"email");

	}

	public void enterPassword(String pwd)
	{

		enterText(page.locator(password),pwd,"password");

	}

	public void enterConfirmPassword(String pwd)
	{
		enterText(page.locator(confirmPassword),pwd,"confirm password");

	}

	public void clickCreateAccount()
	{
	clickElement(page.locator(createAccount), "create account");

	}

	public void accountSuccessMsg()
	{
		String s=page.locator(accountSuccessmMsg).innerText();
		System.out.println(s);

	}







}
