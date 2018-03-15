package advance.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AlertTutorial {
	
	WebDriver driver;
	
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@Test
	public void alert() {
		
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().getText();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}

	
	
}
