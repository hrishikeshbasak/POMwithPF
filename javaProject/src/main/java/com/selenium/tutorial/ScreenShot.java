package com.selenium.tutorial;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ScreenShot {
	WebDriver driver;
	@Test
	public void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File descFile = new File(".\\screenShots\\Sample.png");
		FileUtils.copyFile(scrFile, descFile);
	}
	
	@AfterTest
	public void endTest() {
		driver.quit();
	}
}
