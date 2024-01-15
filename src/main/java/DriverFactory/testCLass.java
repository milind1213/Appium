package DriverFactory;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import CommonUtils.CommonAndroid;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class testCLass {
    public AndroidDriver driver;

    public void runtest() throws Exception {
        CommonAndroid commonAndroid = new CommonAndroid();
        UiAutomator2Options options = CommonAndroid.setAndroidUiAutomator2AndOptions();
       // driver = commonAndroid.getDriver(options);
       
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
    }
}
