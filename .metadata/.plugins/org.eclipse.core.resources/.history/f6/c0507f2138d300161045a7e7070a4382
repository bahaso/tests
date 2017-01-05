package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ListenAndOrganize extends ExcercisePage{
	public ArrayList<WebElement> draggable = new ArrayList<WebElement>();
	public ArrayList<WebElement> droppable = new ArrayList<WebElement>();
	public Actions action = null;
	
	public ListenAndOrganize(WebDriver driver){
		this.driver = driver;
		this.action = new Actions(driver);
	}
	
	public ArrayList<WebElement> getDraggable(){
		draggable = (ArrayList<WebElement>) driver.findElements(By.className("tile-question"));
		return draggable;
	}
	
	public ArrayList<WebElement> getDroppable(){
		droppable = (ArrayList<WebElement>) driver.findElements(By.className("droppable"));
		return droppable;
	}
	
	//operation
	public void answerRight(String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		for(int i=0;i<answer.length;i++){
			for(int j=0;j<getDraggable().size();j++){
				if(answer[i].equals(getDraggable().get(j).getText())){
					//action.dragAndDrop(getDraggable().get(j), getDroppable().get(i)).perform();
					action.clickAndHold(getDraggable().get(j)).moveToElement(getDraggable().get(i),225,0).build().perform();
					Thread.sleep(3000);
					action.release().build().perform();
					Thread.sleep(3000);
					break;
				}
			}
		}
		getButtonCheck().click();
		Thread.sleep(3000);
	}
	
	//operation
		public void answerWrong(String[] answer) throws InterruptedException{
			Thread.sleep(3000);
			if(answer[0].equals(getDraggable().get(0).getText())){
				//action.dragAndDrop(getDraggable().get(j), getDroppable().get(i)).perform();
				action.clickAndHold(getDraggable().get(0)).moveToElement(getDraggable().get(1),225,0);
				Thread.sleep(2000);
				action.release().build().perform();
				Thread.sleep(2000);
			}
			getButtonCheck().click();
			Thread.sleep(3000);
		}
}
