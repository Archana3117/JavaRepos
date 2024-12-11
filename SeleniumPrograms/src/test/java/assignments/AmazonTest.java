package assignments;

import java.awt.RenderingHints.Key;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.seleniumconcepts.BaseTest;

public class AmazonTest extends BaseTest {
	
	
	public static void main(String[] args) {
		
		launch("Chrome");
		navigateUrl("https://amazon.in");
		System.out.println("amazon is succssfully opened");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung ",Keys.ENTER);
		
	
	}

}
