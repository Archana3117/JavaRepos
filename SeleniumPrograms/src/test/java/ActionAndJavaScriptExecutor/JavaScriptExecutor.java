package ActionAndJavaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('email').value='Archana'");
		
		
		String title=js.executeScript("return document.title").toString();
		System.out.println(title);
		
		//js.executeScript("window.scrollBy(0,300)");
		
		//for scrool on footer
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		
		//scroll in mid
		js.executeScript("document.getElementById('u_0_5_an').scrollIntoView()");
		
		//go to back page
		js.executeScript("window.history.back()");
		
		//forword 
		js.executeScript("window.history.forward()");
		
		js.executeScript("window.history.go(0)");
	}

}
