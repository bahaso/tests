package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ListenSelectMultipleBox extends ExercisePage{
	
	public ListenSelectMultipleBox(AndroidDriver driver){
		this.driver = driver;
	}
	public ArrayList<WebElement> getBoxAnswer(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/textViewListenSelectMultipleBoxChoiceItem");
	}
	
	public ArrayList<WebElement> getDroppable(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/relativeLayoutCaseContainer");
	}
	
	public void answerRight(ArrayList<String> answers){
		this.scrollTo("28");
		ArrayList<WebElement> answerBoxes = this.getBoxAnswer();
		for(int j=0;j<answerBoxes.size();j++){
			if(answers.contains(answerBoxes.get(j).getText())){
				answerBoxes.get(j).click();
			}
		}
		this.getBtnCheck().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assert.assertEquals(this.getLessonStatus().getText(), "Benar", "Hasil seharusnya Benar");
	}
	
	public void answerWrong(ArrayList<String> answers){
		this.scrollTo("28");
		ArrayList<WebElement> answerBoxes = this.getBoxAnswer();
		for(int j=0;j<answerBoxes.size();j++){
			if(answers.contains(answerBoxes.get(j).getText())==false){
				answerBoxes.get(j).click();
			}
		}
		this.getBtnCheck().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assert.assertEquals(this.getLessonStatus().getText(), "Salah", "Hasil seharusnya Salah");
	}
}
