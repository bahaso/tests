package mz.report;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import mz.config.Configuration;

public class ExtentReporter implements IReporter 
{
	private ExtentReports extent;
	
	private String baseFolderPath;
	
	private String reportFolderFullPath;
	
	public ExtentReporter()
	{
		//Mengatur nama folder report
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		this.baseFolderPath = Configuration.REPORT_PATH + Configuration.REPORT_FOLDER_PREFIX;
		this.reportFolderFullPath = this.baseFolderPath + dateFormat.format(cal.getTime()) + File.separator; 
	}
	
	public void setCurrentFolderName(String name)
	{
		this.reportFolderFullPath = this.baseFolderPath + name;
	}
	
	public String getReportFolderFullPath()
	{
		return this.reportFolderFullPath;
	}
	
	public HashMap<String, String> systemInfoMapping()
	{
		HashMap<String, String> systemInfo = new HashMap<String, String>();
		systemInfo.put("ExtentReports Version", "2.40.1");
		systemInfo.put("Selenium Version", "2.50.1");
		systemInfo.put("Appium Version", "3.2.0");
		systemInfo.put("TestNG Version", "6.9.8");
		systemInfo.put("Environment", "Test");
		
		return systemInfo;
	}
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)
	{
		outputDirectory = this.reportFolderFullPath;
		
		extent = new ExtentReports(outputDirectory + "FunctionalTestingReport.html");
		
		extent.loadConfig(this.getClass(),"extent-config.xml");

		extent.addSystemInfo(this.systemInfoMapping());
		
		for(ISuite suite : suites)
		{
			Map<String, ISuiteResult> result = suite.getResults();
			
			for(ISuiteResult r : result.values())
			{
				ITestContext context = r.getTestContext();
				
				buildTestNodes(context.getPassedTests(), LogStatus.PASS, outputDirectory);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL,outputDirectory);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP,outputDirectory);
			}
		}
		
		extent.flush();
		extent.close();
	}
	
	private void buildTestNodes(IResultMap tests, LogStatus status, String outputDirectory)
	{
		ExtentTest test;
		
		if(tests.size() > 0)
		{
			for(ITestResult result : tests.getAllResults())
			{
				test = extent.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
				
				//Atur waktu mulai test dan akhir test
				test.setStartedTime(this.getTime(result.getStartMillis()));
				test.setEndedTime(this.getTime(result.getEndMillis()));
				
				//Atur kategory test
				test.assignCategory(result.getTestClass().getName());
				for(String group : result.getMethod().getGroups())
				{
					test.assignCategory(group);
				}
				
				this.buildLog(result, test, status);
				
				extent.endTest(test);
			}
		}
	}
	
	private void buildLog(ITestResult result, ExtentTest test, LogStatus status)
	{
		if(result.getThrowable() != null)
			test.log(status, result.getThrowable());
		else
			test.log(status, "Test " + status.toString().toLowerCase()+"ed");
		test.log(LogStatus.INFO,""+ test.addScreenCapture(Configuration.SCREENSHOT_PATH + test.getTest().getName()+".png"));
		
	}

	private Date getTime(long millis)
	{
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();        
    }
}
