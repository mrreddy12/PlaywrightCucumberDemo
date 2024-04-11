package com.framework.pages;


import com.framework.basepage.BasePage;
import com.framework.basetest.PicoFactory;
import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class AddressPage extends BasePage {
	PicoFactory picoFactory;
	Page page;
	public AddressPage(PicoFactory picoFactory) throws IOException {
		super(picoFactory);//calls super class constructor
		this.picoFactory=picoFactory;
		this.page= picoFactory.picoPage;//not required this...but to use driver..instead of pagefactory.picodriver
	}
    public String addressBook="//a[text()='Address Book']";
    public String phoneNumber="//input[@id='telephone']";
    public String streetAddress="//input[@id='street_1']";
    public String city="//input[@name='city']";
    public String state="//select[@id='region_id']";
    public String zip="//input[@id='zip']";
    public String country="//select[@id='country']";
    public String saveAddress="//button[@class='action primary add' or @class='action save primary']";
	String saveAddressSuccessmMsg="//div[contains(@class,'message-success')]";




	public void enterPhoneNumber(String inputData)
	{
		enterText(page.locator(phoneNumber),inputData,"phone number");

	}
	public void enterStreetAddress(String inputData)
	{
		enterText(page.locator(streetAddress),inputData,"Street Address");

	}

	public void enterCity(String inputData)
	{
		enterText(page.locator(city),inputData,"city");

	}

	public void selectState(String item)
	{
		selectItem(page.locator(state),item,"state");

	}


	public void enterZIP(String inputData)
	{
		enterText(page.locator(zip),inputData,"zip");

	}

	public void selectCountry(String item)
	{
		selectItem(page.locator(country),item,"Country");

	}

	public void clickSave()
	{
		clickElement(page.locator(saveAddress),"Save Address");

	}
	public void saveMessage()
	{
	String s=page.locator(saveAddressSuccessmMsg).innerText();
		System.out.println(s);

	}
}
