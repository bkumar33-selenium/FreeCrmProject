package TestCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.homePageEvents;
import pageEvents.loginPageEvents;

public class testCase1 extends BaseTest {
	homePageEvents strt=new homePageEvents();
	loginPageEvents entr=new loginPageEvents();
	@Test
	public void LoginTest()
	{
		strt.startup();
		entr.validateLoginPgLoaded();
		entr.login();
	}

}
