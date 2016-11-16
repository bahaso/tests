package bahaso.testing.general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class General {
	public static WebDriver driver;
	
	public static WebDriver getDriver(){
		System.setProperty("webdriver.gecko.driver", "E:\\testing\\driver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\testing\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://procopy.bahaso.com");
		driver.get("http://localhost");
		driver.manage().window().maximize();
		return driver;
	}
}
