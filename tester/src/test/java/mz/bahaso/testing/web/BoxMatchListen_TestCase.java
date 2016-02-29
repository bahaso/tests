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

public class BoxMatchListen_TestCase {
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/56810456938e8e173c8b4575";
	String instruksi = "Pasangkan abjad dengan suara yang tepat";
	
	ArrayList<String> pilihanjawaban = new ArrayList<String>();
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	
	ArrayList<String> tampilanJawaban = new ArrayList<String>();
	
	ArrayList<Integer> urutan = new ArrayList<Integer>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		pilihanjawaban.add("A");
		pilihanjawaban.add("U");
		pilihanjawaban.add("O");
		pilihanjawaban.add("I");
		
		jawabanBenar.add("A");
		jawabanBenar.add("U");
		jawabanBenar.add("O");
		jawabanBenar.add("I");
		
		jawabanSalah.add("A");
		jawabanSalah.add("U");
		jawabanSalah.add("I");
		jawabanSalah.add("O");
		
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
		if(subLessonPage.getBoxMatchListen().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchListen().getAudio().size();i++){
			subLessonPage.getBoxMatchListen().getAudioButtonPlay().get(i).click();
			Thread.sleep(500);
			String PlayPause[] = subLessonPage.getBoxMatchListen().getAudio().get(i).getAttribute("class").split(" ");
			if(PlayPause[PlayPause.length-1].equals("audio-playing")==false){
				hardAssert.fail("audio " +(i+1) + " tidak bisa di-play");
			}
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchListen().getAudio().size();i++){
			subLessonPage.getBoxMatchListen().getAudioButtonPlay().get(i).click();
			Thread.sleep(500);
			subLessonPage.getBoxMatchListen().getAudioButtonPause().get(i).click();
			Thread.sleep(500);
			String PlayPause[] = subLessonPage.getBoxMatchListen().getAudio().get(i).getAttribute("class").split(" ");
			if(PlayPause[PlayPause.length-1].equals("audiojs")==false){
				hardAssert.fail("audio " +(i+1) + " tidak bisa di-pause");
			}
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		if(pilihanjawaban.size()!=subLessonPage.getBoxMatchListen().getBoxAnswer().size()){
			hardAssert.fail("Jumlah pertanyaan tidak sama dengan database");
		}
		for(int i=0;i<subLessonPage.getBoxMatchListen().getBoxAnswer().size();i++){
			if(pilihanjawaban.contains(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i).getText())==false){
				hardAssert.fail("pilihan jawaban " + subLessonPage.getBoxMatchListen().getBoxAnswer().get(i).getText()+ " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		
		for(int i=0;i<subLessonPage.getBoxMatchListen().getBoxAnswer().size()-1;i++){
			action.dragAndDrop(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i), subLessonPage.getBoxMatchListen().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(i==subLessonPage.getBoxMatchListen().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		
		for(int i=0;i<subLessonPage.getBoxMatchListen().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i), subLessonPage.getBoxMatchListen().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(i==subLessonPage.getBoxMatchListen().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchListen().getBoxAnswer().size();i++){
			Integer index = jawabanBenar.indexOf(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i), subLessonPage.getBoxMatchListen().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchListen().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i), subLessonPage.getBoxMatchListen().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test9and10() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchListen().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i), subLessonPage.getBoxMatchListen().getDropBox().get(index)).perform();
				Thread.sleep(3000);
				if(jawabanBenar.indexOf(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i).getText())== jawabanSalah.indexOf(subLessonPage.getBoxMatchListen().getBoxAnswer().get(i).getText())){
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
			String status[] = subLessonPage.getBoxMatchListen().getBoxAnswer().get(urutan.get(i)).getAttribute("class").split(" ");
			if(tampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("BoxMatchListen");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
