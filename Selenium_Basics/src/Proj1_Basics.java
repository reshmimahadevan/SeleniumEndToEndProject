import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;

public class Proj1_Basics {

	public static void main(String[] args) {
		
		ChromeOptions co = new ChromeOptions();
		
		String browserPath=SeleniumManager.getInstance().getDriverPath(co, false).browserPath;
		
		String driverPath=SeleniumManager.getInstance().getDriverPath(co, false).driverPath;
		
		System.out.println(browserPath+" "+driverPath);
		
		//co.setBrowserVersion("116");
		
		//co.setBrowserVersion("dev");
		
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://rahulshettyacademy.com/");

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		// driver.close();

		// driver.get("https://rahulshettyacademy.com/loginpagePractise/"); //Invalid session ID

        // driver.quit();

        // driver.get("https://rahulshettyacademy.com/loginpagePractise/");  //Session ID is null

	}

}
