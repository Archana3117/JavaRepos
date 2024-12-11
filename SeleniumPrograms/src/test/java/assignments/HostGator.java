package assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumconcepts.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HostGator extends BaseTest {

	// WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		launch("Chrome");
		navigateUrl("https://www.hostgator.in/dedicated-servers-windows.php");
		System.out.println("HostGator is succssfully opened");
	}
	

	
	@Test
	
	public void m() throws Exception
	{
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		// scroll in mid
		js.executeScript("document.getElementById('web-hosting-plans').scrollIntoView()");

		Thread.sleep(2000);

		List<WebElement> plans = driver.findElements(By.xpath("//div[@class='container white']//form"));
		int plan=plans.size();
		System.out.println(plan);
		
		 
		
		js.executeScript("window.scrollBy(0,300)");
		
		/*
		 * for(int i=0;i<plans.size();i++) { String text=plans.get(i).getText();
		 * System.out.println("each text is:"+text+"....");
		 * 
		 * 
		 * }
		 */
		List<WebElement>  buttonstotal=driver.findElements(By.xpath("//div[@class='btn-group']"));
		   int btnsize=buttonstotal.size();
			System.out.println(btnsize);
			
			
		
		   for(int j=0;j<=btnsize;j++)
			{
			   ArrayList a=new ArrayList();
			//   btnsize.add(a[j]);
				//System.out.println("total buttons:"+t);
			}
		/*
		 * if(text.contains("Win-Pro")) {
		 * 
		 * 
		 * 
		 * WebElement dropdown = driver.findElement(By.xpath(
		 * "//*[@id=\"hostingplan_462_in\"]/div/div[2]/div[1]/button"));
		 * dropdown.click();
		 * 
		 * System.out.println("cliked on  dropdown");
		 * 
		 * 
		 * 
		 * wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * wait.until(ExpectedConditions .elementToBeClickable(By.xpath(
		 * "//*[@id=\"hostingplan_462_in\"]/div/div[2]/div[1]/button")));
		 * 
		 * WebElement updateddropdown = driver .findElement(By.xpath(
		 * "//*[@id=\"hostingplan_462_in\"]/div/div[2]/div[1]/button"));
		 * updateddropdown.click(); System.out.println("after clkied on dropdown ");
		 * 
		 * // select duration of plan 3 months driver.findElement(By.
		 * xpath("(//ul[@class='dropdown-menu block-level'])[3]//li[3]//a")).click();
		 * 
		 * //driver.findElement(By.xpath("//*[@id='463']")).click();
		 * System.out.println("passed"); }
		 * 
		 * }
		 */
		
	}
	
	
	

	@Test(enabled=false)
	public void selectHostingPlans() throws Exception {

		 //driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']")).click();

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		// scroll in mid
		js.executeScript("document.getElementById('web-hosting-plans').scrollIntoView()");

		Thread.sleep(2000);

		List<WebElement> plans = driver.findElements(By.xpath("//div[@class='container white']//form"));
		System.out.println(plans.size());
		js.executeScript("window.scrollBy(0,300)");

		for (WebElement e : plans) {
			
			

			if (e.getText().contains("Win-Pro")) {
				
				

				wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				// find the dropdown

				WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"hostingplan_462_in\"]/div/div[2]/div[1]/button"));
				dropdown.click();

				System.out.println("cliked on WIn-Elite dropdown");

				wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"hostingplan_462_in\"]/div/div[2]/div[1]/button")));

				WebElement updateddropdown = driver
						.findElement(By.xpath("//*[@id=\"hostingplan_462_in\"]/div/div[2]/div[1]/button"));
				updateddropdown.click();
				System.out.println("after clkied on dropdown ");

				// select duration of plan 3 months
				driver.findElement(By.xpath("(//ul[@class='dropdown-menu block-level'])[3]//li[3]//a")).click();

				// click on sign up button
				/*
				 * driver.findElement(By.xpath(
				 * "//div[@class='row plan-footer']//div[@class='col-xs-6 col-sm-12 col-md-12 col-lg-12']//a[@id='462']"
				 * )) .click();
				 */
				System.out.println("successfully signed up on HostGator page...");
			} 
			

		}

	}
}
