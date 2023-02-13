package org.tditsolutions.qa.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    WebDriver driver;
    public WebDriver inti_driver(String browser){
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browser.equals("Edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        else {
            System.out.println("Please Pass the correct Broswer[Chrome,Edge]");
            System.exit(0);
        }
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver,5);
        return driver;
    }
}
