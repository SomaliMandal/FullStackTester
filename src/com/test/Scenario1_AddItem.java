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
import com.base.BaseClass;
import com.pages.ChkOutOverviewPage;
import com.pages.ChkOutYourInfoPage;
import com.pages.CompletePage;
import com.pages.LoginPage;
import com.pages.SelectProductPage;
import com.pages.YourCartPage;


public class Scenario1_AddItem extends BaseClass {

	@Test
	public void Scenario_1() throws InterruptedException {
		
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
		
		selectproduct.select_Backpack();
		
		selectproduct.select_Tshirt();
		
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
		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(".//ScreenShots//Scenario-1.png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 //Assert.assertTrue(regSuccess.successMessage.isDisplayed());
		//Assert.assertTrue(false);
		//
	}

}
