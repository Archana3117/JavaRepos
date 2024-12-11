package com.seleniumconcepts;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	
	private static final Logger log=Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		int pagesize = driver.findElements(By.cssSelector("div.dt-paging>nav>button")).size();
		System.out.println(pagesize);
		log.info("chrome is lu nched");
		
		for(int i=3;i<=pagesize-2;i++)
		{
			String loc = "div.dt-paging>nav>button:nth-child("+i+")";
			driver.findElement(By.cssSelector(loc)).click();
			//Thread.sleep(2000);
			
			List<WebElement> names = driver.findElements(By.cssSelector("table#example>tbody>tr>td:nth-child(1)"));
			for(WebElement n:names)
			{
				System.out.println(n.getText());
			}
			System.out.println(" -------- End of page :" + (i-2) + "-----------");
		}
		
	}
	}


