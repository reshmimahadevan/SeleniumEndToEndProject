package endtoend.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";

		ExtentSparkReporter rep = new ExtentSparkReporter(path);

		rep.config().setReportName("Web Automation Result");

		rep.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(rep);

		extent.setSystemInfo("Tester", "Reshmi");

		return extent;

	}

}
