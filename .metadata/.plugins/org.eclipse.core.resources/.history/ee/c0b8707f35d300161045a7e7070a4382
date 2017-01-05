package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BoxMatchPicture extends ExcercisePage{
	public ArrayList<WebElement> draggable = new ArrayList<WebElement>();
	public ArrayList<WebElement> droppable = new ArrayList<WebElement>();
	public Actions action = null;
	
	public BoxMatchPicture(WebDriver driver){
		this.driver = driver;
		this.action = new Actions(driver);
	}
	
	public ArrayList<WebElement> getDraggable(){
		if(draggable.size()==0)draggable = (ArrayList<WebElement>) driver.findElements(By.className("tile-question"));
		return draggable;
	}
	
	public ArrayList<WebElement> getDroppable(){
		if(droppable.size()==0)droppable = (ArrayList<WebElement>) driver.findElements(By.className("droppable"));
		return droppable;
	}
	
	//operation
	public void answerRight(String[] answer) throws InterruptedException{
		Thread.sleep(3000);
		for(int i=0;i<answer.length;i++){
			for(int j=0;j<getDraggable().size();j++){
				if(answer[i].equals(getDraggable().get(j).getText()) && getDraggable().get(j).getAttribute("answer-id").equals("666")){
					action.dragAndDrop(getDraggable().get(j), getDroppable().get(i)).perform();
					//action.clickAndHold(getDraggable().get(j)).moveToElement(getDroppable().get(i)).release().build().perform();
					Thread.sleep(2000);
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
			int wrong = 1;
			for(int i=0;i<getDroppable().size();i++){
				for(int j=0;j<getDraggable().size();j++){
					if(wrong>0){
						if(answer[i].equals(getDraggable().get(j).getText())==false && getDraggable().get(i).getAttribute("answer-id").equals("666")){
							action.dragAndDrop(getDraggable().get(j), getDroppable().get(i)).perform();
							//action.clickAndHold(getDraggable().get(j)).moveToElement(getDroppable().get(i)).release().build().perform();
							wrong = 0;
							Thread.sleep(2000);
							break;
						}
					}else{
						if(getDraggable().get(j).getAttribute("answer-id").equals("666")){
							action.dragAndDrop(getDraggable().get(j), getDroppable().get(i)).perform();
							//action.clickAndHold(getDraggable().get(j)).moveToElement(getDroppable().get(i)).release().build().perform();
							Thread.sleep(2000);
							break;
						}
					}
				}
			}
			getButtonCheck().click();
			Thread.sleep(3000);
		}
}
