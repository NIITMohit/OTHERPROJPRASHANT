package Test;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import Pages.LogoutPage;
import Utilities.WindowsCapabilitie;

public class Logout extends WindowsCapabilitie {
	
	@Test
	public void logout() throws InterruptedException{
	
	service.start();
		
	/*RemoteWebElement profile_dropdown =	driver.findElementByAccessibilityId("LandingNavProfileDropDownArrow");
	profile_dropdown.click();
	
	RemoteWebElement logout =	driver.findElementByAccessibilityId("lblLogout");
	logout.click();*/
	
	LogoutPage lp = new LogoutPage(driver);
	
	lp.logoutDropdown();
	
	lp.logout();
	
	Thread.sleep(2000);
	
	
	}
	

}
