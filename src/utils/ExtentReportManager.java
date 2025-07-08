package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {

    private static ExtentReports reports;

    public static ExtentReports getReportInstance() {
        if (reports == null) {
        	
        	reports = new ExtentReports();
        	String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			String date = simpleDateFormat.format(new Date());
			//System.out.println(date);
			date=date.replace(":", "-");
			System.out.println(date);
			String reportsFolderPath=System.getProperty("user.dir")+"\\reports";
			File reportsFile=new File(reportsFolderPath+"\\"+date+".html");
			
			ExtentSparkReporter reporter=new ExtentSparkReporter(reportsFile);
			
			reporter.config().setDocumentTitle("QA Regression Results");
			
			reporter.config().setReportName("Regression Reports");
			
			reports.attachReporter(reporter);
			
		}
		
		return reports;
		
    }
}