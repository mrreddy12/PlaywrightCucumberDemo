package com.framework.pages;


import com.framework.basepage.BasePage;
import com.framework.basetest.PicoFactory;
import com.microsoft.playwright.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class CartPage extends BasePage {
    PicoFactory picoFactory;
    Page page;
    public CartPage(PicoFactory picoFactory) throws IOException {
        super(picoFactory);//calls super class constructor
        this.picoFactory=picoFactory;
        this.page= picoFactory.picoPage;//not required this...but to use driver..instead of pagefactory.picodriver
    }
	//===============================================Properties========================

    String addToCart="//button[@id='product-addtocart-button']";
    String cartQuantity="//span[@class='counter-number']";

   	//===============================================End=================================


    public void addToCart()
    {
        clickElement(page.locator(addToCart), "add to Cart");

    }



    public void verifyQuanity()
    {
        //get quanity before add and after add
        String s=page.locator(cartQuantity).innerText();
        System.out.println(s);

    }





}
