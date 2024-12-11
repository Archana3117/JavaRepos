package webdriverscreenshots;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy3 {

	
	public String TestCasename()
	{
		return this.getClass().getSimpleName();
	}
	public static void main(String[] args) throws IOException {
		
		Selfy3 s=new Selfy3();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		List<WebElement>links=driver.findElements(By.xpath("//div[@id='SIvCob']//a"));
		
		for(int i=0;i<links.size();i++)
		{
			String link=links.get(i).getText();
			links.get(i).click();
			
			
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcfile,new File("C:\\Users\\Lenovo\\Desktop\\Screenshot\\"+s.TestCasename()+" "+link+".png"));
			links=driver.findElements(By.xpath("//div[@id='SIvCob']//a"));
		}
		
	}

}
