package pageEvents;

import pageObjects.HomePageObjects;
import utils.ElementsFetch;

public class homePageEvents {
	public void startup()
	{
		ElementsFetch el=new ElementsFetch();
		el.fetchElements("XPATH", HomePageObjects.startup).click();
	}

}
