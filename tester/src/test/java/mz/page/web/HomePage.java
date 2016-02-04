package mz.page.web;

import mz.page.web.feature.LearningStatus;
import mz.page.web.feature.Lessons;
import mz.page.web.feature.TopLearner;
import mz.page.web.feature.UnsupportedMobileAnnouncement;

public class HomePage extends CommonPage{
	
	private UnsupportedMobileAnnouncement unsupportedMobileAnnouncement = new UnsupportedMobileAnnouncement();
	
	private Lessons lessons = new Lessons();
	
	private LearningStatus learningStatus = new LearningStatus();
	
	private TopLearner topLearner = new TopLearner();
	
	public HomePage(){}
	
	public void ClickButtonPlacementTest(){}
	
}