package org.tditsolutions.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tditsolutions.qa.utils.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    By sideBarHeaders= By.xpath("//div[@class=\"sidenav\"]/center/h3");
    By viewTrade = By.xpath("//a[text()='View Trade']");
    By buyTrade = By.xpath("//a[text()='Buy Trade']");
    By sellTrade = By.xpath("//a[text()='Sell Trade']");
    By addAccount = By.xpath("//a[text()='Add Account']");
    By updateAccount = By.xpath("//a[text()='Update Account']");
    By deleteAccount = By.xpath("//a[text()='Delete Account']");
    By addSecurity = By.xpath("//a[text()='Add Security']");
    By updateSecurity = By.xpath("//a[text()='Update security']");
    By deleteSecurity = By.xpath("//a[text()='Delete security']");
    By linkName=By.xpath("//div/a");

    By welcomeMsg=By.xpath("//h3[contains(text(),'Welcome')]");
    By headerTitle=By.tagName("h2");
    WebDriver driver;
    ElementUtil elementUtil;
    public HomePage(WebDriver driver){
        this.driver=driver;
        elementUtil =new ElementUtil(driver);
    }
    //To verify the SideBarWelcome Msg
    public String getWelcomeMsg() {
         String text= elementUtil.presenceOfElementAndGetText(welcomeMsg,5);
         return text;
//        WebDriverWait wait=new WebDriverWait(driver,5);
//        try{
//            wait.until(ExpectedConditions.presenceOfElementLocated(welcomeMsg));
//            return driver.findElement(welcomeMsg).getText();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return "Page is Not load";
//        }
    }

    public String  getHeaderTitle() {
        return elementUtil.presenceOfElementAndGetText(headerTitle,5);
//        WebDriverWait wait=new WebDriverWait(driver,5);
//        try{
//            wait.until(ExpectedConditions.presenceOfElementLocated(headerTitle));
//            return driver.findElement(headerTitle).getText();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return " ";
//        }
    }
    //Getting  the List of actual sideBarHeader Link text
    public List<String> getSideBarHeaders(){
        return elementUtil.getListOFAllElementText(sideBarHeaders);
//        List<WebElement> list=driver.findElements(sideBarHeaders);
//        List<String> headerList=new ArrayList<String>();
//        for (WebElement e:list){
//            headerList.add(e.getText());
//        }
//        return headerList;
    }
    //Getting the List of actual sidebar LinkName
    public List<String> getLinkName(){
        return elementUtil.getListOFAllElementText(linkName);
//        List <WebElement> list=driver.findElements(linkName);
//        List<String> actualLinkText=new ArrayList<String>();
//        for (WebElement e:list){
//            actualLinkText.add(e.getText());
//        }
//        return actualLinkText;
    }
    public AddAccountPage openAddAccount()
    {
        elementUtil.click(addAccount);
        return new AddAccountPage(driver);
    }
}
