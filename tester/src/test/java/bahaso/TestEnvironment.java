package bahaso;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class TestEnvironment {
  
	@BeforeSuite
  	public void RunAppiumServer() throws IOException, InterruptedException
	{
		String path = "src\\startappium.bat";
		Runtime.getRuntime().exec("cmd /c start "+path);
		Thread.sleep(20000L);
	}
	
	private void RegisterDriver()
	{
		
	}

	@AfterSuite
	public void KillAppiumServer() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");	  
	}

}
