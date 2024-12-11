package testNGpack;

import java.util.Arrays;

import org.testng.TestNG;


public class RunSuiteParallel {
  public static void main(String[] args) {
	
	  
	  TestNG obj=new TestNG();   //we can run suite at parallel then use testng object
	  obj.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//megasuite.xml"}));
	  obj.setSuiteThreadPoolSize(2);    //parallel 
	  obj.run();
}
}
