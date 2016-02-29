package mz.bahaso.testing.web;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class ListenSelectSingleBox_TestCase {
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/56792283938e8e6c5f8b4570";
	String instruksi = "Dengarkan dan pilih jawaban yang tepat";
	String pertanyaan = "What is her name?";
	String jawabanBenar = "My name is Diana.";
	
	ArrayList<String> pilihanJawaban = new ArrayList<String>();
	
	@BeforeClass
	public void  beforaClass() throws InterruptedException{
		pilihanJawaban.add("My name is Briana.");
		pilihanJawaban.add("My name is Diana.");
		pilihanJawaban.add("My name is Jack.");
		
		//subLessonPage.login();
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getListenSelectSingleBox().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(2000);
		String playPause[] = subLessonPage.getListenSelectSingleBox().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audio-playing")==false){
			hardAssert.fail("audio tidak play otomatis pada saat halaman dibuka");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(2000);
		subLessonPage.getListenSelectSingleBox().getAudioPause().click();
		Thread.sleep(1000);
		String playPause[] = subLessonPage.getListenSelectSingleBox().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audiojs")==false){
			hardAssert.fail("audio tidak bisa dipause");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getListenSelectSingleBox().question.getText().equals(pertanyaan)==false){
			hardAssert.fail("pertanyaan tidak sama dengan database");
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum user memilih 1 jawaban");
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getListenSelectSingleBox().getBoxAnswer().size();i++){
			subLessonPage.getListenSelectSingleBox().getBoxAnswer().get(i).click();
			Thread.sleep(2000);
			if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getListenSelectSingleBox().getBoxAnswer().size();i++){
			if(subLessonPage.getListenSelectSingleBox().getBoxAnswer().get(i).getText().equals(jawabanBenar)){
				subLessonPage.getListenSelectSingleBox().getBoxAnswer().get(i).click();
				break;
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test9() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getListenSelectSingleBox().getBoxAnswer().size();i++){
			if(subLessonPage.getListenSelectSingleBox().getBoxAnswer().get(i).getText().equals(jawabanBenar)==false){
				subLessonPage.getListenSelectSingleBox().getBoxAnswer().get(i).click();
				break;
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test10() throws InterruptedException{
		Thread.sleep(1000);
		Integer urutan = null;
		for(int i=0;i<subLessonPage.getListenSelectSingleBox().getBoxAnswer().size();i++){
			if(subLessonPage.getListenSelectSingleBox().getBoxAnswer().get(i).getText().equals(jawabanBenar)){
				subLessonPage.getListenSelectSingleBox().getBoxAnswer().get(i).click();
				urutan = i;
				break;
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String tampilan[] = subLessonPage.getListenSelectSingleBox().tampilanJawaban.get(urutan).getAttribute("class").split(" ");
		if(tampilan[tampilan.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test11() throws InterruptedException{
		Thread.sleep(1000);
		Integer urutan = null;
		for(int i=0;i<subLessonPage.getListenSelectSingleBox().getBoxAnswer().size();i++){
			if(subLessonPage.getListenSelectSingleBox().getBoxAnswer().get(i).getText().equals(jawabanBenar)==false){
				subLessonPage.getListenSelectSingleBox().getBoxAnswer().get(i).click();
				urutan = i;
				break;
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String tampilan[] = subLessonPage.getListenSelectSingleBox().tampilanJawaban.get(urutan).getAttribute("class").split(" ");
		if(tampilan[tampilan.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("ListenSelectSingleBox");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
