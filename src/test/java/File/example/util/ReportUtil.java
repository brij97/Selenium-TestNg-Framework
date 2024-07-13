package File.example.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import File.example.context.WebDriverContext;
import File.example.report.ExtentReportManager;

/**
 * The Class is responsible for Reporting
 *
 * @autor Brijesh
 */
public class ReportUtil {

	public static ExtentTest test;
	/**
	 * Adds the screen shot.
	 *
	 * @param message the message
	 */
	public static void addScreenShot(String message) {
		if (WebDriverContext.getDriver() instanceof TakesScreenshot) {
			String base64Image = "data:image/png;base64,"
					+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
			ExtentTest test = ExtentReportManager.getCurrentTest();
			test.log(Status.INFO, message, test.addScreenCaptureFromBase64String(base64Image).getModel().getMedia().get(0));
		} else {
			throw new UnsupportedOperationException("The driver does not support taking screenshots.");
		}
	}

	/**
	 * Adds the screen shot.
	 *
	 * @param status  the status
	 * @param message the message
	 */
	public static void addScreenShot(Status status, String message) {
		if (WebDriverContext.getDriver() instanceof TakesScreenshot) {
			String base64Image = "data:image/png;base64,"
					+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
			ExtentTest test = ExtentReportManager.getCurrentTest();
			test.log(status, message, test.addScreenCaptureFromBase64String(base64Image).getModel().getMedia().get(0));
		} else {
			throw new UnsupportedOperationException("The driver does not support taking screenshots.");
		}
	}

	public static void logMessage(String message, String details) {
		ExtentTest test = ExtentReportManager.getCurrentTest();
		test.log(Status.INFO, message + ": " + details);
	}

	public static void logMessage(Status status, String message, String details) {
		ExtentTest test = ExtentReportManager.getCurrentTest();
		test.log(status, message + ": " + details);
	}

//	public static void logMessage(String message, String details) {
//		ExtentReportManager.getCurrentTest().log(Status.INFO, message, details);
//	}
//
//	public static void logMessage(Status status, String message, String details) {
//		ExtentReportManager.getCurrentTest().log(status, message, details);
//	}
}
