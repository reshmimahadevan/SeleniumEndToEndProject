package secondpackage;

import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Proj21_PopUp {

	public static void main(String[] args) throws InterruptedException {

		// Pop up blocking not working --See the bookmarked page
		// https://www.browserstack.com/docs/automate/selenium/handle-permission-pop-ups#know-your-location-popup

		ChromeOptions option = new ChromeOptions();

		option.addArguments("--remote-allow-origins=*");

		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		WebDriver driver = WebDriverManager.chromedriver().capabilities(option).avoidShutdownHook().create();

		driver.manage().window().maximize();

		driver.get("https://www.yatra.com/");

	}

}
