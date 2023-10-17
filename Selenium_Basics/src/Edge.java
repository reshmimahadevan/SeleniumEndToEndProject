import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Edge {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "C:\\edgedriver_win32\\msedgedriver.exe");
		
		EdgeOptions options = new EdgeOptions();

		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new EdgeDriver(options);
		
		driver.get("https://rahulshettyacademy.com");
	}

}
