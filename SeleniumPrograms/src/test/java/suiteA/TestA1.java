package suiteA;

import org.testng.annotations.Test;

public class TestA1 {
  @Test
  public void TestA1() throws Exception {
	  
	  System.out.println("TestA1 is starting");
	  Thread.sleep(2000);
	  System.out.println("TestA1 is ending");
  }
}
