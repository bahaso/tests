package bahaso.testing.androidElement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class LostWordType extends ExercisePage{
	
	public LostWordType(AndroidDriver driver){
		this.driver = driver;
	}
	
	public void scroll(){
		ArrayList<WebElement> layouts = this.getLayout();
			
		WebElement firstElement = layouts.get(0);
		WebElement lastElement = layouts.get(layouts.size()-1);
		
		int xFrom = lastElement.getLocation().getX()+ lastElement.getSize().getWidth()/2;
		int yFrom = lastElement.getLocation().getY()+ lastElement.getSize().getHeight()/2;
		
		int xTo = firstElement.getLocation().getX() + firstElement.getSize().getWidth()/2;
		int yTo = firstElement.getLocation().getY() + firstElement.getSize().getHeight()/2;
		driver.swipe(xFrom, yFrom, xTo, yTo, 2000);
	}
	
	public ArrayList<WebElement> getLayout(){
		return (ArrayList<WebElement>) driver.findElementsById("com.bahaso:id/layoutCaseLostWordTypeItem");
	}
	
	public ArrayList<WebElement> getAnswerBoxes(){
		return (ArrayList<WebElement>) driver.findElementsByClassName("android.widget.EditText");
	}
	
	public void answerRight(ArrayList<String> answers){
		int n=0;
		this.scrollTo("23");
		ArrayList<WebElement> answerBoxes = this.getAnswerBoxes();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
			while(n<answers.size()){
				for(int i=0;i<answerBoxes.size();i++){
					if(answerBoxes.get(i).getText().equals("")){
						answerBoxes.get(i).sendKeys(answers.get(n));
						try {
							driver.hideKeyboard();
				        }catch(Exception e) {
				                
				        }
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						n++;
					}
				}
				if(n<answers.size()){
					this.scroll();
					answerBoxes = this.getAnswerBoxes();
				}
			}
			Thread.sleep(3000);
			this.getBtnCheck().click();
			Thread.sleep(3000);
			Assert.assertEquals(this.getLessonStatus().getText(), "Benar", "Hasil seharusnya Benar");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void answerWrong(ArrayList<String> answers){
		int n=0;
		this.scrollTo("23");
		ArrayList<WebElement> answerBoxes = this.getAnswerBoxes();
		try{
			while(n<answers.size()){
				for(int i=0;i<answerBoxes.size();i++){
					answerBoxes.get(i).click();
					if(answerBoxes.get(i).getText().equals("")){
						answerBoxes.get(i).clear();
						answerBoxes.get(i).sendKeys("aaaa");
						driver.hideKeyboard();
						n++;
					}
				}
				if(n<answers.size()){
					this.scroll();
					answerBoxes = this.getAnswerBoxes();
				}
			}
			Thread.sleep(3000);
			this.getBtnCheck().click();
			Thread.sleep(3000);
			Assert.assertEquals(this.getLessonStatus().getText(), "Salah", "Hasil seharusnya Salah");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}