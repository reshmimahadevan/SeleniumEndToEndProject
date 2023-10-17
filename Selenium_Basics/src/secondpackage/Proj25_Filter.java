package secondpackage;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proj25_Filter {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();

		option.addArguments("--remote-allow-origins=*");

		WebDriver driver = WebDriverManager.chromedriver().capabilities(option).avoidShutdownHook().create();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.manage().window().maximize();

		driver.findElement(By.id("search-field")).sendKeys("Rice");

		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

		// 1 results

		List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice")).

				collect(Collectors.toList());

		// 1 result

		Assert.assertEquals(veggies.size(), filteredList.size());

	}

}
