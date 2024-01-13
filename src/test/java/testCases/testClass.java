package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import TestComponent.BaseTest;
import io.appium.java_client.AppiumBy;

public class testClass extends BaseTest {

	@Test
	public void runTest() {
		    driver.findElement(AppiumBy.accessibilityId("Preference")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
			driver.findElement(By.id("android:id/checkbox")).click();
			driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); 
			String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
			AssertJUnit.assertEquals(alertTitle, "WiFi settings");	
			driver.findElement(By.id("android:id/edit")).sendKeys("Wifi");
			driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}

}
