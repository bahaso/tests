package mz.page.android;

import mz.page.general.AbstractAndroid;

public class SubLessonPage extends AbstractAndroid {
	
	//This property is used to store the xpath of Image Sub Lesson.
	//<lessonName> needs to be replaced by the real Sub Lesson Name.
	//Use method getSpecificImageSubLesson(String subLessonName) to get the specific Image Sub Lesson.
	private final String dynamicImageSubLesson = "//android.widget.TextView[@text=\"<subLessonName>\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
	
	private String getSpecificImageSubLesson(String subLessonName)
	{
		return dynamicImageSubLesson.replace("<subLessonName>", subLessonName);
	}
	
	public void ClickImageSubLesson(String subLessonName)
	{
		mobileApplication.getDriver().findElementByXPath(getSpecificImageSubLesson(subLessonName));
	}

}
