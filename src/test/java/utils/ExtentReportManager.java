package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	private static ExtentReports extent;

	private ExtentReportManager() {
		// private constructor to prevent instantiation
	}

	public static ExtentReports getInstance() {
		if (extent == null) {
			// Path to save the HTML report file
			ExtentSparkReporter reporter = new ExtentSparkReporter("build/reports/extent-report.html");

			// Customize report appearance
			reporter.config().setReportName("API Test Report");
			reporter.config().setDocumentTitle("Flight Booking Automation Report");

			extent = new ExtentReports();
			extent.attachReporter(reporter);

			// Add environment/system info
			extent.setSystemInfo("Environment", System.getProperty("env", "QA"));
			extent.setSystemInfo("Tester", "Ramakrishna");
		}
		return extent;
	}
}
