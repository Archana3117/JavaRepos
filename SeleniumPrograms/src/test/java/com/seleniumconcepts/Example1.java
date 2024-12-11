package com.seleniumconcepts;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Example1 {
	
	public static void main(String[] args) throws Exception {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();
		
		//count of total rows
		List<WebElement>rows=driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
	    int rowdata=rows.size();
	    System.out.println("no of rows count:"+rowdata);
	    
	    //count of columns
	    List<WebElement>colmtotalcount=driver.findElements(By.xpath("//table[@class='dataTable']//thead//tr//th"));
	    int coldata=colmtotalcount.size();
	    System.out.println("no of colums:"+coldata);
	    	
	    ArrayList<Integer> a=new ArrayList<Integer>();
	  
	   for(int i=1;i<=rowdata;i++)
	   {
		   String loc = "//table[@class='dataTable']/tbody/tr["+i+"]/td[4]";
			String cPrice = driver.findElement(By.xpath(loc)).getText();
			System.out.println(cPrice);
			
			
			   NumberFormat intno=NumberFormat.getIntegerInstance(); //convert string to int
			
			   Number n=intno.parse(cPrice);
	           String price=n.toString();   //int to string
	           Double dprice=Double.parseDouble(price);
	           
	           int iprice=dprice.intValue();
	           
	   }
	  Collections.sort(a);
	  System.out.println();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		/*
		 * try { double currentprice=Double.parseDouble(curentpriice.replace(",",""));
		 * 
		 * if (currentprice > mxcurrentprice) { mxcurrentprice = currentprice;
		 * ComapnyofMaxCurrentPrice = companyName; } } catch (Exception e) {
		 * 
		 * System.out.println(curentpriice); }
		 * 
		 * System.out.println(ComapnyofMaxCurrentPrice);
		 * System.out.println(mxcurrentprice);
		 */
		 
	    
	    
	    }
	    
	    
}    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
