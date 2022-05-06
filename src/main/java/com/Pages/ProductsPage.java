package com.Pages;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsPage extends BaseTest{
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
	public MobileElement productTitleTxt;
	
	@AndroidFindBy (xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")
	public MobileElement addToCart;
	
	@AndroidFindBy (xpath = "(//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")
	public MobileElement removeCart;
	
	@AndroidFindBy (xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]")
	public MobileElement addToCartItem2;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")
	public MobileElement clickCart;
	
	
	public String getTitle() {
		String title = getText(productTitleTxt);
		return title;
	}

	public void clickAddToCart() {
		click(addToCart);
	}
	
	public void clickRemoveFromCart() {
		click(removeCart);
	}
	
	public void clickAddToCartItem2() {
		click(addToCartItem2);
	}

	public void clickCart() {
		click(clickCart);
	}


}
