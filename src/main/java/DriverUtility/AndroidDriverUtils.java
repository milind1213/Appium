package DriverUtility;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import CommonUtility.AppiumServer;
import Utils.ConfigPropReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class AndroidDriverUtils {
	public static String EMAIL;
	public static String PASSWORD;
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
	public static Logger log;

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
		EMAIL = config.aap().getProperty("user.email");
		PASSWORD = config.aap().getProperty("user.password");

	}

	public static UiAutomator2Options mobileBroserOptions() {
		options.setDeviceName(AndroidDriverUtils.DEVICE_NAME);
		options.setChromedriverExecutable(AndroidDriverUtils.CHROME_DRIVER_PATH);
		options.setCapability("browserName", AndroidDriverUtils.BROWSER_NAME);
		options.setPlatformName(AndroidDriverUtils.PLATFORM_NAME);
		options.setPlatformVersion(AndroidDriverUtils.PLATFORM_VERSION);
		options.setAutomationName(AndroidDriverUtils.AUTOMATION_INSTRUMENTATION);
		return options;
	}

	public static DesiredCapabilities setCapabilities() {
		capabilities.setCapability("automationName", AndroidDriverUtils.AUTOMATION_INSTRUMENTATION);
		capabilities.setCapability("platformName", AndroidDriverUtils.PLATFORM_NAME);
		capabilities.setCapability("platformVersion", AndroidDriverUtils.PLATFORM_VERSION);
		capabilities.setCapability("deviceName", AndroidDriverUtils.DEVICE_NAME);
		capabilities.setCapability("app", AndroidDriverUtils.APPLICATION_PATH);
		capabilities.setCapability("newCommandTimeout", AndroidDriverUtils.NEW_COMMAND_TIMEOUT);
		capabilities.setCapability("deviceReadyTimeout", AndroidDriverUtils.DEVICE_READY_TIMEOUT);
		capabilities.setCapability("appActivity", AndroidDriverUtils.APP_ACTIVITY);
		capabilities.setCapability("appPackage", AndroidDriverUtils.BASE_PKG);
		return capabilities;
	}

	public static UiAutomator2Options setAndroidUiAutomator2AndOptions() {
		options.setDeviceName(AndroidDriverUtils.DEVICE_NAME);
		options.setApp(AndroidDriverUtils.APPLICATION_PATH);
		options.setPlatformName(AndroidDriverUtils.PLATFORM_NAME);
		options.setPlatformVersion(AndroidDriverUtils.PLATFORM_VERSION);
		options.setAutomationName(AndroidDriverUtils.AUTOMATION_INSTRUMENTATION);
		options.setAppActivity(AndroidDriverUtils.APP_ACTIVITY);
		options.setAppPackage(AndroidDriverUtils.BASE_PKG);
		options.setChromedriverExecutable(AndroidDriverUtils.CHROME_DRIVER_PATH);
		return options;
	}

	public AndroidDriver getDriver() throws Exception {
		appiumServer.startServer();
		driver = new AndroidDriver(new URL(config.prop().getProperty("URL")), setAndroidUiAutomator2AndOptions());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@AfterMethod(alwaysRun = true)
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterClass(alwaysRun = true)
	public void quitServer() {
		appiumServer.stopServer();
	}
}