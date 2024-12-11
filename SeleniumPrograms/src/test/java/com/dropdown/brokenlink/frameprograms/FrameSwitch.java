package com.dropdown.brokenlink.frameprograms;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSwitch {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		
		//switch into the frames
		//click on the java applet frame
		driver.switchTo().frame(driver.findElement(By.name("packageListFrame")));
		driver.findElement(By.linkText("java.applet")).click();
		driver.switchTo().defaultContent();                  //go to back of the page
	
		//click on applet context
		driver.switchTo().frame(driver.findElement(By.name("packageFrame")));
		driver.findElement(By.linkText("AppletContext")).click();
		driver.switchTo().defaultContent(); 
		
		//click on 
		driver.switchTo().frame(driver.findElement(By.name("classFrame")));
		driver.findElement(By.linkText("Applet")).click();
		driver.switchTo().defaultContent(); 
	
	
	
	
	}

}
