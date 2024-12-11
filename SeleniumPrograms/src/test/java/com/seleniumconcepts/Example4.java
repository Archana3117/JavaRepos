package com.seleniumconcepts;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example4 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@id='onwardCal']")).click(); // open the datepicker

		String year = "2024";
		String month = "Dec 2024";
		String Date = "31";
		

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		  String monthyear = driver .findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD' and contains(normalize-space(.), 'Oct 2024')]" )) .getText();
		 
       	System.out.println(monthyear);
		
		
		String monthOct = driver.findElement(By.xpath("div[@class='DayNavigator_IconBlock-qj8jdz-2 iZpveD' and contains(text(), 'Oct') and contains(text(), '2024')]")).getText();
		System.out.println(monthOct);

		//sdiv[@class='DayNavigator_IconBlock-qj8jdz-2 iZpveD' and contains(text(), 'Oct') and contains(text(), '2024')]

		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement oct2024 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DayNavigator_IconBlock-qj8jdz-2 iZpveD' and contains(text(), 'Oct') and contains(text(), '2024')]")));
//
//		System.out.println(oct2024);
		

		/*
		 * while (true) { | String monthyear=driver.findElement(By.
		 * xpath("//div[contains(@class,'DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr')]"
		 * )).getText(); System.out.println(monthyear);
		 * 
		 * 
		 * String arr[] = monthyear.split(" "); String mon = arr[0]; String yer =
		 * arr[1];
		 * 
		 * if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) break; else {
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); WebElement m
		 * = driver.findElement(By.xpath("//*[@id=\"Layer_1\"]")); m.click();
		 * 
		 * Actions act = new Actions(driver); act.moveToElement(m).
		 * click().build().perform();
		 * 
		 * 
		 * } }
		 */

		//// div[contains(@class,'DayNavigator__CalendarHeader-qj8jdz-1
		//// fxvMrr')]//*[local-name()='svg' and @data-name="Layer
		//// 1"]/*[local-name()='path']

		/*
		 * //calender is displayed boolean
		 * s=driver.findElement(By.xpath("//div[@class='sc-jzJRlG hrJoeL']")).
		 * isDisplayed(); System.out.println(s);
		 * 
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * while(!driver.findElement(By.
		 * xpath("//div[@class='sc-jzJRlG hrJoeL'] //*[@id=\\\"onwardCal\\\"]/div/div[2]/div/div/div[1]/div[2]"
		 * )).getText().contains("Dec 2024")) { driver.findElement(By.
		 * xpath("//*[@id=\"onwardCal\"]/div/div[2]/div/div/div[1]/div[2] (//*[@id=\"Layer_1\"])[2]"
		 * )).click(); }
		 * 
		 * 
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * List<WebElement>date=driver.findElements(By.
		 * xpath("(//div[@class='DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj']//span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 dkWAbH'])[22]"
		 * )); int count=date.size(); System.out.println("total no of date:"+count);
		 * 
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); for(int
		 * i=0;i<count;i++) { String day=driver.findElements(By.
		 * xpath("(//div[@class='DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj']//span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 dkWAbH'])[22]"
		 * )).get(i).getText(); if(day.equalsIgnoreCase("31")) { driver.findElements(By.
		 * xpath("(//div[@class='DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj']//span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 dkWAbH'])[22]"
		 * )).get(i).click(); } }
		 */

	}
}
