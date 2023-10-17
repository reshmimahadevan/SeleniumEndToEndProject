import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assingment3_Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("learning");

		driver.findElement(By.xpath("//div[@class='form-check-inline']/label[2]")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Okay']")));

		driver.findElement(By.xpath("//button[text()='Okay']")).click();

		WebElement s1 = driver.findElement(By.cssSelector("div select"));

		Select s2 = new Select(s1);

		s2.selectByVisibleText("Consultant");

		driver.findElement(By.cssSelector("#terms")).click();

		driver.findElement(By.cssSelector("input[class*=btn-info]")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']")));

		List<WebElement> list = driver.findElements(By.xpath("//button[text()='Add ']"));

		for (int i = 0; i < list.size(); i++)

		{

			list.get(i).click();

		}

		driver.findElement(By.xpath("//a[contains(@class,'btn-primary')]")).click();
	}
}
