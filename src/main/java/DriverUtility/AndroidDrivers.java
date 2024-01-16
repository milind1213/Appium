package DriverUtility;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import CommonUtility.AppiumServer;
import Utils.ConfigPropReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidDrivers {
	public static int EXPLICIT_WAIT_TIME;
	public static int IMPLICIT_WAIT_TIME;
	public static int DEFAULT_WAIT_TIME;
	public static String DEVICE_NAME;
	public static String APPLICATION_PATH;
	public static String CHROME_DRIVER_PATH;
	public static String BROWSER_NAME;
	public static String APP_PASSWORD;
	public static String AUTOMATION_INSTRUMENTATION;
	public static String PLATFORM_NAME;
	public static String NEW_COMMAND_TIMEOUT;
	public static String PLATFORM_VERSION;
	public static String DEVICE_READY_TIMEOUT;
	public static String BASE_PKG;
	public static String APP_ACTIVITY;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static UiAutomator2Options options = new UiAutomator2Options();
	public static ConfigPropReader config = new ConfigPropReader();
	public static AppiumServer appiumServer = new AppiumServer();
	private static AndroidDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void loadConfigProp() throws IOException {
		EXPLICIT_WAIT_TIME = Integer.parseInt(config.aap().getProperty("explicit.wait"));
		IMPLICIT_WAIT_TIME = Integer.parseInt(config.aap().getProperty("implicit.wait"));
		DEFAULT_WAIT_TIME = Integer.parseInt(config.aap().getProperty("default.wait"));
		APPLICATION_PATH = config.aap().getProperty("application.path");
		CHROME_DRIVER_PATH = config.aap().getProperty("chromedriver.path");
		BASE_PKG = config.aap().getProperty("base.pkg");
		APP_ACTIVITY = config.aap().getProperty("application.activity");
		AUTOMATION_INSTRUMENTATION = config.aap().getProperty("automation.instumentation");
		DEVICE_NAME = config.aap().getProperty("device.name");
		BROWSER_NAME = config.aap().getProperty("browser.name");
		PLATFORM_NAME = config.aap().getProperty("platform.name");
		PLATFORM_VERSION = config.aap().getProperty("platform.version");
		NEW_COMMAND_TIMEOUT = config.aap().getProperty("new.command.timeout");
		DEVICE_READY_TIMEOUT = config.aap().getProperty("device.ready.timeout");
	}

	public static UiAutomator2Options mobileBroserOptions() {
		options.setDeviceName(AndroidDrivers.DEVICE_NAME);
		options.setChromedriverExecutable(AndroidDrivers.CHROME_DRIVER_PATH);
		options.setCapability("browserName", AndroidDrivers.BROWSER_NAME);
		options.setPlatformName(AndroidDrivers.PLATFORM_NAME);
		options.setPlatformVersion(AndroidDrivers.PLATFORM_VERSION);
		options.setAutomationName(AndroidDrivers.AUTOMATION_INSTRUMENTATION);
		return options;
	}

	public static DesiredCapabilities setCapabilities() {
		capabilities.setCapability("automationName", AndroidDrivers.AUTOMATION_INSTRUMENTATION);
		capabilities.setCapability("platformName", AndroidDrivers.PLATFORM_NAME);
		capabilities.setCapability("platformVersion", AndroidDrivers.PLATFORM_VERSION);
		capabilities.setCapability("deviceName", AndroidDrivers.DEVICE_NAME);
		capabilities.setCapability("app", AndroidDrivers.APPLICATION_PATH);
		capabilities.setCapability("newCommandTimeout", AndroidDrivers.NEW_COMMAND_TIMEOUT);
		capabilities.setCapability("deviceReadyTimeout", AndroidDrivers.DEVICE_READY_TIMEOUT);
		capabilities.setCapability("appActivity", AndroidDrivers.APP_ACTIVITY);
		capabilities.setCapability("appPackage", AndroidDrivers.BASE_PKG);
		return capabilities;
	}
 
	public static UiAutomator2Options setAndroidUiAutomator2AndOptions() {
		options.setDeviceName(AndroidDrivers.DEVICE_NAME);
		options.setApp(AndroidDrivers.APPLICATION_PATH);
		options.setPlatformName(AndroidDrivers.PLATFORM_NAME);
		options.setPlatformVersion(AndroidDrivers.PLATFORM_VERSION);
		options.setAutomationName(AndroidDrivers.AUTOMATION_INSTRUMENTATION);
		options.setAppActivity(AndroidDrivers.APP_ACTIVITY);
		options.setAppPackage(AndroidDrivers.BASE_PKG);
		options.setChromedriverExecutable(AndroidDrivers.CHROME_DRIVER_PATH);  
		return options;
	}

	public AndroidDriver getDriver() throws Exception {
		appiumServer.startServer();
		driver = new AndroidDriver(new URL(config.prop().getProperty("URL")),setAndroidUiAutomator2AndOptions());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@AfterMethod(alwaysRun = true)
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
		appiumServer.stopServer();
	}  

}
