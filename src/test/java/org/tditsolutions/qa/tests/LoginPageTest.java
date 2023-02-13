package org.tditsolutions.qa.tests;

import org.tditsolutions.qa.pages.HomePage;
import org.tditsolutions.qa.pages.LoginPage;
import org.tditsolutions.qa.testbase.TestBase;
import org.tditsolutions.qa.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
	
	
	@Test
	public void verify_loginPage_Header()
	{
		String actual = loginPage.getLoginPageHeader();
		Assert.assertEquals(actual, Constants.LOGIN_PAGE_HEADER);
	}

	@Test
	public void verify_Incorrect_Login(){
		//Enter a invalid credentials
		loginPage.doLogin("Raju","techfin12");
		//verify the alert popup display
		boolean actual =loginPage.isAlertPresent();
		Assert.assertEquals(actual,true,"Incorrect Credentials Popup is not displayed");
		//verify the msg display on popup
		String  alertMsg=loginPage.getAlertMessage();
		Assert.assertEquals(alertMsg,Constants.INCORRECT_LOGIN_MESSAGE);
	}
	@Test
	public void verify_Correct_Login()
	{
		//Enter correct credentials
		HomePage homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

		//Verify HomePage Header
		String actualHeader = homePage.getHeaderTitle();
		Assert.assertEquals(actualHeader, Constants.HOME_PAGE_TITLE);

		//Verify Welcome Message;
		String actualMsg = homePage.getWelcomeMsg();
		String expectedMsg = "Welcome " + "sump1";
		Assert.assertEquals(actualMsg, expectedMsg);

	}


}
