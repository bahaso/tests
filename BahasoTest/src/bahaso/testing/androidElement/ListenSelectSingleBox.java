package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ListenSelectSingleBox extends ExercisePage{
	
	public ListenSelectSingleBox(AndroidDriver driver){
		this.driver = driver;
	}
	public ArrayList<WebElement> getBoxAnswer(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/textViewListenSelectSingleBoxChoiceItem");
	}
	
	public ArrayList<WebElement> getDroppable(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/relativeLayoutCaseContainer");
	}
	
	public void answerRight(ArrayList<String> answers){
		this.scrollTo("6");
		for(int i=0;i<answers.size();i++){
			ArrayList<WebElement> answerBoxes = this.getBoxAnswer();
			for(int j=0;j<answerBoxes.size();j++){
				if(answerBoxes.get(j).getText().equals(answers.get(i))){
					answerBoxes.get(j).click();
					break;
				}
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
		this.scrollTo("6");
		Boolean answerWrong = true;
		for(int i=0;i<answers.size();i++){
			ArrayList<WebElement> answerBoxes = this.getBoxAnswer();
			for(int j=0;j<answerBoxes.size();j++){
				if(answerWrong){
					if(answerBoxes.get(j).getText().equals(answers.get(i))== false){
						answerBoxes.get(j).click();
						answerWrong=false;
						break;
					}
				}else{
					answerBoxes.get(j).click();
					break;
				}
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
