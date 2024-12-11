package registerpack;

import org.testng.annotations.Test;

public class SearchOperation {
  @Test(groups= {"smoke","Regression","search","All"})
  public void searchforValidProduct() 
  {
	  
	  System.out.println("SearchOperation - searchforValidProduct"+Thread.currentThread().getId());
  }
  
  @Test(groups= {"sanity","Regression","search","All"})
  public void searchwithNoProduct()
  {
	  System.out.println("SearchOperation - searchwithNoProduct"+Thread.currentThread().getId());
  }
}
