package mz.bahaso.testing.web;

import java.util.ArrayList;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class SentenceFormation_TestCase {
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/567926da938e8e6c5f8b4572";
	String instruksi = "Susun kata-kata di bawah ini menjadi kalimat yang benar";
	
	ArrayList<String> jawaban = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	
	ArrayList<String> tampilanJawaban = new ArrayList<String>();
	ArrayList<Integer> urutan = new ArrayList<Integer>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		jawaban.add("Their");
		jawaban.add("names");
		jawaban.add("are Vince");
		jawaban.add("and");
		jawaban.add("Derek");
		
		jawabanSalah.add("Their");
		jawabanSalah.add("names");
		jawabanSalah.add("Derek");
		jawabanSalah.add("and");
		jawabanSalah.add("are Vince");
		
		action = new Actions(subLessonPage.getDriver());
		
		//subLessonPage.login();
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getSentenceFormation().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getSentenceFormation().getBoxAnswer().size();i++){
			if(jawaban.contains(subLessonPage.getSentenceFormation().getBoxAnswer().get(i).getText())==false){
				hardAssert.fail(subLessonPage.getSentenceFormation().getBoxAnswer().get(i).getText() + " tidak ada di dalam database");
			}
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		for(int i=0;i<subLessonPage.getSentenceFormation().getBoxAnswer().size()-1;i++){
			action.dragAndDrop(subLessonPage.getSentenceFormation().getBoxAnswer().get(i), subLessonPage.getSentenceFormation().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
				hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getSentenceFormation().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getSentenceFormation().getBoxAnswer().get(i), subLessonPage.getSentenceFormation().getDropBox().get(i)).perform();
			Thread.sleep(3000);
		}
		
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
			hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		for(int i=0;i<subLessonPage.getSentenceFormation().getBoxAnswer().size();i++){
			Integer index = jawaban.indexOf(subLessonPage.getSentenceFormation().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getSentenceFormation().getBoxAnswer().get(i), subLessonPage.getSentenceFormation().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test6() throws InterruptedException{
		for(int i=0;i<subLessonPage.getSentenceFormation().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getSentenceFormation().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getSentenceFormation().getBoxAnswer().get(i), subLessonPage.getSentenceFormation().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test7and8() throws InterruptedException{
		for(int i=0;i<subLessonPage.getSentenceFormation().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getSentenceFormation().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getSentenceFormation().getBoxAnswer().get(i), subLessonPage.getSentenceFormation().getDropBox().get(index)).perform();
				Thread.sleep(3000);
				if(jawaban.indexOf(subLessonPage.getSentenceFormation().getBoxAnswer().get(i).getText())== jawabanSalah.indexOf(subLessonPage.getSentenceFormation().getBoxAnswer().get(i).getText())){
					tampilanJawaban.add("true");
					urutan.add(i);
				}else{
					tampilanJawaban.add("false");
					urutan.add(i);
				}
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(3000);
		
		for(int i=0;i<tampilanJawaban.size();i++){
			String status[] = subLessonPage.getSentenceFormation().getBoxAnswer().get(urutan.get(i)).getAttribute("class").split(" ");
			if(tampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("SentenceFormation");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
