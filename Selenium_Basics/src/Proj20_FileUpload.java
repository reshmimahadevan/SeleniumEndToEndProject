import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Proj20_FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {

		String downloadPath = System.getProperty("user.dir");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs", chromePrefs);

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://smallpdf.com/pdf-to-jpg");

		driver.findElement(By.cssSelector("span[class*='gGeCVP']")).click();

		Thread.sleep(3000);

		Runtime.getRuntime().exec("C:\\Users\\hp\\Desktop\\Job\\Selenium_2023\\Materials\\AutoIT\\fileupload.exe");

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='jmcfKp']")));

		driver.findElement(By.cssSelector("div[class*='jmcfKp']")).click();

		driver.findElement(By.xpath("//*[text()='Choose option']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Download Zip File']")));

		driver.findElement(By.xpath("//*[text()='Download Zip File']")).click();

		File f = new File(downloadPath + "/fileupload.zip");

		Thread.sleep(8000);

		if (f.exists())

		{

			Assert.assertTrue(f.exists());

			if (f.delete())

				System.out.println("file deleted");

		}

	}

}
