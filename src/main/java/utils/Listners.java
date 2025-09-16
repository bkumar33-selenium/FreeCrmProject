package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import base.BaseTest;

public class Listners implements ITestListener,IAnnotationTransformer{
	
	public void onTestFailure(ITestResult result)
	{
		//TakesScreenshot screenshot=(TakesScreenshot)BaseTest.driver;
		//File scr=screenshot.getScreenshotAs(OutputType.FILE)+System.getProperty("user.dir")+"//ScreenShots//Failure.png";
		String filename=System.getProperty("user.dir")+"//ScreenShots//Failure.png";
		File ssfile=((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		File f=new File(filename);
		try {
			FileUtils.copyFile(ssfile, f);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	  public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		   annotation.setRetryAnalyzer(RetryTestMethod.class);
		  }
}
