package bahaso.testing.androidElement;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class TrueFalsePicture extends ExercisePage{
	
	public TrueFalsePicture(AndroidDriver driver){
		this.driver = driver;
	}
	public ArrayList<WebElement> getBoxAnswer(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/linearLayoutClick");
	}
	
	public void answerRight(Boolean answer){
		this.scrollTo("11");
		ArrayList<WebElement> answerBoxes = this.getBoxAnswer();
		if(answer){
			answerBoxes.get(0).click();
		}else{
			answerBoxes.get(1).click();
		}
		this.getBtnCheck().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void answerWrong(Boolean answer){
		this.scrollTo("11");
		ArrayList<WebElement> answerBoxes = this.getBoxAnswer();
		if(answer){
			answerBoxes.get(1).click();
		}else{
			answerBoxes.get(0).click();
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
