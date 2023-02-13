package org.tditsolutions.qa.utils;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ElementUtil {
    WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(By locator, String userId) {
        System.out.println("Inside the enterText Method");
        System.out.println("Locator :"+locator);
        System.out.println("UserID :"+userId);
        driver.findElement(locator).sendKeys(userId);
    }

    public void click(By locator) {
        System.out.println("Inside the Click Method");
        System.out.println("Locator :"+locator);
        driver.findElement(locator).click();
        System.out.println("Clicked on Element ");
    }

    public String getText(By locator) {
        System.out.println("Inside the getText Method");
        System.out.println("Locator :"+locator);
        String text = driver.findElement(locator).getText();
        System.out.println("Text present for Element : "+text);
        return text;
    }

    //wait methods
    public boolean presenceOfElement(By locator, int time) {
        System.out.println("Inside the presenceOfElement method ");
        System.out.println("Locator:"+locator);
        System.out.println("Wait for "+time+" Sec");
        boolean flag = false;
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }
    }

    public String presenceOfElementAndGetText(By locator, int time) {
        System.out.println("Inside the presenceOfElementAndGetText method ");
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            String text=this.getText(locator);
            System.out.println("Text = "+text);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    //Alert Method
    public boolean waitForAlert(int time) {
        System.out.println("Inside the WaitForAlert Method ");
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            boolean flag=true;
            System.out.println("IsAlert is present :"+flag);
            return flag;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            boolean flag=false;
            System.out.println("IsAlert is present :"+flag);
            return false;
        }
    }
    public String getAlertText(){
        System.out.println("Inside the getAlert Method ");
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        System.out.println("Alert Text :"+msg);
        alert.accept();
        System.out.println("Accept the Alert");
        return msg;
    }

    //List method
    public List<WebElement> getAllElementLocatedBy(By locator){
        System.out.println("Inside the getAllElementLocatedBy method ");
        List<WebElement> list=driver.findElements(locator);
        System.out.println("List of Element ="+list);
        return list;
    }

    public String getText(WebElement element) {
        System.out.println("Inside the getText ");
        System.out.println("WebElement element="+element);;
        String text=element.getText();
        System.out.println("Text present for Element :"+text);
        return text;

    }

    public List<String> getListOFAllElementText(By locator) {
        System.out.println("Inside the getListOFAllElementText method");
        List<WebElement> list = this.getAllElementLocatedBy(locator);
        List<String> headerList = new ArrayList<String>();
        for (WebElement e : list) {
            String text=this.getText(e);
            headerList.add(text);
            System.out.println(text+" ,");
        }
        return headerList;
    }
    public String getAttributeValue(By locator,String value){
        System.out.println("Inside the getAttributeValue method");
        String validationMsg=driver.findElement(locator).getAttribute(value);
        System.out.println("Validation Message : "+validationMsg);
        return validationMsg;
    }

}

