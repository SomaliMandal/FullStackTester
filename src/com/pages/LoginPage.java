package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class LoginPage {
	@SuppressWarnings("unused")
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//input[@id='user-name']")
	public WebElement Username;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement Password;

	@FindBy(xpath = "//input[@id='login-button']")
	public WebElement Login_btn;
	

	public void login_user(Map<String,String> userDetails) throws InterruptedException {
		
		Username.sendKeys(userDetails.get("UserName"));
		Password.sendKeys(userDetails.get("Password"));
		Thread.sleep(1000);
		Login_btn.click();
	}

}
