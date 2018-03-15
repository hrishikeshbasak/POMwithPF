package com.POMwithPF.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.iCatalyst.POMWithPF.testbase.TestBase;
import com.iCatalyst.POMWithPF.uiActions.HomePage;

public class TC002_VerifyRegistration extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_VerifyRegistration.class.getName());
	HomePage homepage;
	String firstName = "test";
	String lastName = "lastTest";
	// String emailAddress = "automation@gmail.com";
	String emailAddress = System.currentTimeMillis() + "@gmail.com";
	String password = "password";
		

	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

	@Test
	public void verifyRegistration() {
		try {
			log.info("=======started verifyRegistration Test===========");
			homepage = new HomePage(driver);
			homepage.switchToFrame();
			homepage.registorUser(firstName, lastName, emailAddress, password);
			Assert.assertEquals(true, homepage.getRegistrationSuccess());
			log.info("=======finished verifyRegistration Test===========");
			getScreenShot("verifyRegistration");
		} catch (AssertionError e) {
			homepage.switchToDefaultContent();
			getScreenShot("verifyRegistration");
			Assert.assertTrue(false, "verifyRegistration");
		} catch (Exception e) {
			log.info(e.fillInStackTrace().toString());
			homepage.switchToDefaultContent();
			getScreenShot("verifyRegistration");
			Assert.assertTrue(false, "verifyRegistration");
		}
	}

	
	
}
