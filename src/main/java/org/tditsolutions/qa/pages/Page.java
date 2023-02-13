package org.tditsolutions.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.tditsolutions.qa.utils.ElementUtil;

public class Page {
    WebDriver driver;
    ElementUtil elementUtil;
    public Page(WebDriver driver){
        this.driver=driver;
        elementUtil=new ElementUtil(driver);
    }
    public boolean isAlertPresent(){
        return elementUtil.waitForAlert(5);
    }
    public String getAlertMsg(){
        Alert alert=driver.switchTo().alert();
        String msg=alert.getText();
        alert.accept();
        return msg;
    }
}
