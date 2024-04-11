package com.framework.pages;


import com.framework.basepage.BasePage;
import com.framework.basetest.PicoFactory;
import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class WistlistPage extends BasePage {
	PicoFactory picoFactory;
	Page page;
	public WistlistPage(PicoFactory picoFactory) throws IOException {
		super(picoFactory);//calls super class constructor
		this.picoFactory=picoFactory;
		this.page= picoFactory.picoPage;//not required this...but to use driver..instead of pagefactory.picodriver
	}
//=============================================Properties========================
	String product="//div[@class='products wrapper grid products-grid']/descendant::img[1]";
	String	productSize="//div[@option-label='M']";
	String productColor="//div[@option-label='Black']";
	String 	addToWishList="//div[@class='product-addto-links']/descendant::span[text()='Add to Wish List']";
	String proQuantity="//input[@id='qty']";
	String cartQty="//span[@class='counter-number']";

	//===============================================Methods=================================



	public void chooseProduct()
	{
		clickElement(page.locator(product), "product");

	}
	public void chooseProductSize()
	{
		clickElement(page.locator(productSize), "product size");

	}
	public void chooseProductColor()
	{
		clickElement(page.locator(productColor), "product color");

	}
	public void addToWishList()
	{
		clickElement(page.locator(addToWishList), "add to wishlist");

	}
	public void enterQuanity(String qty)
	{
		enterText(page.locator(proQuantity),qty,"Quantity");

	}


	public void verifyQuanity()
	{
		//get quanity before add and after add
		String s=page.locator(cartQty).innerText();
		System.out.println(s);

	}

		}





