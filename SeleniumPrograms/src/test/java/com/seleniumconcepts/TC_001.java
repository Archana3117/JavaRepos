package com.seleniumconcepts;

public class TC_001 extends BaseTest 
{
public static void main(String[] args) throws Exception {
	
	launch("chrome");
	
	navigateUrl("https://www.amazon.in/");
	
	driver.manage().window().maximize();
	
	//title of the page
	String title = driver.getTitle();
	System.out.println(title);
	
	//url of the page
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
	
	
	String pageSource = driver.getPageSource();
	System.out.println(pageSource);
	
	driver.manage().deleteAllCookies();
	
	Thread.sleep(4000);
	driver.navigate().back();
	
	Thread.sleep(4000);
	driver.navigate().forward();
	
	
	
	Thread.sleep(4000);
	driver.navigate().refresh();
	
	//driver.close();
	
	driver.quit();
}

}
