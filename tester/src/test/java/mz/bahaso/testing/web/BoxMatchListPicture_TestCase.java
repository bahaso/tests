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

public class BoxMatchListPicture_TestCase {
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/56839157938e8e13728b4568";
	String instruksi = "Pindahkan kata depan yang tepat dalam kotak yang disediakan.";
	String imageSource = "http://cdn.bahaso.com/original/b4bcabff84fe8463812009fd3c79b7c48c5f093b77b1ed324631576dc47c7008/cases/pictures/2015/12/30/e37573e8deeeb368f74bcc3a7e9d01f0a47db3461bbd0c98d7c15b1116114fda.png";
	
	ArrayList<String> pertanyaan = new ArrayList<String>();
	ArrayList<String> pilihanjawaban = new ArrayList<String>();
	
	ArrayList<String> jawabanBenar = new ArrayList<String>();
	ArrayList<String> jawabanSalah = new ArrayList<String>();
	ArrayList<String> jawabanSalah2 = new ArrayList<String>();
	
	ArrayList<String> tampilanJawaban = new ArrayList<String>();
	ArrayList<Integer> urutan = new ArrayList<Integer>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		pertanyaan.add("The car keys are the table and the doll.");
		
		pilihanjawaban.add("on");
		pilihanjawaban.add("next to");
		pilihanjawaban.add("between");
		pilihanjawaban.add("inside");
		
		jawabanBenar.add("on");
		jawabanBenar.add("next to");

		
		jawabanSalah.add("on");
		jawabanSalah.add("inside");
		
		jawabanSalah2.add("between");
		jawabanSalah2.add("inside");
		
		action = new Actions(subLessonPage.getDriver());
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBoxMatchListPicture().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBoxMatchListPicture().image.getAttribute("src").equals(imageSource)==false){
			hardAssert.fail("sumber image tidak sama dengan database");
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(pertanyaan.size()!=subLessonPage.getBoxMatchListPicture().getQuestion().size()){
			hardAssert.fail("Jumlah pertanyaan tidak sama dengan database");
		}
		for(int i=0;i<subLessonPage.getBoxMatchListPicture().getQuestion().size();i++){
			if(subLessonPage.getBoxMatchListPicture().getQuestion().get(i).getText().equals(pertanyaan.get(i))==false){
				hardAssert.fail("Pertanyaan " + subLessonPage.getBoxMatchListPicture().getQuestion().get(i).getText()+ " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		Thread.sleep(1000);
		if(pilihanjawaban.size()!=subLessonPage.getBoxMatchListPicture().getBoxAnswer().size()){
			hardAssert.fail("Jumlah pertanyaan tidak sama dengan database");
		}
		for(int i=0;i<subLessonPage.getBoxMatchListPicture().getBoxAnswer().size();i++){
			if(pilihanjawaban.contains(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i).getText())==false){
				hardAssert.fail("pilihan jawaban " + subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i).getText()+ " tidak sama dengan yang di database");
			}
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		
		for(int i=0;i<jawabanBenar.size()-1;i++){
			action.dragAndDrop(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchListPicture().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(i<jawabanBenar.size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
				hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		for(int i=0;i<jawabanBenar.size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchListPicture().getDropBox().get(i)).perform();
			Thread.sleep(3000);
			if(i==jawabanBenar.size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
		
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
			hardAssert.fail("Tombol periksa tikda bisa diklik sesudah semua jawaban di drag");
		}
	}
	
	@Test
	public void test7() throws InterruptedException{
		for(int i=0;i<subLessonPage.getBoxMatchListPicture().getBoxAnswer().size();i++){
			Integer index = jawabanBenar.indexOf(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchListPicture().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchListPicture().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya benar");
	}
	
	@Test
	public void test8() throws InterruptedException{
		for(int i=0;i<subLessonPage.getBoxMatchListPicture().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchListPicture().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchListPicture().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test9() throws InterruptedException{
		for(int i=0;i<subLessonPage.getBoxMatchListPicture().getBoxAnswer().size();i++){
			Integer index = jawabanSalah2.indexOf(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchListPicture().getDropBox().get(index)).perform();
				Thread.sleep(3000);
			}
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchListPicture().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test10and11() throws InterruptedException{
		for(int i=0;i<subLessonPage.getBoxMatchListPicture().getBoxAnswer().size();i++){
			Integer index = jawabanSalah.indexOf(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i).getText());
			if(index!=-1){
				action.dragAndDrop(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchListPicture().getDropBox().get(index)).perform();
				Thread.sleep(3000);
				if(jawabanBenar.indexOf(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i).getText())== jawabanSalah.indexOf(subLessonPage.getBoxMatchListPicture().getBoxAnswer().get(i).getText())){
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
			String status[] = subLessonPage.getBoxMatchDisappear().getBoxAnswer().get(urutan.get(i)).getAttribute("class").split(" ");
			if(tampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("BoxMatchListPicture");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
}
