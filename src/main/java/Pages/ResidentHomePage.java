package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import CommonUtility.AppiumActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ResidentHomePage extends AppiumActions {
	AndroidDriver driver;

	public ResidentHomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id = "com.app.nobrokerhood:id/btnGetStarted")
	public WebElement getStarted;
	
	@AndroidFindBy(id = "com.app.nobrokerhood:id/editTextEmailMobile")
	public WebElement userEmailID;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/editTextPassword")
	public WebElement password;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/buttonLogin")
	public WebElement loginButton;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/loginCheckbox")
	public WebElement loginWothOTP;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/textViewSignUp")
	public WebElement signUp;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/denyTextView")
	public WebElement Deny;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/imageCross")
	public WebElement closeButton;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/skipTextView")
	public WebElement skip;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/loginCheckbox")
	public WebElement loginWithOTPCheckbox;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/textViewSubmit")
	public WebElement submit;

	@AndroidFindBy(accessibility = "Home")
	public WebElement home;

	@AndroidFindBy(id = "permission_allow_button")
	public WebElement allowAudioRecordPermission;

	@AndroidFindBy(id = "com.app.nobrokerhood:id/allowTextView")
	public WebElement allowMissingNotification;
	

	@AndroidFindBy(id = "android:id/button1")
	public WebElement allowBacgroundRun;
	
	
	
	
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	public WebElement denyAudioRecordPermission;

	

	@AndroidFindBy(id = "com.app.nobrokerhood:id/denyTextView")
	public WebElement denyMissingNotification;
	
	
	@AndroidFindBy(id = "android:id/button2")
	public WebElement denyBacgroundRun;
	
	
	
	
	
	
	public void userLogin(String email, String pass) throws InterruptedException {
	    try {
	        waitForWebElementToBeClickable(getStarted, Duration.ofSeconds(3));
	        clickWithoutWait(getStarted);
	        wait(1);
	        userEmailID.sendKeys(email);
	        password.sendKeys(pass);
	        loginButton.click();
	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Failed to perform user login. Exception details: " + e.getMessage());
	    }
	}
	
	
	public void allowPermission() {
		if (isElementPresent(allowAudioRecordPermission)) {
			allowAudioRecordPermission.click();
		}
		if (isElementPresent(allowMissingNotification)) {
			allowMissingNotification.click();
		}
		if (isElementPresent(allowBacgroundRun)) {
			allowBacgroundRun.click();
		}
	}

}
