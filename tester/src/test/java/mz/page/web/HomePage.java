package mz.page.web;

import org.openqa.selenium.remote.RemoteWebDriver;

import mz.page.web.feature.LearningStatus;
import mz.page.web.feature.Lessons;
import mz.page.web.feature.TopLearner;
import mz.page.web.feature.UnsupportedMobileAnnouncement;

public class HomePage extends CommonPage{
	private UnsupportedMobileAnnouncement unsupportedMobileAnnouncement;
	private Lessons lessons;
	private LearningStatus learningStatus;
	private TopLearner topLearner;
	
	public HomePage(RemoteWebDriver driver){
		super(driver);
		unsupportedMobileAnnouncement = new UnsupportedMobileAnnouncement();
	}
	
	public void ClickButtonPlacementTest(){}
}