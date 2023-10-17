package secondpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assingnment6 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption3")).click();
		
		String selectedOption= driver.findElement(By.xpath("//div[@class='right-align']/fieldset/label[3]")).getText();
		
		WebElement staticdp = driver.findElement(By.id("dropdown-class-example"));
		
		Select s = new Select(staticdp);
		
		s.selectByVisibleText(selectedOption);
		
		driver.findElement(By.id("name")).sendKeys(selectedOption);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String text = driver.switchTo().alert().getText();
		
		if(text.contains(selectedOption))
			
		{
			driver.switchTo().alert().accept();
		}
		
		else
			
		{
			System.out.println("Failure");
		}
		
		
	}

}
