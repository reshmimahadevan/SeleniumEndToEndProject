package secondpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Proj19_ScrollandTable2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		List<WebElement> ls = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));

		int sum = 0;

		for (int i = 0; i < ls.size(); i++) {
			
			sum = sum + Integer.parseInt(ls.get(i).getText());

		}

		System.out.println(sum);
		
		
	}

}
