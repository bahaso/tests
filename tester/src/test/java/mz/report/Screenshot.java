package mz.report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import mz.config.Configuration;
import mz.page.general.WebApplication;

public class Screenshot {
	
	
	
	public static void saveFile(ITestResult tr, String directory)
	{
		String filename = directory + Configuration.SCREENSHOT_PATH +  tr.getName() + ".png";
		File sourceFile = ((TakesScreenshot)WebApplication.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		
		moveFilesToDirectory(sourceFile, filename);
	}
	
	private static void moveFilesToDirectory(File sourceFile, String directory)
	{
		try 
		{
			FileUtils.copyFile(sourceFile, new File(directory));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}