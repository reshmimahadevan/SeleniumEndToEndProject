package endtoend.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;


import endtoend.testcomponents.BaseTest;
import endtoend.testcomponents.Retry;
import endtoend.pageobject.CartPage;
import endtoend.pageobject.ProductCatalogue;

public class ErrorValidations extends BaseTest {

	@Test(groups = {"Error Handling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		ld.loginApplication("a1@gmail.com", "Abc@12");
		Assert.assertEquals("Incorrect email or password.", ld.getErrorMessage());

	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = ld.loginApplication("a1@gmail.com", "Abcd@1234");
		//List<WebElement> products = 
		productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}
	
	
}