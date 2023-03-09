//package org.narukaclass.framework.pageObjects.android;
//
//import java.util.List;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.tejveermaruka.utils.AndroidActions;
//
//import io.appium.java_client.android.AndroidDriver;
//
//public class ProductCatelog extends AndroidActions {
//
//	AndroidDriver driver;
//	public ProductCatelog(AndroidDriver driver) {
//		super(driver) ;
//		this.driver = driver;
//		PageFactory.initElements(driver, ProductCatelog.class);
//	}
//
//	@FindBy(xpath ="//android.widget.TextView[@text='ADD TO CART']")
//	private List<WebElement> addToCart ;
//	
//	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
//	private WebElement cart ;
//	
//	
//	public void addItemToCartByIndex(int index) {
//		addToCart.get(index).click();
//	}
//	public void goToCartPage() throws InterruptedException {
//		cart.click() ;
//		Thread.sleep(2000);
//		
//	}
//}
