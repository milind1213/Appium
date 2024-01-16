package TestComponent;

import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;
import DriverUtility.AndroidDrivers;
import Pages.ApiDemosPreferencePage;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;

public class NewBaseTest extends AndroidDrivers {
	public ApiDemosPreferencePage user;

	@Test(priority = 1)
	public void wifiCoonectionSetting() throws Exception {
		user = new ApiDemosPreferencePage(getDriver());
		user.clickPreference();
		user.clickpreferenceDependency();
		user.clickwifiCheckBox();
		user.wifiSettings();
		user.clickingEditField();
		user.clickButtonByIndex(1);
	}

	@Test(priority = 2)
	public void longpress() throws Exception {
		user = new ApiDemosPreferencePage(getDriver());
		user.longPress();
		user.validatelongpressResult();
	}

	@Test(priority = 3)
	public void swipePics() throws Exception {
		user = new ApiDemosPreferencePage(getDriver());
		user.performGalleryActions();
		user.validateFocusImate();
	}

	@Test(priority = 4)
	public void mislenius() throws Exception {
		user = new ApiDemosPreferencePage(getDriver());
		user.clickPreference();
		user.clickpreferenceDependency();
		user.clickwifiCheckBox();
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		user.rotateDevice(landScape);
		user.wifiSettings();
		user.clickingEditField();
		user.rotateToPortrait();
		user.pressKey(AndroidKey.ENTER);
		user.pressKey(AndroidKey.BACK);
		user.pressKey(AndroidKey.HOME);
	}

}