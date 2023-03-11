package org.narukaclass.framework.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tejveermaruka.utils.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class FormPage extends AndroidActions {
	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@FindBy(xpath = "//android.widget.RadioButton[@text ='Female']")
	private WebElement femaleOptions;

	@FindBy(xpath = "//android.widget.RadioButton[@text ='Male']")
	private WebElement maleOptions;

	@FindBy(id = "android:id/text1")
	private WebElement searchCountry;

	@FindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;

	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}

	public void setGender(String gender) {
		if (gender.contains("female"))
			femaleOptions.click();
		else
			maleOptions.click();
	}

	public void selectCountry(String countryName) {
		searchCountry.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
	}

	public void sumbmitForm() {
		shopButton.click();

	}

	public void scrollToText(String text) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
	}

}
