import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Proj6_StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/#");
		
		WebElement staticdp = driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency"));
		
		Select dp=new Select(staticdp);
		
		dp.selectByIndex(3);
		
		System.out.println(dp.getFirstSelectedOption().getText());
		
		dp.selectByVisibleText("AED");
		
		System.out.println(dp.getFirstSelectedOption().getText());
		
		dp.selectByValue("INR");
		
		System.out.println(dp.getFirstSelectedOption().getText());
		
		
		}

}
