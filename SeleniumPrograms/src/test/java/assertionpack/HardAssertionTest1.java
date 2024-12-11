package assertionpack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.seleniumconcepts.BaseTest;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertionTest1 {
  @Test
  public void f() {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		
		
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		String expectedtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(actualtitle, expectedtitle);
		
		
		String actualUrl = driver.getCurrentUrl();
		String expectedurl="https://www.amazon.in/";
		assertTrue(actualUrl.contains(expectedurl),"This both are not equal urls");
		
		
		assertTrue(driver.findElement(By.linkText("Best Sellers")).isDisplayed(), "This link is not displayed");
		
		driver.quit();
		
  }
}
