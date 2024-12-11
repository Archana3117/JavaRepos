package webdriverscreenshots;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;


public class selfy2 {
	
	public String getTestCaseName()
	{
		return this.getClass().getSimpleName();
	}
	
	public static void main(String[] args) throws Exception {
	
		
		selfy2 s=new selfy2();
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		List<WebElement>links=driver.findElements(By.linkText("java"));
		
		Date d=new Date();
		String dt=d.toString().replace(" ", "_").replace(";", "_");
		
		if(links.size()== 0)
		{
			File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrfile,new File("C:\\Users\\Lenovo\\Desktop\\Screenshot\\"+s.getTestCaseName()+"-"+dt+".jpeg"));
		}
		
		
	}

}
