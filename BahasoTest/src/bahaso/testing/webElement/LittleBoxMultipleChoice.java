package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LittleBoxMultipleChoice extends ExcercisePage{
	public WebElement boxAnswer = null;
	public LittleBoxMultipleChoice(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getBoxAnswer(int i,int j) {
		boxAnswer = driver.findElement(By.xpath("//label[@for='choice"+i+j+"']"));
		return boxAnswer;
	}
	
	//operation
	public void answerRight(ArrayList<ArrayList<String>> choices, String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		for(int i=0;i<choices.size();i++){
			for(int j=0;j<choices.get(i).size();j++){
				//if(answer[i].equals(getBoxAnswer(i, j).getText())){
					getBoxAnswer(i, j).click();
					Thread.sleep(3000);
				//}
			}
		}
		//getButtonCheck().click();
		Thread.sleep(3000);
	}
	
}
