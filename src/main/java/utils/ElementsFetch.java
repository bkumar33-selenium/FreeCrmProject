package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ElementsFetch {

	public WebElement fetchElements(String locater,String value)
	{
	switch(locater)
	{
	case "XPATH":
		return BaseTest.driver.findElement(By.xpath(value));
	case "ID": 
		return BaseTest.driver.findElement(By.xpath(value));
	default :
	return null;
	}
	
	}
	
	public List<WebElement> fetchMultipleElements(String locater,String value)
	{
	switch(locater)
	{
	case "XPATH":
		return BaseTest.driver.findElements(By.xpath(value));
	case "ID": 
		return BaseTest.driver.findElements(By.xpath(value));
	default :
	return null;
	}
	
	}
}
