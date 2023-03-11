package org.narukaclass.framework.NarukaClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public  AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("\\Users\\asus\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		UiAutomator2Options options = new UiAutomator2Options();
		service.start();

		options.setDeviceName("Tejveer Phone");
		options.setApp("\\Users\\asus\\eclipse-workspace\\NarukaClass\\src\\main\\java\\resources\\General-Store.apk");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}

//options.setChromedriverExecutable("//Users//rahulshetty//documents//chromedriver 11");
//options.setApp("Users\\asus\\eclipse-workspace\\NarukaClass\\src\\main\\java\\resources\\General-Store.apk");
