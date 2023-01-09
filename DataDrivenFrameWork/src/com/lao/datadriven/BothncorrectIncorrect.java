package com.lao.datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothncorrectIncorrect {
	
	@Test
	@Parameters({"Email","Password"})
	public void bothCorrect(String uname, String psword) {
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\ADMIN\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement login= driver.findElement(By.linkText("Log in"));
		login.click();
		
		WebElement username= driver.findElement(By.id("Email"));
		username.sendKeys(uname);

		WebElement password=	driver.findElement(By.id("Password"));
		password.sendKeys(psword);
		
		WebElement submit=	driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
		submit.click();
		driver.quit();

	
	}

}
