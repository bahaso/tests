package mz.bahaso.testing.web;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class ListenSelectPicture_TestCase {
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/56825cdf938e8ed6498b4567";
	String instruksi = "Dengar dan pilih gambar yang tepat";
	String jawabanBenar = "two tables";
	
	ArrayList<String> answerImageSource = new ArrayList<String>();
	
	@BeforeClass
	public void  beforaClass() throws InterruptedException{
		answerImageSource.add("http://cdn.bahaso.com/original/b4bcabff84fe8463812009fd3c79b7c48c5f093b77b1ed324631576dc47c7008/cases/pictures/2015/12/29/757472b1bfaa2e92e46de475ff456649832fc92a72f0d072fb58a4dba6448d70.png");
		answerImageSource.add("http://cdn.bahaso.com/original/b4bcabff84fe8463812009fd3c79b7c48c5f093b77b1ed324631576dc47c7008/cases/pictures/2015/12/29/11fb87f781342632606daddbe89ea9a7393818e7482ea6774cd1127385974735.png");
		answerImageSource.add("http://cdn.bahaso.com/original/b4bcabff84fe8463812009fd3c79b7c48c5f093b77b1ed324631576dc47c7008/cases/pictures/2015/12/29/61248cd5f30d80c2e82750391d28d5d539546c2eb877d4ee66966a9a65650c4c.png");
		
		//subLessonPage.login();
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getListenSelectPicture().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		String playPause[] = subLessonPage.getListenSelectPicture().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audio-playing")==false){
			hardAssert.fail("audio tidak play otomatis pada saat halaman dibuka");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		subLessonPage.getListenSelectPicture().getAudioPause().click();
		Thread.sleep(1000);
		String playPause[] = subLessonPage.getListenSelectPicture().audio.getAttribute("class").split(" ");
		if(playPause[playPause.length-1].equals("audiojs")==false){
			hardAssert.fail("audio tidak bisa dipause");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getListenSelectPicture().getAnswerImageSource().size();i++){
			if(answerImageSource.contains(subLessonPage.getListenSelectPicture().getAnswerImageSource().get(i).getAttribute("src"))==false){
				hardAssert.fail("sumber image ke "+i+" tidak sama dengan admin panel");
			}
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
		for(int i=0;i<subLessonPage.getListenSelectPicture().getBoxAnswer().size();i++){
			subLessonPage.getListenSelectPicture().getBoxAnswer().get(i).click();
			Thread.sleep(2000);
			if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah user memilih jawaban");
			}
		}
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getListenSelectPicture().getBoxAnswer().size();i++){
			if(subLessonPage.getListenSelectPicture().tampilanJawaban.get(i).getAttribute("value").equals(jawabanBenar)){
				subLessonPage.getListenSelectPicture().getBoxAnswer().get(i).click();
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
		for(int i=0;i<subLessonPage.getListenSelectPicture().getBoxAnswer().size();i++){
			if(subLessonPage.getListenSelectPicture().tampilanJawaban.get(i).getAttribute("value").equals(jawabanBenar)==false){
				subLessonPage.getListenSelectPicture().getBoxAnswer().get(i).click();
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
		for(int i=0;i<subLessonPage.getListenSelectPicture().getBoxAnswer().size();i++){
			if(subLessonPage.getListenSelectPicture().tampilanJawaban.get(i).getAttribute("value").equals(jawabanBenar)){
				subLessonPage.getListenSelectPicture().getBoxAnswer().get(i).click();
				urutan = i;
				break;
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String tampilan[] = subLessonPage.getListenSelectPicture().tampilanJawaban.get(urutan).getAttribute("class").split(" ");
		if(tampilan[tampilan.length-1].equals("true")==false)hardAssert.fail("tampilan jawaban seharusnya hasilnya dikasih warna biru");
	}
	
	@Test
	public void test11() throws InterruptedException{
		Thread.sleep(1000);
		Integer urutan = null;
		for(int i=0;i<subLessonPage.getListenSelectPicture().getBoxAnswer().size();i++){
			if(subLessonPage.getListenSelectPicture().tampilanJawaban.get(i).getAttribute("value").equals(jawabanBenar)==false){
				subLessonPage.getListenSelectPicture().getBoxAnswer().get(i).click();
				urutan = i;
				break;
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String tampilan[] = subLessonPage.getListenSelectPicture().tampilanJawaban.get(urutan).getAttribute("class").split(" ");
		if(tampilan[tampilan.length-1].equals("false")==false)hardAssert.fail("tampilan jawaban seharusnya hasilnya dikasih warna merah");
	}
	
	
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("ListenSelectPicture");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
