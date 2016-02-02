package mz.page.android;

public class SubLessonPage{
	
	AndroidApplication mobileApplication = AndroidApplication.getInstance();
	
	public void ClickImageSubLesson(String subLessonName)
	{
		String androidXPath = "//android.widget.TextView[@text=\""+subLessonName+"\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
		mobileApplication.getDriver().findElementByXPath(androidXPath);
	}

}
