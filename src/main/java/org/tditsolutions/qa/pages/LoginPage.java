package org.tditsolutions.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tditsolutions.qa.utils.ElementUtil;

public class LoginPage {

    //Page Elements

    By username = By.name("username");

    By password = By.name("password");

    By loginButton = By.className("login_button");

    By header = By.tagName("h1");


    //WebDriver
    WebDriver driver;
    ElementUtil elementUtil;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil=new ElementUtil(driver);
    }


    //Page Actions

    public HomePage doLogin(String user, String pass) {
        elementUtil.enterText(username,user);
        elementUtil.enterText(password,pass);
        elementUtil.click(loginButton);
//        driver.findElement(username).sendKeys(user);
//        driver.findElement(password).sendKeys(pass);
//        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }


    public String getLoginPageHeader() {
//        return driver.findElement(header).getText();
        String loginPageheader=elementUtil.getText(header);
        return loginPageheader;
    }

    public boolean isAlertPresent()
    {
        return  elementUtil.waitForAlert(5);
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        try {
//            wait.until(ExpectedConditions.alertIsPresent());
//            return true;
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//            return false;
//        }
    }

    public String getAlertMessage()
    {
        return elementUtil.getAlertText();
//        Alert alert = driver.switchTo().alert();
//        String msg = alert.getText();
//        alert.accept();
//        return msg;
    }

}
