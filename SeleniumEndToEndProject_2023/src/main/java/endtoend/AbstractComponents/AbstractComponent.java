package endtoend.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import endtoend.pageobject.CartPage;
import endtoend.pageobject.OrderPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	
	public void waitForElementToAppear(By findBy) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		w.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitForElementToDisppear(WebElement ele) throws InterruptedException {

		Thread.sleep(3000);

		// WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(2));

		// w.until(ExpectedConditions.invisibilityOf(ele));

	}

	public CartPage goToCart() {
		cartHeader.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public OrderPage goToOrdersPage() throws InterruptedException
	{
		Thread.sleep(3000);
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
}