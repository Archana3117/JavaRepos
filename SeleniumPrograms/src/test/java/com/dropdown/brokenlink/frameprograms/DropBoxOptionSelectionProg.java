package com.dropdown.brokenlink.frameprograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropBoxOptionSelectionProg {
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		WebElement loc=driver.findElement(By.id("//select[@id='searchDropdownBox']"));
		
		Select obj=new Select(loc);
		obj.selectByIndex(1);
		//obj.selectByValue("search-alias=amazon-devices");
		//obj.selectByVisibleText("Amazon Devices");
		
		
		Thread.sleep(2000);
		//for multiple select dropbox
		WebElement ele=obj.getFirstSelectedOption();
		System.out.println(ele.getText());
		
		List<WebElement>options=obj.getOptions();
		for(WebElement option:options)
		{
			System.out.println(option.getText());
		}
		
	}

}
