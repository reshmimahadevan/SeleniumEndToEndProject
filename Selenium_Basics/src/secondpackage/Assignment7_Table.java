package secondpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7_Table {

	public static void main(String[] args) {
		
		//See Rahul SIr solution for optimized code under Section-12

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(500,700)");

		System.out.println(
				"No of rows :" + driver.findElements(By.cssSelector("div[class='left-align'] table tbody tr")).size());

		System.out.println("No of columns :"
				+ driver.findElements(By.cssSelector("div[class='left-align'] table tbody tr th")).size());

		List<WebElement> ls = driver
				.findElements(By.cssSelector("div[class='left-align'] table tbody tr:nth-child(3) td"));
		
		System.out.println("2nd row details:");
		
		System.out.println(ls.get(0).getText());

		System.out.println(ls.get(1).getText());

		System.out.println(ls.get(2).getText());
	}

}