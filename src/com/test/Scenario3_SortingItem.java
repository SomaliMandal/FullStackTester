package com.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.base.BaseClass;
import com.pages.ChkOutOverviewPage;
import com.pages.ChkOutYourInfoPage;
import com.pages.CompletePage;
import com.pages.LoginPage;
import com.pages.SelectProductPage;
import com.pages.YourCartPage;

public class Scenario3 extends BaseClass {

	@Test
	public void Scenario_3() throws InterruptedException {
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		SelectProductPage selectproduct = PageFactory.initElements(driver, SelectProductPage.class);
		YourCartPage yourcart = PageFactory.initElements(driver, YourCartPage.class);
		ChkOutYourInfoPage yourinfo = PageFactory.initElements(driver, ChkOutYourInfoPage.class);
		ChkOutOverviewPage overview = PageFactory.initElements(driver, ChkOutOverviewPage.class);
		CompletePage confirmation = PageFactory.initElements(driver, CompletePage.class);
		
		Map<String, String> userDetails = new HashMap<String, String>();
		
		userDetails.put("UserName", "standard_user");
		userDetails.put("Password", "secret_sauce");
		login.login_user(userDetails);
		
		Assert.assertEquals(driver.getTitle(),"Swag Labs");
		
		selectproduct.Sort_item();
		
		selectproduct.Sort_lowtohigh();
		
		Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
		Shutterbug.shootPage(driver).save("Path");
		
		Thread.sleep(1000);
		
		selectproduct.select_Bikelight();
		
		selectproduct.click_Cart();
		
		yourcart.click_Checkout();
		
		Map<String, String> customerDetails = new HashMap<String, String>();
		
		customerDetails.put("Firstname", "abc");
		customerDetails.put("Lastname", "def");
		customerDetails.put("Postalcode", "400087");
		
		yourinfo.Checkoutinfo(customerDetails);
		
		overview.clickOnFinish();
		
		confirmation.Validate_headermsg();
		
		confirmation.Validate_orderconfirmationmsg();
		
		Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();
		Shutterbug.shootPage(driver).save("Path");
		
		 //Assert.assertTrue(regSuccess.successMessage.isDisplayed());
		//Assert.assertTrue(false);
		//
	}

}
