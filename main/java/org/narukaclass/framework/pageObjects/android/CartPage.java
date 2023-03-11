package org.narukaclass.framework.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tejveermaruka.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;

public class CartPage extends AndroidActions {

	 AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;

	@FindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;

	@FindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement term;

	@FindBy(id = "android:id/button1")
	private WebElement acceptButton;

	@FindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;

	@FindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;

	public List<WebElement> getProductList() {
		return productList;
	}

	public double getProductsSum() {
		int count = productList.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = productList.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;

		}
		return totalSum;
	}

	public double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());
	}

	public void accceptTermsConditions() {
		longPressAction(term);
		acceptButton.click();
	}

	public Double getFormattedAmount(String amount) {
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	public void submitOrder() {
		checkBox.click();
		proceed.click();
	}
}
