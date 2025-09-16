package pageEvents;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import pageObjects.loginPageObjects;
import utils.ElementsFetch;

public class loginPageEvents {
	ElementsFetch elf=new ElementsFetch();
	public void validateLoginPgLoaded()
	{
		Assert.assertTrue(elf.fetchMultipleElements("XPATH", loginPageObjects.loginbutn).size()==0, "Elements not found");
		//System.out.println(elf.fetchMultipleElements("XPATH", loginPageObjects.loginbutn).size());
		
	}
	
public void login()
{
	
	elf.fetchElements("XPATH", loginPageObjects.email).sendKeys("prashanth");
	elf.fetchElements("XPATH", loginPageObjects.password).sendKeys("prashanth");
}
}
