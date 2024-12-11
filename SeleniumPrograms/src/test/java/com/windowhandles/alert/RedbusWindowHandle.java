package com.windowhandles.alert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedbusWindowHandle {
	
	public static WebDriver driver;
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		String parentwindow=driver.getTitle();
		System.out.println(parentwindow);
		
		
		
		//click on all social media links facebook.instagram,twitter,linkedin
		
		driver.findElement(By.xpath("//a[@id='redbus_facebook']")).click();
		driver.findElement(By.xpath("//a[@id='redbus_linkedin']")).click();
		driver.findElement(By.xpath("//a[@id='redbus_twitter']")).click();
		driver.findElement(By.xpath("//a[@id='redbus_instagram']")).click();
		
		
		
		Set<String>handles=driver.getWindowHandles();
		List<String>hList=new ArrayList<String>(handles);
		
		
		  //how to switch on write window 
		if(switchToRightWindow("redBus | LinkedIn",hList)) 
		{ System.out.println(driver.getCurrentUrl()+":"+driver.getTitle()); }
		 
		//close all window
		
		
		  closeAllWindows(hList,parentwindow);
		  
		  
		  //switch to parent window
		  
			
			  switchToParentWindow(parentwindow);
			  System.out.println(driver.getCurrentUrl()+":"+driver.getTitle());
			 
		 
		
		
		
	}	
		
		
		//comman methods 
		public static boolean switchToRightWindow(String windowTitle,List<String> hList)
		{
			for(String e:hList)
			{
				String title=driver.switchTo().window(e).getTitle();
				if(title.contains(windowTitle))
				{
					System.out.println("found the right window");
					return true;
				}
			}
			return false;
		}
	
		//close all child windows and switch back to parent window
		
		public static void closeAllWindows(List<String>hList,String parentwindow)
		{
			for(String e:hList)
			{
				if(!e.equals(parentwindow))
				{
					driver.switchTo().window(e).close();
				}
			}
		}
		
		//switch to parent window
		public static void switchToParentWindow(String parentwindow)
		{
			driver.switchTo().window(parentwindow);
		}

}

