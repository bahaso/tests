package bahaso.testing.webElement;

import java.util.ArrayList;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BoxMatchDissappearPicture extends ExcercisePage implements answerLesson{
	public ArrayList<WebElement> draggable = new ArrayList<WebElement>();
	public ArrayList<WebElement> droppable = new ArrayList<WebElement>();
	public Actions action = null;
	
	public BoxMatchDissappearPicture(WebDriver driver){
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
		ArrayList<ArrayList<Document>> answer = new ArrayList<ArrayList<Document>>();
		ArrayList<Document> ans = (ArrayList<Document>) data.get("categories");
		for(int i=0;i<ans.size();i++){
			ArrayList<Document> ans2 = (ArrayList<Document>) ans.get(i).get("texts");
			answer.add(ans2);
		}
		return answer;
	}
	
	//operation
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			ArrayList<ArrayList<String>> answer = (ArrayList<ArrayList<String>>)ans;
			for(int i=0;i<getDroppable().size();i++){
				for(int j=0;j<answer.get(i).size();j++){
					for(int k=0;k<getDraggable().size();k++){
						if(answer.get(i).get(j).trim().equals(getDraggable().get(k).getAttribute("data-val"))){
							action.dragAndDrop(getDraggable().get(k), getDroppable().get(i)).perform();
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
	
	//operation
	@Override
	public void answerWrong(Object ans){
		try {
			Thread.sleep(3000);
			ArrayList<ArrayList<String>> answer = (ArrayList<ArrayList<String>>)ans;
			int size = getDroppable().size();
			for(int i=0;i<size;i++){
				for(int j=0;j<answer.get(i).size();j++){
					for(int k=0;k<getDraggable().size();k++){
						int move = i+(size-(size-1));
						if(move==size)move = move - size;
						if(answer.get(i).get(j).trim().equals(getDraggable().get(k).getAttribute("data-val"))){
							action.dragAndDrop(getDraggable().get(k), getDroppable().get(move)).perform();
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
