package recursos;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReporteNG {
	
	static ExtentReports extent;
	public static ExtentReports getReport() {
		// TODO Auto-generated method stub
		// ExtentReports , ExtentSparkReporter

		String path =System.getProperty("user.dir")+"\\report\\indexTrello.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent =new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Alejandro Castro");
		
		return extent;

	}

}
