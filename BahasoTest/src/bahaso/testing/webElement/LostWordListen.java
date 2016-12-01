package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LostWordListen extends ExcercisePage{
	public WebElement audioButton = null;
	public ArrayList<WebElement> boxAnswer = new ArrayList<WebElement>();
	public ArrayList<WebElement> boxAnswer2 = new ArrayList<WebElement>();
	
	public LostWordListen(WebDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		boxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath(".//*[@id='lesson-content']/div/div[2]/div/div/span[2]/span/input"));
		return boxAnswer;
	}
}
