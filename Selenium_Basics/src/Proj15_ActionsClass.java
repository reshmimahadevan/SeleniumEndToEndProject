import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Proj15_ActionsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");

		Actions a = new Actions(driver);

		a.moveToElement(driver
				.findElement(By.cssSelector("div[id='nav-tools'] a[class*='nav-progressive-attribute']:nth-child(2)")))
				.build().perform();

		a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("Toys").doubleClick().build().perform();

		a.moveToElement(driver
				.findElement(By.cssSelector("div[id='nav-tools'] a[class*='nav-progressive-attribute']:nth-child(2)")))
				.contextClick().build().perform();

	}

}
