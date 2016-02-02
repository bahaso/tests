package mz.page.android;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import mz.page.android.feature.ConfirmationCode;
import mz.page.android.feature.NavigationView;
import mz.page.general.ContainerPage;

public class LessonPage{
	AndroidApplication mobileApplication = AndroidApplication.getInstance();
	public void ClickImageLesson(String lessonName)
	{
		String androidXPath = "//android.widget.TextView[@text=\""+lessonName+"\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
		mobileApplication.getDriver().findElementByXPath(androidXPath);
	}
	
	public boolean ClickLeftArrow()
	{
		String androidXPath = "//android.widget.ImageView[@resource-id=\"com.bahaso:id/iv_next_lesson\"]";
		WebElement element = mobileApplication.getDriver().findElementByXPath(androidXPath);
		if(element != null)element.click();
		else return false;
		return true;
	}
	
	public boolean ClickRightArrow()
	{
		String androidXPath = "//android.widget.ImageView[@resource-id=\"com.bahaso:id/iv_prev_lesson\"]";
		WebElement element = mobileApplication.getDriver().findElementByXPath(androidXPath);
		if(element != null)element.click();
		else return false;
		return true;
	}
	
	public String GetTextCurrentLevel()
	{
		String androidResourceId = "com.bahaso:id/tv_ribbon_title";
		WebElement element = mobileApplication.getDriver().findElementById(androidResourceId);
		if(element != null)return element.getText();
		return null;
	}
	
}
