package testNGpack;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class OneTestOutputAsInput {
  @Test(priority=1)
  public void a(ITestContext x)    //one methos input gives another as output use ITestContext
  {
	
	  String BookingID="SIHN110110";
	  System.err.println("In A Test:"+BookingID);
	  x.setAttribute("BID", BookingID);
	  
  }
  
  @Test(priority=2)
  public void b(ITestContext x)
  {
	  System.out.println("In B Test"+x.getAttribute("BID"));
	  
  }
}
