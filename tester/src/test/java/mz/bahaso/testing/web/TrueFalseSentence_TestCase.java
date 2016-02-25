package mz.bahaso.testing.web;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class TrueFalseSentence_TestCase {
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/568b2e99938e8e8e4f8b466e";
	String instruksi = "Tentukan true atau false pada kalimat berikut ini";
	String pertanyaan = "This is Daniel jacket.";
	
	boolean jawaban = false;
	
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
		if(subLessonPage.getTrueFalseSentence().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getTrueFalseSentence().question.getText().equals(pertanyaan)==false){
			hardAssert.fail("pertanyaan tidak sama dengan database");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getTrueFalseSentence().getBoxAnswer().size();i++){
			subLessonPage.getTrueFalseSentence().getBoxAnswer().get(i).click();
			Thread.sleep(1000);
			if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah pertanyaan dijawab");
			}
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		if(jawaban){
			subLessonPage.getTrueFalseSentence().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalseSentence().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		if(!jawaban){
			subLessonPage.getTrueFalseSentence().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalseSentence().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		if(jawaban){
			subLessonPage.getTrueFalseSentence().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalseSentence().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[];
		if(jawaban){
			status = subLessonPage.getTrueFalseSentence().getTampilanJawaban().get(0).getAttribute("class").split(" ");
		}else{
			status = subLessonPage.getTrueFalseSentence().getTampilanJawaban().get(1).getAttribute("class").split(" ");
		}
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		if(!jawaban){
			subLessonPage.getTrueFalseSentence().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalseSentence().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[];
		if(!jawaban){
			status = subLessonPage.getTrueFalseSentence().getTampilanJawaban().get(0).getAttribute("class").split(" ");
		}else{
			status = subLessonPage.getTrueFalseSentence().getTampilanJawaban().get(1).getAttribute("class").split(" ");
		}
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("TrueFalseSentence");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
