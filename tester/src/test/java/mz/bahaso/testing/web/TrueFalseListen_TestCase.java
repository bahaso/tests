package mz.bahaso.testing.web;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class TrueFalseListen_TestCase {
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/568ba5c3938e8ebe3d8b4569";
	String instruksi = "Tentukan benar atau salah berdasarkan suara dan kalimat di bawah ini";
	String pertanyaan = "What time is it?";
	String deskripsi = "It's four past twenty five o'clock";
	
	boolean jawaban = true;
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		//subLessonPage.login();
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getTrueFalseListen().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getTrueFalseListen().question.getText().equals(pertanyaan)==false){
			hardAssert.fail("pertanyaan tidak sama");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getTrueFalseListen().description.getText().equals(deskripsi)==false){
			hardAssert.fail("deskripsi tidak sama");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		String playPause[] = subLessonPage.getTrueFalseListen().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audio-playing")==false){
			hardAssert.fail("audio tidak play otomatis pada saat halaman dibuka");
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		subLessonPage.getTrueFalseListen().getAudioPause().click();
		Thread.sleep(1000);
		String playPause[] = subLessonPage.getTrueFalseListen().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audiojs")==false){
			hardAssert.fail("audio tidak bisa dipause");
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
		}
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getTrueFalseListen().getBoxAnswer().size();i++){
			subLessonPage.getTrueFalseListen().getBoxAnswer().get(i).click();
			Thread.sleep(1000);
			if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah pertanyaan dijawab");
			}
		}
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		if(jawaban){
			subLessonPage.getTrueFalseListen().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalseListen().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test9() throws InterruptedException{
		Thread.sleep(1000);
		if(!jawaban){
			subLessonPage.getTrueFalseListen().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalseListen().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test10() throws InterruptedException{
		Thread.sleep(1000);
		if(!jawaban){
			subLessonPage.getTrueFalseListen().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalseListen().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[];
		if(!jawaban){
			status = subLessonPage.getTrueFalseListen().getTampilanJawaban().get(0).getAttribute("class").split(" ");
		}else{
			status = subLessonPage.getTrueFalseListen().getTampilanJawaban().get(1).getAttribute("class").split(" ");
		}
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test11() throws InterruptedException{
		Thread.sleep(1000);
		if(jawaban){
			subLessonPage.getTrueFalseListen().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalseListen().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[];
		if(jawaban){
			status = subLessonPage.getTrueFalseListen().getTampilanJawaban().get(0).getAttribute("class").split(" ");
		}else{
			status = subLessonPage.getTrueFalseListen().getTampilanJawaban().get(1).getAttribute("class").split(" ");
		}
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("TrueFalseListen");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
	
	
}
