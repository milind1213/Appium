package TestComponent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Utils.ConfigPropReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService server;
	public ConfigPropReader config = new ConfigPropReader();

	@BeforeClass(alwaysRun = true)
	public void launchApp() throws IOException {
		server = new AppiumServiceBuilder().usingDriverExecutable(new File(config.prop().getProperty("nodePath")))
				.withAppiumJS(new File(config.prop().getProperty("mainJs")))
				.withIPAddress("127.0.0.1")
				.usingPort(4723).build();
		server.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(config.prop().getProperty("deviceName"));
		options.setApp(config.prop().getProperty("appPath"));
		options.setChromedriverExecutable("/home/milind/chromedriver");
		//options.setCapability("browserName","chrome");
		driver = new AndroidDriver(new URL(config.prop().getProperty("URL")),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	} 
 
	
	@AfterClass(alwaysRun = true)
	public void closeApp() {
		if (driver != null) {
			driver.quit();
		}
		if (server != null && server.isRunning()) {
			server.stop();
		}
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
		ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
		ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"direction",direction,"percent",0.75));
	}

	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;

	}
}
