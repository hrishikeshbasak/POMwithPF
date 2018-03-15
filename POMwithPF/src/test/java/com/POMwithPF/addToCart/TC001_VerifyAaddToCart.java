package com.POMwithPF.addToCart;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.iCatalyst.POMWithPF.testbase.TestBase;
import com.iCatalyst.POMWithPF.uiActions.HomePage;
import com.iCatalyst.POMWithPF.uiActions.ProductDetailsPage;

public class TC001_VerifyAaddToCart extends TestBase{
	HomePage homepage;
	ProductDetailsPage productDetailsPage;
	
	@BeforeClass
	public void setUp() throws IOException {
      init(); 
	}

	@Test
	public void verifyAaddToCart() {
		try {
			log.info("=======Starting verifyAaddToCart test========");
			homepage = new  HomePage(driver);
			homepage.switchToFrame();
			homepage.clickOnNavigationMenu(homepage.mens);
			homepage.clickOnProductInMensSection(homepage.jackets);
			productDetailsPage = new ProductDetailsPage(driver);
			productDetailsPage.selectProduct(productDetailsPage.contrast_jacket);
			homepage.switchToDefaultContent();
			log.info("=======Finished verifyAaddToCart test========");
			getScreenShot("verifyAaddToCart");
		} catch (Exception e) {
           getScreenShot("verifyAaddToCart");
		}
	}

//	@AfterClass
//	public void endTest() {
//      closeBrowser();
//	}

}
