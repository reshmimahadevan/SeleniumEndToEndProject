package endtoend.tests;

import java.time.Duration;
//import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {

	public static void main(String[] args) throws InterruptedException {

		// String[] productsToBeSelected = { "ZARA", "IPHONE" };

		WebDriver driver = WebDriverManager.chromedriver().avoidShutdownHook().create();

		driver.get("https://rahulshettyacademy.com/client");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("userEmail")).sendKeys("a1@gmail.com");

		driver.findElement(By.id("userPassword")).sendKeys("Abcd@1234");

		driver.findElement(By.id("login")).click();

		/*
		 * for (int i = 0; i < products.size(); i++) {
		 * 
		 * String[] productsName = products.get(i).getText().split(" ");
		 * 
		 * String formattedName = productsName[0].trim();
		 * 
		 * List<String> productsToBeSelectedList = Arrays.asList(productsToBeSelected);
		 * 
		 * if (productsToBeSelectedList.contains(formattedName)) {
		 * 
		 * Thread.sleep(3000);
		 * 
		 * driver.findElements(By.xpath("//button[2]/i")).get(i).click(); }
		 * 
		 * }
		 */

		String name = "ZARA COAT 3";

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5")));

		List<WebElement> products = driver.findElements(By.xpath("//h5"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement((By.cssSelector("b"))).getText().equals("ZARA COAT 3"))
				.findFirst().orElse(null);

		prod.findElement(By.xpath("//button[2]/i")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> productsInCart = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = productsInCart.stream().anyMatch(productInCart -> productInCart.getText().equals(name));

		Assert.assertTrue(match);

		driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();

		Actions a = new Actions(driver);

		a.sendKeys(driver.findElement(By.cssSelector(".form-group input")), "India").build().perform();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')][2])")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".action__submit")).click();
				
		String confirmMessage =driver.findElement(By.cssSelector(".hero-primary")).getText();
				
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}
}