package endtoend.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import endtoend.testcomponents.BaseTest;
import endtoend.pageobject.CartPage;
import endtoend.pageobject.CheckOutPage;
import endtoend.pageobject.ConfirmationPage;
import endtoend.pageobject.OrderPage;
import endtoend.pageobject.ProductCatalogue;

public class SubmitOrder extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })

	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalogue pc = ld.loginApplication(input.get("email"), input.get("password"));

	    //List<WebElement> prod =
				
		pc.getProductList();

		pc.addProductToCart(input.get("product"));

		CartPage cp = pc.goToCart(); // Parent class method - Child class have access to parent class methods so not
										// need to call the method again in child class

		Boolean match = cp.VerifyProductDisplay(input.get("product"));

		Assert.assertTrue(match);

		CheckOutPage cop = cp.checkOut();

		cop.selectCountry("India");

		ConfirmationPage cp1 = cop.submitTheOrder();

		String productName1 = cp1.getConfirmationMessage();

		Assert.assertTrue(productName1.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() throws InterruptedException {

		ProductCatalogue productCatalogue = ld.loginApplication("a1@gmail.com", "Abcd@1234");

		OrderPage ordersPage = productCatalogue.goToOrdersPage();

		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}

	@DataProvider
	public Object[][] getData() throws IOException {

//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "a1@gmail.com");
//		map.put("password", "Abcd@1234");
//		map.put("product", "ZARA COAT 3");
//
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "a2@gamil.com");
//		map1.put("password", "Abcdef@12345");
//		map1.put("product", "ADIDAS ORIGINAL");

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//endtoend//data//Purchase.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

	/*
	 * @DataProvider public Object[][] getData() { --You have to mention
	 * "public void submitOrder(String email,String password)"  i.e all inputs in parameter
	 * which is not a code metric so using Hashmap"
	 * 
	 * return new Object[][] { { "a1@gmail.com", "Abcd@1234", "ZARA COAT 3" }, {
	 * "a2@gamil.com", "Abcdef@12345", "ADIDAS ORIGINAL" } };
	 * 
	 * }
	 */

}