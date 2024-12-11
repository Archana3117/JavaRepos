package registerpack;

import static org.testng.Assert.fail;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.seleniumconcepts.BaseTest;

import testNGListener.MyListener;

//@Listeners(MyListener.class)
public class CustomerRegistraion extends BaseTest {
	
	
	
	
	
	
	
	
	
	@Test(priority = 0)
	public void element() throws Exception {
		launch("Chrome");
		navigateUrl("https://www.amazon.in");
		Thread.sleep(2000);
		searchelement("//input[@id='twotabsearchtextbox']");
		
	}
	
	@Test(priority = 1,groups={"smoke","Regression"})
	  public void registerwithMandatefileds()
	  {
		  System.out.println("CustomerRegistraion - registerwithMandatefileds"+Thread.currentThread().getId());
	  }
	  
	  @Test(priority = 2,groups= {"smoke","Regression","Register","All"})
	  public void registerwithallfileds()
	  {
		  System.out.println("CustomerRegistraion - registerwithallfileds"+Thread.currentThread().getId());
	  }
	  
	  @Test(priority = 3,groups= {"sanity","Register","All"})
	  public void registerwithValidEmail()
	  {
		  System.out.println("CustomerRegistraion - registerwithValidEmail"+Thread.currentThread().getId());
		  Assert.fail("failed");
	  }
	  
	  @Test(priority = 4,groups= {"Regression","Register","All"},dependsOnMethods = "registerwithallfileds")
	  public void registerwithDuplicateEmail()
	  {
		  System.out.println("CustomerRegistraion - registerwithDuplicateEmail"+Thread.currentThread().getId());
	  }
	  
	  @AfterMethod
	  public void endProcess(ITestResult result)
	  
	  {
		  
		  if(result.getStatus()==result.FAILURE)
		  {
			  
		  }
	  }
}
