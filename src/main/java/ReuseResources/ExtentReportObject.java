package ReuseResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportObject {

	static ExtentReports extent;
	public static ExtentReports getExtentReportObject()
	{
		String reportpath=System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportpath);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Automation Reports");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
}
