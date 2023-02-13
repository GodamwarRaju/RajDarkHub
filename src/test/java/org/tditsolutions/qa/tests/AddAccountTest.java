package org.tditsolutions.qa.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tditsolutions.qa.dataprovider.DataProviderClass;
import org.tditsolutions.qa.pages.AddAccountPage;
import org.tditsolutions.qa.pages.HomePage;
import org.tditsolutions.qa.testbase.TestBase;
import org.tditsolutions.qa.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAccountTest extends TestBase {
    @Test
    public void verify_add_account_page_title()
    {
        HomePage homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        AddAccountPage addAccPage = homePage.openAddAccount();
        String actual = addAccPage.getTitle();
        Assert.assertEquals(actual, Constants.EXPECTED_HEADER_OF_ADD_ACCOUNT_PAGE);
    }

    @Test(dataProvider = "createAccount",dataProviderClass = DataProviderClass.class)
    public void verify_create_account(String accName ,String accNum,String found)
    {
        HomePage homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        AddAccountPage addAccPage = homePage.openAddAccount();

        addAccPage.addAccount(accName, (int )Double.parseDouble(accNum), (int )Double.parseDouble(found));
        boolean isAlertDisplayed = addAccPage.isAlertPresent();
        Assert.assertEquals(isAlertDisplayed, true);
        String alertMsg = addAccPage.getAlertMsg();
        Assert.assertEquals(alertMsg, Constants.EXPECTED_ALERT_MAG_OF_ADD_ACCOUNT_PAGE);
    }

    @Test
    public void verify_Account_Number_With_Alpha()
    {
        HomePage homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        AddAccountPage addAccPage = homePage.openAddAccount();
        addAccPage.addAccountNumber("ABC");
        String actual = addAccPage.getAccountNumber();
        Assert.assertEquals(actual, "");

    }

    @Test
    public void verify_Account_Number_With_Numeric()
    {
        HomePage homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        AddAccountPage addAccPage = homePage.openAddAccount();
        addAccPage.addAccountNumber("123");
        String actual = addAccPage.getAccountNumber();
        Assert.assertEquals(actual, "123");
    }
    @Test
    public void verify_AccountNumber_with_negative_amount()
    {
        HomePage homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        AddAccountPage addAccPage = homePage.openAddAccount();
        addAccPage.addAccount("test134352", -874846, 6734);
        String actualMsg=addAccPage.getAccountNumberValidationMag();
        Assert.assertEquals(actualMsg,Constants.EXPECTED_VALIDATION_MSG);
    }
    @Test
    public void verify_Home_Button(){
        HomePage homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        AddAccountPage addAccPage = homePage.openAddAccount();
        homePage=addAccPage.goToHomePage();
        String actualTitle=homePage.getHeaderTitle();
        Assert.assertEquals(actualTitle,Constants.HOME_PAGE_TITLE);
    }
}
