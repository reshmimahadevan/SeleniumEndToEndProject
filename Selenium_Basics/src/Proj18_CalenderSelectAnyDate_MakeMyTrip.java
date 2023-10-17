import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Proj18_CalenderSelectAnyDate_MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();

		option.addArguments("--remote-allow-origins=*");

		WebDriver driver = WebDriverManager.chromedriver().capabilities(option).avoidShutdownHook().create();

		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		Thread.sleep(5000L);
		
		while(!driver.findElement(By.cssSelector("div[class='DayPicker-Caption']")).getText().contains("February 2024"))
		{
		driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
		}
				
		List<WebElement> d =driver.findElements(By.cssSelector(".DayPicker-Day"));
		
		int count=d.size();
		
		for(int i=0;i<count;i++)
		{
			String[] date  = d.get(i).getText().split("\n");
			
			String formattedDate=date[0];
				
							
			if(formattedDate.equalsIgnoreCase("8"))
			{
				d.get(i).click();
				break;
			}
		} 
	}

}
