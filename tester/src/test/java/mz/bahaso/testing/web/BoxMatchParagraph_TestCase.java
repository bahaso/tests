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

public class BoxMatchParagraph_TestCase {
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/568a2486938e8e4d3d8b456e";
	String instruksi = "Lengkapi kalimat-kalimat di bawah ini dengan memasukkan kata yang tepat";
	String pertanyaan = "Seyoon is from . He is . He is a guy. Terada is from . He is . He lives in . He is a person.";
	
	ArrayList<String> pilihanjawaban = new ArrayList<String>();
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	ArrayList<String> jawabanSalah2 = new ArrayList<String>();
	
	ArrayList<String> tampilanJawaban = new ArrayList<String>();
	ArrayList<Integer> urutan = new ArrayList<Integer>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		pilihanjawaban.add("South Korea");
		pilihanjawaban.add("Korean");
		pilihanjawaban.add("funny");
		pilihanjawaban.add("Japan");
		pilihanjawaban.add("Japanese");
		pilihanjawaban.add("Tokyo");
		pilihanjawaban.add("quiet");
		pilihanjawaban.add("fun");
		
		jawabanBenar.add("South Korea");
		jawabanBenar.add("Korean");
		jawabanBenar.add("funny");
		jawabanBenar.add("Japan");
		jawabanBenar.add("Japanese");
		jawabanBenar.add("Tokyo");
		jawabanBenar.add("quiet");
		
		jawabanSalah.add("South Korea");
		jawabanSalah.add("Korean");
		jawabanSalah.add("funny");
		jawabanSalah.add("Japan");
		jawabanSalah.add("Japanese");
		jawabanSalah.add("quiet");
		jawabanSalah.add("Tokyo");
		
		jawabanSalah2.add("Korean");
		jawabanSalah2.add("funny");
		jawabanSalah2.add("South Korea");
		jawabanSalah2.add("Japanese");
		jawabanSalah2.add("Japan");
		jawabanSalah2.add("quiet");
		jawabanSalah2.add("Tokyo");
		
		//subLessonPage.login();
		
		action = new Actions(subLessonPage.getDriver());
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBoxMatchParagraph().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBoxMatchParagraph().question.getText().equals(pertanyaan)==false){
			hardAssert.fail("Pertanyaan " + subLessonPage.getBoxMatchParagraph().question.getText()+ " tidak sama dengan yang di database");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchParagraph().getBoxAnswer().size();i++){
			if(pilihanjawaban.contains(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i).getText())==false){
				hardAssert.fail("pilihan jawaban " + subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i).getText()+ " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		
		for(int i=0;i<subLessonPage.getBoxMatchParagraph().getDropBox().size()-1;i++){
			action.dragAndDrop(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i), subLessonPage.getBoxMatchParagraph().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
				hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan di jawab");
			}
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchParagraph().getDropBox().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i), subLessonPage.getBoxMatchParagraph().getDropBox().get(i)).perform();
			Thread.sleep(3000);
		}
		
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
			hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchParagraph().getBoxAnswer().size();i++){
			Integer index = jawabanBenar.indexOf(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i), subLessonPage.getBoxMatchParagraph().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchParagraph().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i), subLessonPage.getBoxMatchParagraph().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getBoxMatchParagraph().getBoxAnswer().size();i++){
			Integer index = jawabanSalah2.indexOf(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i), subLessonPage.getBoxMatchParagraph().getDropBox().get(index)).perform();
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
		for(int i=0;i<subLessonPage.getBoxMatchParagraph().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i), subLessonPage.getBoxMatchParagraph().getDropBox().get(index)).perform();
				Thread.sleep(3000);
				if(jawabanBenar.indexOf(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i).getText()) == jawabanSalah.indexOf(subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(i).getText())){
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
			String status[] = subLessonPage.getBoxMatchParagraph().getBoxAnswer().get(urutan.get(i)).getAttribute("class").split(" ");
			if(tampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
	}
	
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("BoxMatchParagraph");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
