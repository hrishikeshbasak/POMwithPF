package com.custom.listiner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.config.TestBase;

public class LoginTest extends TestBase{
	
	@Test
	public void loginTest() {
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("basakhrishi@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
	}

}
