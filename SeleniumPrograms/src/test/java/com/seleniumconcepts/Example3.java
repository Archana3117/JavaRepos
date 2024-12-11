package com.seleniumconcepts;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example3 {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@jsname='vdLsw']")).sendKeys("Hadoop");
		
		List<WebElement> listof=driver.findElements(By.xpath("//div[@jsname='erkvQe']//ul/li//descendant::div[@class='wM6W7d']/span"));
		
		for(int i=0;i<=listof.size();i++)
		{
			if(listof.get(i).getText().contains("hadoop download"))
			{
				listof.get(i).click();
			}
		}
		
		

	}

}
