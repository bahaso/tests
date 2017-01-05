package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import bahaso.testing.web.answerLesson;

public class BoxMatchDissappear extends ExcercisePage implements answerLesson{
	public ArrayList<WebElement> draggable = new ArrayList<WebElement>();
	public ArrayList<WebElement> droppable = new ArrayList<WebElement>();
	public Actions action = null;
	
	public BoxMatchDissappear(WebDriver driver){
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
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			String[][] answer = (String[][])ans;
			for(int i=0;i<getDroppable().size();i++){
				for(int j=0;j<answer[i].length;j++){
					for(int k=0;k<getDraggable().size();k++){
						if(answer[i][j].equals(getDraggable().get(k).getText())){
							action.dragAndDrop(getDraggable().get(k), getDroppable().get(i)).perform();
							//action.clickAndHold(getDraggable().get(j)).moveToElement(getDroppable().get(i)).release().build().perform();
							Thread.sleep(2000);
							break;
						}
					}
				}
			}
			getButtonCheck().click();
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}
	}
	
	//operation
	public void answerWrong(Object ans){
		try {
			Thread.sleep(3000);
			String[][] answer = (String[][]) ans;
			int size = getDroppable().size();
			for(int i=0;i<size;i++){
				for(int j=0;j<answer[i].length;j++){
					for(int k=0;k<getDraggable().size();k++){
						int move = i+(size-(size-1));
						if(move==size)move = move - size;
						if(answer[i][j].equals(getDraggable().get(k).getText())){
							action.dragAndDrop(getDraggable().get(k), getDroppable().get(move)).perform();
							//action.clickAndHold(getDraggable().get(j)).moveToElement(getDroppable().get(i)).release().build().perform();
							Thread.sleep(2000);
							break;
						}
					}
				}
			}
			getButtonCheck().click();
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}
	}
}
