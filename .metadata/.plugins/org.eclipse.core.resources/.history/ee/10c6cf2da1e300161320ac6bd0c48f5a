package bahaso.testing.webElement;

import java.util.ArrayList;
import org.openqa.selenium.interactions.Actions;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoxMatchDialog extends ExcercisePage implements answerLesson{
	public ArrayList<WebElement> draggable = new ArrayList<WebElement>();
	public ArrayList<WebElement> droppable = new ArrayList<WebElement>();
	public Actions action = null;
	
	public BoxMatchDialog(WebDriver driver){
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
		ArrayList<Document> ans = (ArrayList<Document>) data.get("sentences");
		ArrayList<String> answer = new ArrayList<String>();
		for(int i=0;i<ans.size();i++){
			ArrayList<String> ans2 = (ArrayList<String>) ans.get(i).get("answers");
			if(ans2.size()>0)answer.add((String) ans2.get(0).trim());
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
					if(answer.get(i).equals(getDraggable().get(j).getText()) && getDraggable().get(j).getAttribute("answer-id").equals("666")){
						action.dragAndDrop(getDraggable().get(j), getDroppable().get(i)).perform();
						//action.clickAndHold(getDraggable().get(j)).moveToElement(getDroppable().get(i)).release().build().perform();
						Thread.sleep(2000);
						break;
					}
				}
			}
			getButtonCheck().click();
			Thread.sleep(3000);
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
			ArrayList<String> answer= (ArrayList<String>) ans;
			int wrong = 1;
			for(int i=0;i<getDroppable().size();i++){
				for(int j=0;j<getDraggable().size();j++){
					if(wrong>0){
						if(answer.get(i).equals(getDraggable().get(j).getText())==false && getDraggable().get(i).getAttribute("answer-id").equals("666")){
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
