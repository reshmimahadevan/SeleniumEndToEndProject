package secondpackage;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Proj20_SSL {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
				
		ChromeOptions option = new ChromeOptions();
		
		//Proxy
		
		Proxy proxy = new Proxy();

		proxy.setHttpProxy("ipaddress:4444");

		option.setCapability("proxy", proxy);
		
		//Allowing Chrome browser to open

		option.addArguments("--remote-allow-origins=*");
		
		//SSL -Privacy page open
		
		option.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();

		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());

	}

}
