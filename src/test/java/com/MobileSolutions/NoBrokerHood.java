package com.MobileSolutions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class NoBrokerHood {
	private AndroidDriver driver;
	private AppiumDriverLocalService service;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.usingDriverExecutable(new File("/home/milind/.nvm/versions/node/v20.10.0/bin/node"))
				.withAppiumJS(
						new File("/home/milind/.nvm/versions/node/v20.10.0/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
	}

	@Test
	public void testAppiumServer() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 7 Pro API 31");
		options.setApp("/home/milind/eclipse-workspace/projects/mobile/MobileSolutions/Apps/ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		if (service != null && service.isRunning()) {
			service.stop();
		}
	}

}
