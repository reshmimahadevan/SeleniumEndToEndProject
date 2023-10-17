import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assingment2_EndtoEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		
        WebDriver driver= new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        
        //Name Textbox
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Abc");
        
        //Email Textbox        
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("abc@gmail.com");
        
        //Password Textbox
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123");
        
        //Checkbox
        driver.findElement(By.id("exampleCheck1")).click();
        
        //Staticdropdown
        WebElement dd1 = driver.findElement(By.id("exampleFormControlSelect1"));

        Select dd2 = new Select(dd1);

         dd2.selectByVisibleText("Female");
        
        //Radio button     
        driver.findElement(By.cssSelector("#inlineRadio1")).click();
        
        //Calender
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("02/09/2023");
        
        //Submit button
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        
        //Success message
        System.out.println(driver.findElement(By.xpath("//form-comp/div/div[2]")).getText());
        
           

	}

}
