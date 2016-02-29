package mz.bahaso.testing.web;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class ListenAndTranslate_TestCase {
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/568cc89d938e8edf248b457b";
	String instruksi = "Ketik arti kata dalam bahasa Indonesia";
	
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	String tampilanJawaban;
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		jawabanBenar.add("keponakan perempuan");
		jawabanBenar.add("ponakan perempuan");
		jawabanBenar.add("kemenakan perempuan");
		
		//subLessonPage.login();
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getListenAndTranslate().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(2000);
		String playPause[] = subLessonPage.getListenAndTranslate().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audio-playing")==false){
			hardAssert.fail("audio tidak play otomatis pada saat halaman dibuka");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(2000);
		subLessonPage.getListenAndTranslate().getAudioPause().click();
		Thread.sleep(1000);
		String playPause[] = subLessonPage.getListenAndTranslate().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audiojs")==false){
			hardAssert.fail("audio tidak bisa dipause");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		String playPause[];
		Thread.sleep(1000);
		subLessonPage.getListenAndTranslate().getAudioPause().click();
		Thread.sleep(1000);
		playPause = subLessonPage.getListenAndTranslate().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audiojs")==false){
			hardAssert.fail("audio tidak bisa dipause");
		}
		subLessonPage.getListenAndTranslate().getAudioPlay().click();
		Thread.sleep(1000);
		playPause = subLessonPage.getListenAndTranslate().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audio-playing")==false){
			hardAssert.fail("audio tidak play kembali setelah keadaan pause");
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		subLessonPage.getListenAndTranslate().BoxAnswer.sendKeys("");
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		subLessonPage.getListenAndTranslate().BoxAnswer.sendKeys("asd");
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
			hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua pertanyaan dijawab");
		}
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		subLessonPage.getListenAndTranslate().BoxAnswer.sendKeys(jawabanBenar.get(0));
		Thread.sleep(1000);
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		subLessonPage.getListenAndTranslate().BoxAnswer.sendKeys("asd");
		Thread.sleep(1000);
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test9() throws InterruptedException{
		Thread.sleep(1000);
		tampilanJawaban = new String();
		subLessonPage.getListenAndTranslate().BoxAnswer.sendKeys("asd");
		tampilanJawaban = "false";
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getListenAndTranslate().BoxAnswer.getAttribute("class").split(" ");
		if(status[status.length-1].equals(tampilanJawaban)==false){
			if(tampilanJawaban.equals("false")){
				hardAssert.fail("tampilan jawaban seharusnya merah karena jawabannya salah");
			}else{
				hardAssert.fail("tampilan jawaban seharusnya biru karena jawabannya benar");
			}
			
		}
	}
	
	@Test
	public void test10() throws InterruptedException{
		Thread.sleep(1000);
		tampilanJawaban = new String();
		subLessonPage.getListenAndTranslate().BoxAnswer.sendKeys(jawabanBenar.get(1));
		tampilanJawaban = "true";
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getListenAndTranslate().BoxAnswer.getAttribute("class").split(" ");
		if(status[status.length-1].equals(tampilanJawaban)==false){
			if(tampilanJawaban.equals("false")){
				hardAssert.fail("tampilan jawaban seharusnya merah karena jawabannya salah");
			}else{
				hardAssert.fail("tampilan jawaban seharusnya biru karena jawabannya benar");
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("ListenAndTranslate");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
