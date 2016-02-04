package mz.page.android;

import org.openqa.selenium.WebElement;

import mz.page.general.AbstractAndroid;

public class LessonPage extends AbstractAndroid {
	
	private String imgLeftArrow = "//android.widget.ImageView[@resource-id=\"com.bahaso:id/iv_next_lesson\"]";
	
	private String imgRightArrow = "//android.widget.ImageView[@resource-id=\"com.bahaso:id/iv_prev_lesson\"]";
	
	private String lblLevelName = "com.bahaso:id/tv_ribbon_title";
	
	//This property is used to store the xpath of Image Lesson.
	//<lessonName> needs to be replaced by the real Lesson Name. 
	//Use method getSpecificImageLesson(String lessonName) to get the specific Image Lesson.
	private String dynamicImageLesson = "//android.widget.TextView[@text=\"<lessonName>\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
	
	private String getSpecificImageLesson(String lessonName)
	{
		return dynamicImageLesson.replace("<lessonName>", lessonName);
	}
	
	public void ClickImageLesson(String lessonName)
	{
		mobileApplication.getDriver().findElementByXPath(getSpecificImageLesson(lessonName));
	}
	
	public boolean ClickLeftArrow()
	{
		WebElement element = mobileApplication.getDriver().findElementByXPath(imgLeftArrow);
		if(element != null)element.click();
		else return false;
		return true;
	}
	
	public boolean ClickRightArrow()
	{
		WebElement element = mobileApplication.getDriver().findElementByXPath(imgRightArrow);
		if(element != null)element.click();
		else return false;
		return true;
	}
	
	public String GetTextCurrentLevel()
	{
		WebElement element = mobileApplication.getDriver().findElementById(lblLevelName);
		if(element != null)return element.getText();
		return null;
	}
	
}
