package secondpackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assginment4_WindowHandles {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com");

		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();

		driver.findElement(By.cssSelector("a[href$='/windows/new']")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> id = windows.iterator();

		String parentID = id.next();

		String childId = id.next();

		driver.switchTo().window(childId);

		System.out.println(driver.findElement(By.cssSelector(" div h3")).getText());

		driver.switchTo().window(parentID);

		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

	}

}
