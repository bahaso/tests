package mz.page.web;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import mz.page.general.AbstractWeb;
import mz.page.web.feature.*;

import java.util.HashMap;
import java.util.Map;

public class SubLessonPage extends AbstractWeb {
	Map<String, Object> objMapping = new HashMap<String, Object>();
	//BoxMatchDissapear boxMatchDisappear = null;
	
	WebElement btnPeriksa = null;
	WebElement status = null;
	
	Integer login = 0,pop=0;

	public BoxMatchDissapear getBoxMatchDisappear() {
		String _case = "BoxMatchDissapear";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new BoxMatchDissapear());
		return (BoxMatchDissapear)objMapping.get(_case);
	}
	
	public BoxMatchDissapearPicture getBoxMatchDisappearPicture() {
		String _case = "BoxMatchDissapearPicture";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new BoxMatchDissapearPicture());
		return (BoxMatchDissapearPicture)objMapping.get(_case);
	}
	
	public BoxMatchList getBoxMatchList() {
		String _case = "BoxMatchList";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new BoxMatchList());
		return (BoxMatchList)objMapping.get(_case);
	}
	
	public BoxMatchListPicture getBoxMatchListPicture() {
		String _case = "BoxMatchListPicture";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new BoxMatchListPicture());
		return (BoxMatchListPicture)objMapping.get(_case);
	}
	
	public PictureMultipleChoice getPictureMultipleChoice() {
		String _case = "PictureMultipleChoice";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new PictureMultipleChoice());
		return (PictureMultipleChoice)objMapping.get(_case);
	}
	
	public LittleBoxMultipleChoice getLittleBoxMultipleChoice() {
		String _case = "LittleBoxMultipleChoice";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new LittleBoxMultipleChoice());
		return (LittleBoxMultipleChoice)objMapping.get(_case);
	}
	
	public LittleBoxMultipleChoicePicture getLittleBoxMultipleChoicePicture() {
		String _case = "LittleBoxMultipleChoicePicture";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new LittleBoxMultipleChoicePicture());
		return (LittleBoxMultipleChoicePicture)objMapping.get(_case);
	}
	
	public LostWordType getLostWordType() {
		String _case = "LostWordType";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new LostWordType());
		return (LostWordType)objMapping.get(_case);
	}
	
	public TrueFalseSentence getTrueFalseSentence() {
		String _case = "TrueFalseSentence";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new TrueFalseSentence());
		return (TrueFalseSentence)objMapping.get(_case);
	}
	
	public TrueFalsePicture getTrueFalsePicture() {
		String _case = "TrueFalsePicture";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new TrueFalsePicture());
		return (TrueFalsePicture)objMapping.get(_case);
	}
	
	public SentenceFormation getSentenceFormation() {
		String _case = "SentenceFormation";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new SentenceFormation());
		return (SentenceFormation)objMapping.get(_case);
	}
	
	public DragMultipleChoice getDragMultipleChoice() {
		String _case = "DragMultipleChoice";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new DragMultipleChoice());
		return (DragMultipleChoice)objMapping.get(_case);
	}
	
	public LostWordListen getLostWordListen() {
		String _case = "LostWordListen";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new LostWordListen());
		return (LostWordListen)objMapping.get(_case);
	}
	
	public BoxMatchListen getBoxMatchListen() {
		String _case = "BoxMatchListen";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new BoxMatchListen());
		return (BoxMatchListen)objMapping.get(_case);
	}
	
	public ListenAndTranslate getListenAndTranslate() {
		String _case = "ListenAndTranslate";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new ListenAndTranslate());
		return (ListenAndTranslate)objMapping.get(_case);
	}
	
	public ListenSelectSingleBox getListenSelectSingleBox() {
		String _case = "ListenSelectSingleBox";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new ListenSelectSingleBox());
		return (ListenSelectSingleBox)objMapping.get(_case);
	}
	
	public ListenSelectPicture getListenSelectPicture() {
		String _case = "ListenSelectPicture";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new ListenSelectPicture());
		return (ListenSelectPicture)objMapping.get(_case);
	}
	
	public BoxMatchParagraph getBoxMatchParagraph() {
		String _case = "BoxMatchParagraph";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new BoxMatchParagraph());
		return (BoxMatchParagraph)objMapping.get(_case);
	}
	
	public BoxMatchSentence getBoxMatchSentence() {
		String _case = "BoxMatchSentence";
		if(!objMapping.containsKey(_case))objMapping.put(_case, new BoxMatchSentence());
		return (BoxMatchSentence)objMapping.get(_case);
	}
	
	public void getUrl(String url) throws InterruptedException{
		webApplication.getDriver().get(url);
	}
	
	public void login() throws InterruptedException{
		LandingPage landingPage = new LandingPage();
		landingPage.ClickButtonLogin();
		landingPage.getLogin().SetTextUsername("enzpart");
		landingPage.getLogin().SetTextPassword("larabel123");
		landingPage.getLogin().ClickButtonLogin();
		login=1;
		Thread.sleep(3000);
		//this.popUp();
		//Thread.sleep(3000);
	}
	
	public void popUp()
	{
		if(pop==0){
			WebElement btnOkPopUp = webApplication.getDriver().findElement(By.xpath("//*[@id='btn-ok-mobile-user-agent-alert']"));
			btnOkPopUp.click();
			pop=1;
		}
	}
	
	public WebElement getBtnPeriksa(){
		btnPeriksa = webApplication.getDriver().findElement(By.className("btn-check"));
		return btnPeriksa;
	}
	
	public WebElement getStatus(){
		status = webApplication.getDriver().findElement(By.className("lesson-status"));
		return status;
	}
	
	public void closeBrowser(){
		webApplication.getDriver().quit();
	}
	
	public RemoteWebDriver getDriver(){
		return webApplication.getDriver();
	}
	
	public void destroy(String key){
		objMapping.remove(key);
	}
	
	

	
}
