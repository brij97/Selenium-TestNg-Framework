package example.example.report;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import example.example.context.Constants;

import static example.example.util.ReportUtil.test;

/**
 * The Class handles the report activities.
 *
 * @autor Bharathish
 */
public class ExtentReportManager {

	/**
	 * The extent reports.
	 */
	private static ExtentReports extentReports;

	/**
	 * The map.
	 */
	private static Map<Long, ExtentTest> map = new HashMap<>();

	/**
	 * Gets the extent reports.
	 *
	 * @return the extent reports
	 */
	public static ExtentReports getExtentReports() {
		if (extentReports == null) {
			// Configure the HTML Reporter
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(Constants.REPORT_DIRECTORY);
			htmlReporter.config().setDocumentTitle("Automation Test Report");
			htmlReporter.config().setReportName(Constants.PROJECT_NAME);
			htmlReporter.config().setTheme(Theme.STANDARD);

			// Initialize ExtentReports and attach the HtmlReporter
			extentReports = new ExtentReports();
			extentReports.attachReporter(htmlReporter);
		}
		return extentReports;
	}

	/**
	 * Start test.
	 *
	 * @param testName the test name
	 * @param desc     the description
	 */
	public synchronized static void startTest(String testName, String desc) {
		ExtentTest test = getExtentReports().createTest(testName, desc);
		map.put(Thread.currentThread().getId(), test);
	}

	/**
	 * Gets the current test.
	 *
	 * @return the current test
	 */
	public synchronized static ExtentTest getCurrentTest() {
	//	return map.get(Thread.currentThread().getId());
		ExtentTest test = map.get(Thread.currentThread().getId());
		if (test == null) {
			System.err.println("No test found for thread: " + Thread.currentThread().getId());
		}
		return test;
	}

	/**
	 * End current test.
	 */
	public synchronized static void endCurrentTest() {
		getExtentReports().flush();
	}
}
