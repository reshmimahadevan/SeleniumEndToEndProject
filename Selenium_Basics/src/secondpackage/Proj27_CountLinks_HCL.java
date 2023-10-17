package secondpackage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proj27_CountLinks_HCL {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();

		option.addArguments("--remote-allow-origins=*");

		WebDriver driver = WebDriverManager.chromedriver().capabilities(option).create();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Count of All Links

		System.out.println(driver.findElements(By.tagName("a")).size());

		// Count of FooterLinks

		WebElement footerLinks = driver.findElement(By.cssSelector("#gf-BIG")); // Limiting Webdriver scope

		System.out.println(footerLinks.findElements(By.tagName("a")).size());

		// Count on the 1st potion of Footer Links

		WebElement div = footerLinks.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		List<WebElement> div1 = div.findElements(By.tagName("a"));

		int size = div.findElements(By.tagName("a")).size();

		// Go inside the 1st portion of footer link and click all links

		for (int i = 1; i < size; i++) {

			String action = Keys.chord(Keys.CONTROL, Keys.ENTER);

			div1.get(i).sendKeys(action);
			
			Thread .sleep(5000L);

		}

		Set<String> s = driver.getWindowHandles();

		Iterator<String> s1 = s.iterator();

		while (s1.hasNext()) {

			driver.switchTo().window(s1.next());
			System.out.println(driver.getTitle());
		}

	}

}
