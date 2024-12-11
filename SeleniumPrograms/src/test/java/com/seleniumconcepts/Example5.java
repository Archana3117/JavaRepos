package com.seleniumconcepts;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example5 {

	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		
		//click on pop up
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div//span[@class='sc-jlZhew inxprl']")).click();
		System.out.println("popup  is closed");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//click on down arrow 
		driver.findElement(By.xpath("//div[@class='sc-12foipm-2 eTBlJr fswFld ']//p//span[@class='sc-12foipm-8 eXKWBG fswDownArrow']")).click();
		System.out.println("date picker is open");
		
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  while(!driver.findElement(By.xpath("(//div[@class='DayPicker-Months']//div[@class='DayPicker-Caption'])[2]")). getText().contains("January 2025")); 
		  { 
			  driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")). click();
			  }
		 
		
	}
}
