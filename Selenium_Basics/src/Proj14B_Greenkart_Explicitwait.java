import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Proj14B_Greenkart_Explicitwait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
										
			String[] veggiesToBeSelected = { "Tomato", "Onion", "Corn", "Strawberry" };

			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			
			WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));

			addItems(driver, veggiesToBeSelected);
					
			driver.findElement(By.xpath("//img[@alt='Cart']")).click();
			
			driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
			
			driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
			
			driver.findElement(By.cssSelector(".promoBtn")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
			
			System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		
		}

		public static void addItems(WebDriver driver, String[] veggiesToBeSelected) {
			
			List<WebElement> veggiesAvailable = driver.findElements(By.cssSelector("h4.product-name"));

			for (int i = 0; i < veggiesAvailable.size(); i++) {

				String[] veggiesName = veggiesAvailable.get(i).getText().split("-");

				String formattedName = veggiesName[0].trim();

				List<String> veggiesToBeSelectedList = Arrays.asList(veggiesToBeSelected);

				if (veggiesToBeSelectedList.contains(formattedName)) {

					int j = 0;

					j++;

					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

					if (j == veggiesToBeSelected.length)

					{

						break;
					}

				}

			}

		}



	}

