package endtoend.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import endtoend.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*=flyInOut]")
	WebElement errorMessage;

	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;

	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		String em = errorMessage.getText();
		return em;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
