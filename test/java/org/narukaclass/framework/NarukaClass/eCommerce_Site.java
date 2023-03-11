package org.narukaclass.framework.NarukaClass;

import java.util.Set;

import org.narukaclass.framework.pageObjects.android.CartPage;
//import org.narukaclass.framework.pageObjects.android.CartPage;
import org.narukaclass.framework.pageObjects.android.FormPage;
import org.narukaclass.framework.pageObjects.android.ProductCatelog;
//import org.narukaclass.framework.pageObjects.android.ProductCatelog;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_Site extends BaseClass {

	@Test
	public void FillForm() throws InterruptedException  {
		
		FormPage formPage = new FormPage(driver);
		formPage.setNameField("Tejveer Singh ");
		formPage.setGender("female");
		formPage.selectCountry("Argentina");
		formPage.sumbmitForm();
		
		ProductCatelog productCatelog = new ProductCatelog(driver) ; 
		productCatelog.addItemToCartByIndex(0);
		productCatelog.addItemToCartByIndex(1);
		productCatelog.goToCartPage();
		
		CartPage cartPage = new CartPage(driver) ; 
		double totalSum = cartPage.getProductsSum();
		double disPlayFormattedSum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, disPlayFormattedSum);
		cartPage.accceptTermsConditions();
		cartPage.submitOrder();

		Thread.sleep(6000);
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) {
			System.out.println(contextName);
		}

		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");

	}

	

}
