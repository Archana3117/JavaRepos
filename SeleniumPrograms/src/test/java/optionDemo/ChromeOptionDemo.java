package optionDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionDemo {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		//option.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		option.addArguments("--user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");   //The addArguments method adds command-line arguments to Chrome. Here, it sets the user data directory for Chrome.
	    WebDriver driver=new ChromeDriver(option);
	    driver.manage().window().maximize();
		
		
		
		
		//option.addArguments("--start-maximized");
	
	}

}
