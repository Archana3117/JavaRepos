package testNGListener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	
	private int retryCount =0;
	private static  int maxretryCount=3;
	@Override
	public boolean retry(ITestResult result) {
		
		
		
		if(retryCount<maxretryCount)
		{
			retryCount++;
			return true;
		}
		
		
		return false;
	}

}
