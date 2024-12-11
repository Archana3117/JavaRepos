package testNGpack;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestMethodDependancy {
	
	
  @Test(priority = 1)
  public void orange() 
  {
	  
	  System.out.println("orange");
  }
  
  @Test(priority = 2,dependsOnMethods = {"orange"})
   public void white()
  {
	  System.out.println("white");
	 // Assert.fail();                        //if one tc is failed then next depends test() is skipped
	  throw new SkipException("skipped");     //if one tc is skipped then next depends case is skipped
	  
  }
  
  @Test(priority = 3,dependsOnMethods = {"white"})
  public void blue()
  {
	  System.out.println("blue");
  }
  
  @Test(priority = 4,dependsOnMethods = {"blue"},alwaysRun = true)
  public void green()
  {
	  System.out.println("green");
  }
}
