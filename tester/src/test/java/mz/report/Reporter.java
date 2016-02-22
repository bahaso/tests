package mz.report;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import mz.general.Registry;

public class Reporter extends TestListenerAdapter implements IReporter{

	Registry reg = Registry.getInstance();
	ReportTable reportTable = (ReportTable)reg.registry("report");
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		for(ISuite suite : suites)
		{
			
			String suiteName = suite.getName();
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for(ISuiteResult sr : suiteResults.values())
			{
				String getPropertyFileName = sr.getPropertyFileName();
				ITestContext tc = sr.getTestContext();
				ITestNGMethod methods [] = tc.getAllTestMethods();
				for(ITestNGMethod method : methods)
				{
					
				}
			}
		}
	}
	
	@Override
	public void onTestFailure(ITestResult tr)
	{
		reportTable.addRow(tr.getTestClass(),tr.getMethod(),0,1,0);
	}
	
	@Override
	public void onTestSuccess(ITestResult tr)
	{
		reportTable.addRow(tr.getTestClass(),tr.getMethod(),1,0,0);
	}
	
	@Override
	public void onTestSkipped(ITestResult tr)
	{
		reportTable.addRow(tr.getTestClass(),tr.getMethod(),0,0,1);
	}

}
