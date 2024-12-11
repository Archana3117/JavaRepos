package assertionpack;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssertionTest {
  @Test
  public void f() {
	  
	  String a="Archana";
	  String b="mahajan";
	  
	  //assertEquals(a, b);
      // assertTrue(a.equals(b), "this is not matching string");
	  
	 // assertEquals(false, false);
	  
	   //assertTrue(a.equals(b));
	  //assertTrue(a.equals(b),"both are not equal");
	  
	  
	  String c=null;
	  
	  String d=null;
	  //assertNull(c);
	  assertNotNull(d, "This is not null");
	  
	  fail(a,null);
	  
  }
}
