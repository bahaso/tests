package bahaso.testing.webElement;

import java.util.ArrayList;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ListenAndOrganize extends ExcercisePage implements answerLesson{
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
	
	@Override
	public Object getAnswerData(Document data) {
		ArrayList<Document> answer = (ArrayList<Document>) data.get("sentences");
		return answer;
	}
	
	//operation
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			ArrayList<String> answer = (ArrayList<String>) ans;
			for(int i=0;i<answer.size();i++){
				for(int j=0;j<getDraggable().size();j++){
					if(answer.get(i).trim().equals(getDraggable().get(j).getText())){
						//action.dragAndDrop(getDraggable().get(j), getDroppable().get(i)).perform();
						action.clickAndHold(getDraggable().get(j)).moveToElement(getDraggable().get(i),225,0).build().perform();
						Thread.sleep(3000);
						action.release().build().perform();
						Thread.sleep(3000);
						break;
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//operation
	@Override
	public void answerWrong(Object ans){
		try {
			Thread.sleep(3000);
			ArrayList<String> answer = (ArrayList<String>) ans;
			if(answer.get(0).trim().equals(getDraggable().get(0).getText())){
				//action.dragAndDrop(getDraggable().get(j), getDroppable().get(i)).perform();
				action.clickAndHold(getDraggable().get(0)).moveToElement(getDraggable().get(1),225,0);
				Thread.sleep(2000);
				action.release().build().perform();
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
