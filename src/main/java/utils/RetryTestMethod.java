package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestMethod implements IRetryAnalyzer {
	int rcount=0;
	int maxRcount=1;
	
	public boolean retry(ITestResult result) {
		
		if(rcount<maxRcount)
		{
		 rcount++;
		 return true;
		}
		else {
		return false;}
	}

}
