package endtoend.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import endtoend.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".action__submit")
	private WebElement submit;

	@FindBy(css = ".form-group input")
	private WebElement country;

	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	private WebElement selectCountry;

	By ele = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {

		Actions a = new Actions(driver);

		a.sendKeys(country, countryName).build().perform();

		waitForElementToAppear(ele);

		selectCountry.click();

	}

	public ConfirmationPage submitTheOrder() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(3000);

		submit.click();

		return new ConfirmationPage(driver);

	}
}
