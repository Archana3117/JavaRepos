package com.windowhandles.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ModelDilogueAlert {
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/howto_css_modals.asp");
		Thread.sleep(2000);
		WebElement modalDialog = driver.findElement(By.xpath("//button[@class='ws-btn w3-dark-grey']"));
		modalDialog.click();
		//close the model
		Thread.sleep(2000);
		modalDialog.findElement(By.xpath("//span[@class='w3-button w3-xlarge w3-display-topright w3-hover-red w3-hover-opacity']")).click(); 

	}

}
