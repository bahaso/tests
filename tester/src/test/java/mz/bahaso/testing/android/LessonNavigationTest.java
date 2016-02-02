package mz.bahaso.testing.android;

import org.testng.Assert;
import org.testng.annotations.Test;

import mz.driver.MZAndroidDriver;
import mz.page.android.LessonPage;

public class LessonNavigationTest {

	LessonPage lessonPage = new LessonPage();
	
	/*@Test(groups={"initialmove"})
	private void enteringLesson()
	{
		lessonPage.ClickImageLesson("What's this? 0 0");
	}*/
	
	@Test
	private void moveToLeft()
	{
		do{
			if(lessonPage.GetTextCurrentLevel().equals("A1"))
				Assert.assertFalse(lessonPage.ClickLeftArrow());
			else
				Assert.assertTrue(lessonPage.ClickLeftArrow());
		}while(!lessonPage.GetTextCurrentLevel().equals("A1"));
	}
	
	@Test
	private void moveToRight()
	{
		do{
			if(lessonPage.GetTextCurrentLevel().equals("B2"))
				Assert.assertFalse(lessonPage.ClickRightArrow());
			else
				Assert.assertTrue(lessonPage.ClickRightArrow());
		}while(!lessonPage.GetTextCurrentLevel().equals("B2"));
	}
	
}