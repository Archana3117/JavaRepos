package assertionpack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertionTest {
	
	public static void main(String[] args) {
			
		
		 WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			

			SoftAssert obj = new SoftAssert();
			
			
			String actualTitle = driver.getTitle();
			String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
			obj.assertTrue(actualTitle.contains(expectedTitle), "Both Titles are not equal...");
			
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "https://www.amazon.in/abc";
			obj.assertTrue(actualUrl.contains(expectedUrl), "Both urls are not equal...");
			
			
			
			obj.assertTrue(driver.findElement(By.linkText("Best Sellers")).isDisplayed(), "Sign in securely link iS not diSplayed...");
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Books", Keys.ENTER);
			
			obj.assertTrue(driver.findElement(By.xpath("")).isDisplayed());
			
			
			
			obj.assertAll();
			
	}

}
