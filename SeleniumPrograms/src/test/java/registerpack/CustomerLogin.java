package registerpack;

import org.testng.annotations.Test;

public class CustomerLogin {
	
	@Test(groups= {"smoke","login"})
	public void loginWithvalidCredentials()
	{
		System.out.println("CustomerLogin - loginWithvalidCredentials "+Thread.currentThread().getId());
	}
	
	@Test(groups= {"smoke","Regression","login","All"})
	public void loginWithInvalidCredentials()
	{
		System.out.println("CustomerLogin - loginWithInvalidCredentials "+Thread.currentThread().getId());
	}
	
	@Test(groups= {"sanity","login","All","Regression"})
	public void loginWithValidUser()
	{
		System.out.println("CustomerLogin - loginWithValidUser "+Thread.currentThread().getId());
	}
	
	@Test(groups= {"Regression","login","All"})
	public void loginWithInvalidUser()
	{
		System.out.println("CustomerLogin - loginWithInvalidUser "+Thread.currentThread().getId());
	}
  
}
