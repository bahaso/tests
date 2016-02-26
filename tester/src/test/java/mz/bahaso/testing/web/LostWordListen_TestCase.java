package mz.bahaso.testing.web;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class LostWordListen_TestCase {
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/5680de85938e8e173c8b456b";
	String instruksi = "Lengkapi percakapan berikut dengan mengetik pada bagian yang kosong";
	
	ArrayList<String> pertanyaan = new ArrayList<String>();
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	ArrayList<String> tampilanJawaban = new ArrayList<String>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		pertanyaan.add("Good morning, Jim!");
		pertanyaan.add("Good , Brittany.");
		pertanyaan.add("See you later, Amelia.");
		pertanyaan.add("See you , Boy.");
		pertanyaan.add("Good evening,Tim.");
		pertanyaan.add("Good ,Julia.");

		jawabanBenar.add("morning");
		jawabanBenar.add("later");
		jawabanBenar.add("evening");
		
		jawabanSalah.add("morning");
		jawabanSalah.add("asd");
		jawabanSalah.add("evening");
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getLostWordListen().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLostWordListen().getQuestion().size();i++){
			if(subLessonPage.getLostWordListen().getQuestion().get(i).getText().equals(pertanyaan.get(i))==false){
				hardAssert.fail("pertanyaan ke " + (i+1) + " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(2000);
		String playPause[] = subLessonPage.getLostWordListen().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audio-playing")==false){
			hardAssert.fail("audio tidak play otomatis pada saat halaman dibuka");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(2000);
		subLessonPage.getLostWordListen().getAudioPause().click();
		Thread.sleep(1000);
		String playPause[] = subLessonPage.getLostWordListen().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audiojs")==false){
			hardAssert.fail("audio tidak bisa dipause");
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		String playPause[];
		Thread.sleep(2000);
		subLessonPage.getLostWordListen().getAudioPause().click();
		Thread.sleep(1000);
		playPause = subLessonPage.getLostWordListen().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audiojs")==false){
			hardAssert.fail("audio tidak bisa dipause");
		}
		subLessonPage.getLostWordListen().getAudioPlay().click();
		Thread.sleep(2000);
		playPause = subLessonPage.getLostWordListen().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audio-playing")==false){
			hardAssert.fail("audio tidak play kembali setelah keadaan pause");
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
		}
		
		for(int i=0;i<subLessonPage.getLostWordListen().getBoxAnswer().size()-1;i++){
			subLessonPage.getLostWordListen().getBoxAnswer().get(i).sendKeys("asd");
			Thread.sleep(1000);
			if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
				hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
			}
		}
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLostWordListen().getBoxAnswer().size();i++){
			subLessonPage.getLostWordListen().getBoxAnswer().get(i).sendKeys("asd");
			Thread.sleep(1000);
		}
		
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
			hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua pertanyaan dijawab");
		}
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLostWordListen().getBoxAnswer().size();i++){
			subLessonPage.getLostWordListen().getBoxAnswer().get(i).sendKeys(jawabanBenar.get(i));
			Thread.sleep(1000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test9() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLostWordListen().getBoxAnswer().size();i++){
			subLessonPage.getLostWordListen().getBoxAnswer().get(i).sendKeys(jawabanSalah.get(i));
			Thread.sleep(1000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test10and11() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getLostWordListen().getBoxAnswer().size();i++){
			subLessonPage.getLostWordListen().getBoxAnswer().get(i).sendKeys(jawabanSalah.get(i));
			if(jawabanSalah.get(i).equals(jawabanBenar.get(i))){
				tampilanJawaban.add("true");
			}else{
				tampilanJawaban.add("false");
			}
			Thread.sleep(1000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		
		for(int i=0;i<subLessonPage.getLostWordListen().getBoxAnswer().size();i++){
			String status[] = subLessonPage.getLostWordListen().getBoxAnswer().get(i).getAttribute("class").split(" ");
			if(status[status.length-1].equals(tampilanJawaban.get(i))==false){
				if(tampilanJawaban.get(i)=="false"){
					hardAssert.fail("tampilan jawaban ke " + i + " seharusnya merah karena jawabannya salah");
				}else{
					hardAssert.fail("tampilan jawaban ke " + i + " seharusnya biru karena jawabannya benar");
				}
				
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("LostWordListen");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
