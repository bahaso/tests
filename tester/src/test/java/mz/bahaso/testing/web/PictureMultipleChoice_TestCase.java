package mz.bahaso.testing.web;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class PictureMultipleChoice_TestCase {
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/5679286f938e8e0a3a8b4579";
	String instruksi = "Perhatikan gambar dan pilih jawaban yang tepat";
	String imageSource = "http://cdn.bahaso.com/original/22f3ff117999ac8056b3877f8222cb63da5e0a34f146af7c9cf8c99a21617025/cases/pictures/2015/12/22/69e0d34bddd0feb2e77b644f1f0e096ff59c8471fa7b9b6335b90665222d0fe2.png";
	String pertanyaan = "Who is he?";
	String jawabanBenar = "His name is John.";
	
	ArrayList<String> pilihanJawaban = new ArrayList<String>();
	
	@BeforeClass
	public void  beforaClass() throws InterruptedException{
		pilihanJawaban.add("Her name is John.");
		pilihanJawaban.add("She is John.");
		pilihanJawaban.add("His name is John.");
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getPictureMultipleChoice().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getPictureMultipleChoice().image.getAttribute("src").equals(imageSource)==false){
			hardAssert.fail("sumber image tidak sama dengan database");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getPictureMultipleChoice().question.getText().equals(pertanyaan)==false){
			hardAssert.fail("pertanyaan tidak sama dengan database");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getPictureMultipleChoice().getBoxAnswer().size();i++){
			if(pilihanJawaban.contains(subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).getText())==false){
				hardAssert.fail(subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).getText() + " tidak ada dalam database");
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
		for(int i=0;i<subLessonPage.getPictureMultipleChoice().getBoxAnswer().size();i++){
			subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).click();
			Thread.sleep(2000);
			if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getPictureMultipleChoice().getBoxAnswer().size();i++){
			if(subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).getText().equals(jawabanBenar)){
				subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).click();
				break;
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getPictureMultipleChoice().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test9() throws InterruptedException{
		Thread.sleep(1000);
		for(int i=0;i<subLessonPage.getPictureMultipleChoice().getBoxAnswer().size();i++){
			if(subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).getText().equals(jawabanBenar)==false){
				subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).click();
				break;
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getPictureMultipleChoice().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test10() throws InterruptedException{
		Thread.sleep(1000);
		Integer urutan = null;
		for(int i=0;i<subLessonPage.getPictureMultipleChoice().getBoxAnswer().size();i++){
			if(subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).getText().equals(jawabanBenar)){
				subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).click();
				urutan = i;
				break;
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String tampilan[] = subLessonPage.getPictureMultipleChoice().tampilanJawaban.get(urutan).getAttribute("class").split(" ");
		if(tampilan[tampilan.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test11() throws InterruptedException{
		Thread.sleep(1000);
		Integer urutan = null;
		for(int i=0;i<subLessonPage.getPictureMultipleChoice().getBoxAnswer().size();i++){
			if(subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).getText().equals(jawabanBenar)==false){
				subLessonPage.getPictureMultipleChoice().getBoxAnswer().get(i).click();
				urutan = i;
				break;
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String tampilan[] = subLessonPage.getPictureMultipleChoice().tampilanJawaban.get(urutan).getAttribute("class").split(" ");
		if(tampilan[tampilan.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("PictureMultipleChoice");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
