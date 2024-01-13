package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;

	public static ExtentReports getReporterObject() {
		String path = System.getProperty("user.dir") + "//reports//Extent-Report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("UserName", "Milind G");
		extent.setSystemInfo("OS", "Ubuntu/Linux");
		extent.setSystemInfo("Os Vesrion", "22.04");
		extent.setSystemInfo("Java Version", "11.0.20");
		extent.setSystemInfo("Time", "Asia/Calcuta");
		extent.setSystemInfo("User Language", "English");
		extent.setSystemInfo("Admin", "Milind G");
		return extent;

	}
}
