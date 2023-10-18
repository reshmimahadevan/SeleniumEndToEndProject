package endtoend.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import endtoend.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;

	public LandingPage ld;

	public WebDriver initializeDriver() throws IOException

	{

		Properties p = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//endtoend//resources//GlobalData.properties");

		p.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: p.getProperty("browser");

		if (browserName.contains("chrome")) {

			ChromeOptions options = new ChromeOptions();

			WebDriverManager.chromedriver().setup();

			if (browserName.contains("headless")) {

				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);
			
			driver.manage().window().setSize(new Dimension(1440,900));

		}

		else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver_win32\\geckodriver.exe");

			driver = new FirefoxDriver();

		}

		else if (browserName.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", "C:\\edgedriver_win32\\msedgedriver.exe");

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String fpath) throws IOException

	{

		// JSON to String
		String jsonContent = FileUtils.readFileToString(new File(fpath), StandardCharsets.UTF_8);

		// String to HashMap Jackson Databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException

	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApp() throws IOException {

		driver = initializeDriver();

		ld = new LandingPage(driver);

		ld.goTo();

		return ld;

	}
}
