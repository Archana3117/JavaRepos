package suiteB;

import org.testng.annotations.Test;

public class TestB1 {
  @Test
  public void TestB1() throws Exception {
	  System.out.println("TestB1 is starting");
	  Thread.sleep(2000);
	  System.out.println("TestB1 is ending");
  }
}
