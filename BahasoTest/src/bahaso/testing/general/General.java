package bahaso.testing.general;

import org.bson.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class General {
	public MongoClient mongoClient = null;
	public MongoDatabase db = null;
	public MongoCollection<Document> table = null;
	public BasicDBObject searchQuery = null;
	public static WebDriver driver;
	public String baseUrl = "http://localhost";
	//public String baseUrl = "https://dc33c8b0a252f4219c9698652d4e4708.bahaso.com/";
	//public String baseUrl = "https://procopy.bahaso.com/";
	
	public WebDriver getDriver(){
		mongoClient = new MongoClient("localhost", 27017);
		db = mongoClient.getDatabase("bahaso");
		
		System.setProperty("webdriver.gecko.driver", "E:\\testing\\driver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "E:\\testing\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://procopy.bahaso.com");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		return driver;
	}
}
