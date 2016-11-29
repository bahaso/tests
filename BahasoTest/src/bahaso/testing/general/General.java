package bahaso.testing.general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class General {
	public static WebDriver driver;
	public String baseUrl = "http://localhost";
	//public String baseUrl = "https://dc33c8b0a252f4219c9698652d4e4708.bahaso.com/";
	
	public WebDriver getDriver(){
		System.setProperty("webdriver.gecko.driver", "E:\\testing\\driver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\testing\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://procopy.bahaso.com");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		return driver;
	}
}