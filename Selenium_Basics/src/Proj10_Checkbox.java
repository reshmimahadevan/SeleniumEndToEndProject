import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Proj10_Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		
        WebDriver driver= new ChromeDriver();
        
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected()) ;  
        
        driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
        
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected() ) ;
        
        //Find the total number of checkboxes in webpage"
        
        Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 6);
        
        /*OR;
        
       System.out.println("Total number of checkbox peresent is" +" "+ 
                     driver.findElements(By.xpath("//input[@type='checkbox']")).size());*/
       
       
        
        
        
	}

}
