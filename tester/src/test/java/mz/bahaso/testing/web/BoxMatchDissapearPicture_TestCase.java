package mz.bahaso.testing.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import mz.page.web.SubLessonPage;

public class BoxMatchDissapearPicture_TestCase{
	Actions action = null;
	
	SubLessonPage subLessonPage = new SubLessonPage();
	
	private Assertion hardAssert = new Assertion();
	private String kategori[] = {"sport attire","sleepwear"};
	
	String url = "http://10.10.24.10/ngeadmin/previewCaseNewTab/56a9f104938e8edf098b456d";
	String instruksi = "Letakkan gambar-gambar berikut pada kategori yang tepat";
	
	Map<String,Integer> jawaban = new HashMap<String, Integer>();
	Map<String,Integer> jawabanSalah = new HashMap<String, Integer>();
	Map<String,Integer> jawabanSalah2 = new HashMap<String, Integer>();
	
	ArrayList<String> TampilanJawaban = new ArrayList<String>();
	
	@BeforeClass
	public void BeforeClass() throws InterruptedException{
		jawaban.put("Running-shoes.png",0);
		jawaban.put("Short.png",0);
		jawaban.put("Tshirt2.png",0);
		jawaban.put("Night-dress.png",1);
		jawaban.put("Pajamas.png",1);
		
		jawabanSalah.put("Running-shoes.png",0);
		jawabanSalah.put("Short.png",1);
		jawabanSalah.put("Tshirt2.png",0);
		jawabanSalah.put("Night-dress.png",0);
		jawabanSalah.put("Pajamas.png",1);
		
		jawabanSalah2.put("Running-shoes.png",0);
		jawabanSalah2.put("Short.png",0);
		jawabanSalah2.put("Tshirt2.png",0);
		jawabanSalah2.put("Night-dress.png",0);
		jawabanSalah2.put("Pajamas.png",1);
		
		action = new Actions(subLessonPage.getDriver());
	}
	
	@BeforeMethod
	public void BeforeMethod() throws InterruptedException{
		subLessonPage.getUrl(url);
	}
	
	@Test
	public void test1() throws InterruptedException{
		Thread.sleep(1000);
		if(subLessonPage.getBoxMatchDisappearPicture().instruction.getText().equals(instruksi)==false){
			hardAssert.fail("Instruksi tidak sama");
		}
	}
	
	@Test
	public void test2(){
		for(int i=0;i<subLessonPage.getBoxMatchDisappearPicture().getCategories().size();i++){
			if(subLessonPage.getBoxMatchDisappear().getCategories().get(i).getText().equals(kategori[i])==false){
				hardAssert.fail("Kategori "+(i+1)+" yang berisi \""+subLessonPage.getBoxMatchDisappear().getCategories().get(i).getText()+"\" tidak sama dengan \""+kategori[i]+"\"");
			}
		}
	}
	
	@Test
	public void test3() throws InterruptedException{
		Thread.sleep(1000);
		if(jawaban.size()==subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().size()){
			for(int i=0;i<jawaban.size();i++){
				if(jawaban.containsKey(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i).getAttribute("data-val"))==false){
					hardAssert.fail(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i).getAttribute("data-val") + " tidak ada dalam admin panel");
				}
			}
		}else{
		   hardAssert.fail("Jumlah pilihan jawaban tidak sama dengan yang di admin panel");
		}
	}
	
	@Test
	public void test4() throws InterruptedException{
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		Thread.sleep(2000);
		for(int i=0;i<subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().size()-1;i++){
			//System.out.println(getBoxMatchDisappearPicture().getBoxAnswer().get(i).getAttribute("data-val"));
			action.dragAndDrop(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchDisappearPicture().getDropBox().get(0)).perform();
			Thread.sleep(3000);
		}
	}
	
	@Test
	public void test5() throws InterruptedException{
		if(subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
			hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
		}
		Thread.sleep(2000);
		for(int i=0;i<subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchDisappear().getDropBox().get(0)).perform();
			Thread.sleep(3000);
			if(i<subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")==null){
				hardAssert.fail("Tombol periksa bisa diklik sebelum semua jawaban di drag");
			}
			else if(i==subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().size()-1 && subLessonPage.getBtnPeriksa().getAttribute("disabled")!=null){
				hardAssert.fail("Tombol periksa tidak bisa diklik sesudah semua jawaban di drag");
			}
		}
	}
	
	@Test
	public void test6() throws InterruptedException{
		Thread.sleep(2000);
		for(int i=0;i<subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchDisappearPicture().getDropBox().get(jawabanSalah.get(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i).getAttribute("data-val")))).perform();
			Thread.sleep(3000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchDisappearPicture().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test7() throws InterruptedException{
		Thread.sleep(2000);
		for(int i=0;i<subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchDisappearPicture().getDropBox().get(jawaban.get(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i).getAttribute("data-val")))).perform();
			Thread.sleep(3000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchDisappearPicture().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("true")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test8() throws InterruptedException{
		Thread.sleep(2000);
		for(int i=0;i<subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchDisappearPicture().getDropBox().get(jawabanSalah2.get(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i).getAttribute("data-val")))).perform();
			Thread.sleep(3000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		String status[] = subLessonPage.getBoxMatchDisappearPicture().getStatus().getAttribute("class").split(" ");
		if(status[status.length-1].equals("false")==false)hardAssert.fail("Hasil akhir seharusnya salah");
	}
	
	@Test
	public void test9and10() throws InterruptedException{
		Thread.sleep(2000);
		for(int i=0;i<subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().size();i++){
			action.dragAndDrop(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i), subLessonPage.getBoxMatchDisappearPicture().getDropBox().get(jawabanSalah.get(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i).getAttribute("data-val")))).perform();
			if(jawaban.get(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i).getAttribute("data-val"))==jawabanSalah.get(subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i).getAttribute("data-val"))){
				TampilanJawaban.add("true");
			}else{
				TampilanJawaban.add("false");
			}
			Thread.sleep(3000);
		}
		
		subLessonPage.getBtnPeriksa().click();
		Thread.sleep(2000);
		
		for(int i=0;i<TampilanJawaban.size();i++){
			String status[] = subLessonPage.getBoxMatchDisappearPicture().getBoxAnswer().get(i).getAttribute("class").split(" ");
			if(TampilanJawaban.get(i).equals(status[status.length-1])==false){
				hardAssert.fail("Tampilan jawaban yang benar dan salah tidak sesuai");
			}
		}
	}
	
	@AfterMethod
	public void destroy(){
		subLessonPage.destroy("BoxMatchDissapearPicture");
	}
	
	@AfterSuite
	public void afterSuite(){
		subLessonPage.closeBrowser();
	}
	
}
