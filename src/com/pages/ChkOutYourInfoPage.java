package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class ChkOutYourInfoPage {
	@SuppressWarnings("unused")
	private WebDriver driver;

	public ChkOutYourInfoPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//input[@name='firstName']")
	public WebElement Firstname;

	@FindBy(xpath = "//input[@name='lastName']")
	public WebElement Lastname;

	@FindBy(xpath = "//input[@id='postal-code']")
	public WebElement Postalcode;
	
	@FindBy(xpath = "//input[@id='continue']")
	public WebElement Continue;
	
	public void Checkoutinfo(Map<String,String> customerDetails) throws InterruptedException {
		
		Firstname.sendKeys(customerDetails.get("Firstname"));
		Lastname.sendKeys(customerDetails.get("Lastname"));
		Postalcode.sendKeys(customerDetails.get("Postalcode"));
		Thread.sleep(1000);
		Continue.click();
	}

}
