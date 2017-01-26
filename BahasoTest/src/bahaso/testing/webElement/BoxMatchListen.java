package bahaso.testing.webElement;

import java.util.ArrayList;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BoxMatchListen extends ExcercisePage implements answerLesson{
	public ArrayList<WebElement> draggable = new ArrayList<WebElement>();
	public ArrayList<WebElement> droppable = new ArrayList<WebElement>();
	public Actions action = null;
	
	public BoxMatchListen(WebDriver driver){
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
	
	@Override
	public Object getAnswerData(Document data) {
		ArrayList<Document> ans = (ArrayList<Document>) data.get("questions");
		ArrayList<String> answer = new ArrayList<String>();
		for(int i=0;i<ans.size();i++){
			answer.add((String) ans.get(i).get("answer"));
		}
		return answer;
	}
	
	//operation
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			ArrayList<String> answer= (ArrayList<String>) ans;
			for(int i=0;i<answer.size();i++){
				for(int j=0;j<getDraggable().size();j++){
					if(answer.get(i).trim().equals(getDraggable().get(j).getText()) && getDraggable().get(j).getAttribute("answer-id").equals("666")){
						action.dragAndDrop(getDraggable().get(j), getDroppable().get(i)).perform();
						//action.clickAndHold(getDraggable().get(j)).moveToElement(getDroppable().get(i)).release().build().perform();
						Thread.sleep(2000);
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
	public void answerWrong(Object ans){
		try {
			Thread.sleep(3000);
			int wrong = 1;
			ArrayList<String> answer= (ArrayList<String>) ans;
			for(int i=0;i<getDroppable().size();i++){
				for(int j=0;j<getDraggable().size();j++){
					if(wrong>0){
						if(answer.get(i).trim().equals(getDraggable().get(j).getText())==false && getDraggable().get(i).getAttribute("answer-id").equals("666")){
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
