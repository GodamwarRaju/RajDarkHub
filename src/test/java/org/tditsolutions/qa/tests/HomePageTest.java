package org.tditsolutions.qa.tests;

import org.tditsolutions.qa.pages.HomePage;
import org.tditsolutions.qa.testbase.TestBase;
import org.tditsolutions.qa.utils.Util;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.tditsolutions.qa.utils.Constants.EXPECTED_SIDE_BAR_HEADERS_HOME_PAGE;
import static org.tditsolutions.qa.utils.Constants.EXPECTED_SIDE_BAR_LINK_TEXT_HOME_PAGE;

public class HomePageTest extends TestBase {
    @Test
    public void verify_Sidebar_Headers(){
        //go to homePage
        HomePage homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        //getting  the actual Header List
         List<String> actualList=homePage.getSideBarHeaders();
        //getting  the expected Header List
        List<String> expectedList=EXPECTED_SIDE_BAR_HEADERS_HOME_PAGE;
        SoftAssert softAssert= Util.compareList(actualList,expectedList);
        softAssert.assertAll();
    }
    //To verify the Link Text present in Home Page
    @Test
    public void Verify_Link_Text(){
        HomePage homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        //getting the actualLinkText
        List<String>actualLinkText=homePage.getLinkName();
        //getting the expected link Text
        List<String> expectedLinkText=EXPECTED_SIDE_BAR_LINK_TEXT_HOME_PAGE;
        SoftAssert softAssert=Util.compareList(actualLinkText,expectedLinkText);
        softAssert.assertAll();
    }

}
