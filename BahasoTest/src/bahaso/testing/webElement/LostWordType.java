package bahaso.testing.webElement;

import java.util.ArrayList;

import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LostWordType extends ExcercisePage implements answerLesson{
	public ArrayList<WebElement> boxAnswer = new ArrayList<WebElement>();
	
	public LostWordType(WebDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getBoxAnswer(){
		boxAnswer = (ArrayList<WebElement>) driver.findElements(By.xpath(".//input[@class='lesson']"));
		return boxAnswer;
	}
	
	@Override
	public Object getAnswerData(Document data) {
		ArrayList<Document> ans = (ArrayList<Document>) data.get("questions");
		ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>();
		for(int i=0;i<ans.size();i++){
			ArrayList<ArrayList<String>> ans2 = (ArrayList<ArrayList<String>>) ans.get(i).get("answer");
			if(ans2.size()>0){
				for(int j=0;j<ans2.size();j++){
					answer.add(ans2.get(j));
				}
			}
		}
		return answer;
	}
	
	//operation
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			ArrayList<ArrayList<String>> answer = (ArrayList<ArrayList<String>>) ans;
			for(int i=0;i<answer.size();i++){
				int order = (int)(Math.random() * answer.get(i).size());
				getBoxAnswer().get(i).sendKeys(answer.get(i).get(order).trim());
				Thread.sleep(3000);
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
			ArrayList<ArrayList<String>> answer = (ArrayList<ArrayList<String>>) ans;
			for(int i=0;i<answer.size();i++){
				getBoxAnswer().get(i).sendKeys("aaa");
				Thread.sleep(3000);
			}
			getButtonCheck().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
