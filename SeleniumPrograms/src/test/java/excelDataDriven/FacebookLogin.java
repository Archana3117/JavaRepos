package excelDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		
		  ExcelAPIData e=new
		  ExcelAPIData("C:\\Users\\Lenovo\\Downloads\\testdata1.xlsx");
		  
		  for(int i=1;i<e.getRowCount("login");i++) {
		  driver.findElement(By.id("email")).clear();
		  driver.findElement(By.id("email")).sendKeys(e.getCellData("login","UserName",
		  i));
		  
		  
		  driver.findElement(By.id("pass")).clear();
		  driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password",
		  i)); }
		 
		
		// ExcelAPIData e = new ExcelAPIData("C:\\Users\\Lenovo\\Downloads\\suitex.xlsx");
		 
	}

}
