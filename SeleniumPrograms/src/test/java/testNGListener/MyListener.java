package testNGListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.seleniumconcepts.BaseTest;

public class MyListener extends BaseTest implements ITestListener // new version of ITestListner having default methods instead
													// abstarct methods

{

	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println(testName +" started");
	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println(testName +" Success");

	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println(testName +" Failured");
		
		

	}

	public void onTestSkipped(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println(testName +" Skipped");

	}

	

	public void onTestFailedWithTimeout(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println(testName +" Timeout");
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
	
		System.out.println(context.getName() +" started");

	}

	public void onFinish(ITestContext context) {
		
		System.out.println(context.getName()+" Finished");

	}

}
