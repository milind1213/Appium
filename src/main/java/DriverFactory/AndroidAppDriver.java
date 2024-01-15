package DriverFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import CommonUtils.AppiumServer;

public class AndroidAppDriver {
	public AndroidDriver driver;
	 AppiumServer server = new AppiumServer();
	public AndroidDriver getAndroidInstance() throws MalformedURLException {
	
		server.startServer();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 7 Pro API 31");
		options.setApp("/home/milind/eclipse-workspace/projects/mobile/MobileSolutions/Apps/ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	 }
	
	 public AndroidDriver getDriver() {
		return driver;
	 }

}
