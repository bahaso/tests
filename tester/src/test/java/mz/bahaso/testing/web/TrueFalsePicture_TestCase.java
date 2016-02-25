package mz.bahaso.testing.web;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class TrueFalsePicture_TestCase {
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/567929fb938e8e0a3a8b457a";
	String instruksi = "Tentukan benar atau salah berdasarkan gambar berikut ini";
	String pertanyaan = "Apakah pernyataan ini benar?";
	String imageSource = "http://cdn.bahaso.com/original/22f3ff117999ac8056b3877f8222cb63da5e0a34f146af7c9cf8c99a21617025/cases/pictures/2015/12/22/6632f28093aafd9a0778de7f58c590d70dceb3ed8f16d1c71e1ab3544001ef8e.png";
	
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
		if(subLessonPage.getTrueFalsePicture().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getTrueFalsePicture().image.getAttribute("src").equals(imageSource)==false){
			hardAssert.fail("Sumber foto tidak sama");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getTrueFalsePicture().question.getText().equals(pertanyaan)==false){
			hardAssert.fail("pertanyaan tidak sama dengan database");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua pertanyaan dijawab");
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getTrueFalsePicture().getBoxAnswer().size();i++){
			subLessonPage.getTrueFalsePicture().getBoxAnswer().get(i).click();
			Thread.sleep(1000);
			if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah pertanyaan dijawab");
			}
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(1000);
		if(jawaban){
			subLessonPage.getTrueFalsePicture().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalsePicture().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(1000);
		if(!jawaban){
			subLessonPage.getTrueFalsePicture().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalsePicture().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		if(jawaban){
			subLessonPage.getTrueFalsePicture().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalsePicture().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[];
		if(jawaban){
			status = subLessonPage.getTrueFalsePicture().getTampilanJawaban().get(0).getAttribute("class").split(" ");
		}else{
			status = subLessonPage.getTrueFalsePicture().getTampilanJawaban().get(1).getAttribute("class").split(" ");
		}
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test9() throws InterruptedException{
		Thread.sleep(1000);
		if(!jawaban){
			subLessonPage.getTrueFalsePicture().getBoxAnswer().get(0).click();
		}else{
			subLessonPage.getTrueFalsePicture().getBoxAnswer().get(1).click();
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[];
		if(!jawaban){
			status = subLessonPage.getTrueFalsePicture().getTampilanJawaban().get(0).getAttribute("class").split(" ");
		}else{
			status = subLessonPage.getTrueFalsePicture().getTampilanJawaban().get(1).getAttribute("class").split(" ");
		}
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("TrueFalsePicture");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
