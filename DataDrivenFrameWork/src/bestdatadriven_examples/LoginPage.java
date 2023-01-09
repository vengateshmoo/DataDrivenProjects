package bestdatadriven_examples;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginPage {
	WebDriver driver;
	String [][] data=null;

	@DataProvider(name="logindata")
	public  String [][] loginDataprovider() throws BiffException, IOException {
		data= getexceldata();
		return data;
	}
	@BeforeTest
	public void beforetest() {
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\ADMIN\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	//jxl jar excel read

	public String[][] getexceldata() throws BiffException, IOException {
		FileInputStream excel=new FileInputStream("C:\\Users\\ADMIN\\Desktop\\Book1.xls");
		Workbook workbook =Workbook.getWorkbook(excel);
		Sheet sheet =workbook.getSheet(0);
		int rowcount=sheet.getRows();
		int coloumncount=sheet.getColumns();
		String testdata[][]=new String [rowcount-1][coloumncount];
		for(int i=1;i<rowcount;i++) {
			for(int j=0;j<coloumncount;j++) {
				testdata[i-1][j]=sheet.getCell(j,i).getContents();
			}
		}
		return testdata;

	}

	@Test(dataProvider ="logindata")
	public void bothCorrect(String uname, String psword) {

		driver.get("https://demo.nopcommerce.com/");

		WebElement login= driver.findElement(By.linkText("Log in"));
		login.click();

		WebElement username= driver.findElement(By.id("Email"));
		username.sendKeys(uname);

		WebElement password=	driver.findElement(By.id("Password"));
		password.sendKeys(psword);

		WebElement submit=	driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
		submit.click();




	}


}
