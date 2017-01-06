package bahaso.testing.webElement;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bahaso.testing.web.answerLesson;

public class ListenSelectMultipleBox extends ExcercisePage implements answerLesson{
	public ArrayList<WebElement> choices = new ArrayList<WebElement>();
	public WebElement choice = null;
	
	public ListenSelectMultipleBox(WebDriver driver){
		this.driver = driver;
	}
	
	public ArrayList<WebElement> getChoices(){
		choices = (ArrayList<WebElement>) driver.findElements(By.xpath("//input[@class='lesson']"));
		return choices;
	}
	
	public WebElement getChoice(String kelas){
		return wt.waitForElement(driver, By.xpath("//label[@for='"+kelas+"']"));
	}
	
	//operation
	@Override
	public void answerRight(Object ans){
		try {
			Thread.sleep(3000);
			String[] answer = (String[])ans;
			for(int i=0;i<answer.length;i++){
				for(int j=0;j<getChoices().size();j++){
					if(answer[i].equals(getChoices().get(j).getAttribute("value"))){
						getChoice(getChoices().get(j).getAttribute("id")).click();
						Thread.sleep(2000);
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
	
	public void answerWrong(Object ans){
		try {
			Thread.sleep(3000);
			int wrong = 1;
			String[] answer = (String[])ans;
			for(int i=0;i<answer.length;i++){
				for(int j=0;j<getChoices().size();j++){
					if(wrong>0){
						if(!answer[i].equals(getChoices().get(j).getAttribute("value"))){
							getChoice(getChoices().get(j).getAttribute("id")).click();
							wrong = 0;
							Thread.sleep(2000);
							break;
						}
					}
					else if(answer[i].equals(getChoices().get(j).getAttribute("value"))){
						getChoice(getChoices().get(j).getAttribute("id")).click();
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
}
