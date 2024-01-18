package TestCases;

import org.testng.annotations.Test;

import DriverUtility.AndroidDriverUtils;
import Pages.ResidentHomePage;

public class ResidentApplaunch extends AndroidDriverUtils {
	public ResidentHomePage user;

	@Test
	public void launchAPplication() throws Exception {
		user = new ResidentHomePage(getDriver());
		user.userLogin(EMAIL,PASSWORD);
	}
}
