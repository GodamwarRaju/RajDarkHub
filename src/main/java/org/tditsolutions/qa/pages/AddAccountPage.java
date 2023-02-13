package org.tditsolutions.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tditsolutions.qa.utils.ElementUtil;

public class AddAccountPage extends Page{
    WebDriver driver;
    ElementUtil elementUtil;

    By accName = By.name("aname");
    By accNumber= By.name("anumber");
    By accFun = By.name("afund");
    By addAccountBtn = By.name("register");
    By homeButton = By.tagName("a");
    By addAccountPageTitle = By.tagName("h2");

    public AddAccountPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
        this.driver= driver;
        elementUtil = new ElementUtil(driver);

    }


    public String getTitle()
    {
        return elementUtil.getText(addAccountPageTitle);
    }

    public void addAccount(String name, int number, int fund)
    {
        elementUtil.enterText(accName, name);
        elementUtil.enterText(accNumber, String.valueOf(number));
        elementUtil.enterText(accFun, String.valueOf(fund));
        elementUtil.click(addAccountBtn);
    }

    public void addAccountNumber(String number)
    {
        elementUtil.enterText(accNumber, number);
    }

    public String getAccountNumber()
    {
        return  elementUtil.getAttributeValue(accNumber,"value");
    }

    public HomePage goToHomePage()
    {
        elementUtil.click(homeButton);
        return new HomePage(driver);
    }
   public String  getAccountNumberValidationMag(){
        String validationMsg=elementUtil.getAttributeValue(accNumber,"validationMessage");
        return validationMsg;
   }


}
