package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LostWordType extends ExcercisePage{
public ArrayList<WebElement> boxAnswer = new ArrayList<WebElement>();
	
	public LostWordType(WebDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		boxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath(".//input[@class='lesson']"));
		return boxAnswer;
	}
	
	//operation
	public void answerRight(String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		for(int i=0;i<answer.length;i++){
			getBoxAnswer().get(i).sendKeys(answer[i]);
			Thread.sleep(3000);
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}
	
	public void answerWrong(String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		for(int i=0;i<answer.length;i++){
			getBoxAnswer().get(i).sendKeys("aaa");
			Thread.sleep(3000);
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}
}
