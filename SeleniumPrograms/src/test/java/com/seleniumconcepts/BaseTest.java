package com.seleniumconcepts;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static Properties p;
	public static Properties mainpro;
	public static Properties childpro;
	public static Properties orpro;
	
	public static WebDriver driver;
	public static File f;
	public static FileInputStream fis;
	public static ExtentReports report;
	public static ExtentTest test;

	
	
	
	
	
	
	public static void launch(String browserType)
	{
		if(browserType.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserType.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		
	}	
		public static void navigateUrl(String url)
		{
			driver.get(url);      //ebery time it goes to server and then launch 
			//driver.navigate().to(url);  //only first time goes to server and then lunch after that next time it used to catche 
		}
	
	
	
	
	public  void init(String browserType)throws Exception
	{
	     f=new File(".\\src\\test\\resources\\data.properties");
	     fis=new FileInputStream(f);
	     p=new Properties();
	     p.load(fis);
	     
	     
	     f=new File(".\\src\\test\\resources\\environment.properties");
	     fis=new FileInputStream(f);
	     mainpro=new Properties();
	     mainpro.load(fis);
	     String e=mainpro.getProperty("env");
	     System.out.println(e);
	     
	     
	     f=new File(".\\src\\test\\resources\\prod.properties");
	     fis=new FileInputStream(f);
	     childpro=new Properties();
	     childpro.load(fis);;
	     String val=childpro.getProperty("amazonurl");
	     System.out.println(val);
	     
	     f=new File(".\\src\\test\\resources\\or.properties");
	     fis=new FileInputStream(f);
	     orpro=new Properties();
	     orpro.load(fis);
	     
	     f=new File("\\src\\test\\resources\\or.properties");
         fis=new FileInputStream(f);
         orpro.load(fis);
         
         f=new File(".\\src\\test\\resources\\log4jconfig.properties");
         fis=new FileInputStream(f);
         PropertyConfigurator.configure(fis);
         
         
         
         report= ExtentManager.getInstance();
         test=report.createTest(cName());
         test.log(Status.INFO, "init the properties files");
         test.log(Status.INFO, "Launched the browser:"+browserType);
         
	     
	}
	
	public String cName()
	{
		return this.getClass().getSimpleName();
	}
	
	public static void clickElement(String locatorKey) 
	{
		getLocator(locatorKey).click();
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
	}

	public static void typeText(String locatorKey, String text) 
	{
		getLocator(locatorKey).sendKeys(text);
		//driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
	}

	public static void selectDropDown(String locatorKey, String option)
	{
		getLocator(locatorKey).sendKeys(option);
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
	}


	public static By locator(String element)

	
	{
		By by = null;
		
		if(element.endsWith("_id")) {
			by = By.id(orpro.getProperty(element));
		}else if (element.endsWith("_name")) {
			by = By.name(orpro.getProperty(element));
		}else if (element.endsWith("_classname")) {
			by = By.className(orpro.getProperty(element));
		}else if (element.endsWith("_xpath")) {
			by = By.xpath(orpro.getProperty(element));
		}else if (element.endsWith("_css")) {
			by = By.cssSelector(orpro.getProperty(element));
		}else if (element.endsWith("_linktext")) {
			by = By.linkText(orpro.getProperty(element));
		}else if (element.endsWith("_partiallinktext")) {
			by = By.partialLinkText(orpro.getProperty(element));
		}
		
		return by;
		
	}
	
	
	
	public static WebElement getLocator(String locatorKey) 
	{
		WebElement element = null;
		
		if(!isElementPresent(locatorKey))
			System.out.println("Element is not present :  "+ locatorKey);
		
		element = driver.findElement(locator(locatorKey));
		
		/*if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}*/
		return element;
	}
	
	
	public static boolean isElementPresent(String locatorKey) 
	{
		
		try 
		{
			WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			Wait.until(ExpectedConditions.presenceOfElementLocated(locator(locatorKey)));
			
			/*if(locatorKey.endsWith("_id")) {
				Wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.getProperty(locatorKey))));
			}else if (locatorKey.endsWith("_name")) {
				Wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.getProperty(locatorKey))));
			}else if (locatorKey.endsWith("_classname")) {
				Wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.getProperty(locatorKey))));
			}else if (locatorKey.endsWith("_xpath")) {
				Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.getProperty(locatorKey))));
			}else if (locatorKey.endsWith("_css")) {
				Wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.getProperty(locatorKey))));
			}else if (locatorKey.endsWith("_linktext")) {
				Wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.getProperty(locatorKey))));
			}else if (locatorKey.endsWith("_partiallinktext")) {
				Wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orProp.getProperty(locatorKey))));
			}*/
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
		
		
	}
	
	public static void takesScreenshot(WebElement element) throws Exception
	{
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		
		//searchelement(element, driver);
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(scrFile, new File(System.getProperty("user.dir")+"//failurescreenshots//"+dateFormat));
		
		test.log(Status.INFO,"Screenshot --->" +test.addScreenCaptureFromPath(System.getProperty("user.dir")+"//failurescreenshots//"+dateFormat));
	}

	public static WebElement searchelement(String locatorkey)
	{
		WebElement element=null;
		return element=driver.findElement(locator(locatorkey));
	}
}
