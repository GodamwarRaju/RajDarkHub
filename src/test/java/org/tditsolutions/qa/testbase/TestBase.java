package org.tditsolutions.qa.testbase;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.tditsolutions.qa.driverfactory.DriverFactory;
import org.tditsolutions.qa.pages.HomePage;
import org.tditsolutions.qa.pages.LoginPage;
import org.tditsolutions.qa.utils.PropConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
protected WebDriver driver;
protected LoginPage loginPage;
protected HomePage homePage;
protected Properties prop;

 DriverFactory df;
 PropConfig propConfig;
  //  @Parameters(value = {"EnvName"})
	@BeforeMethod
	public void beforeMethod()
	{

		System.out.println(System.getProperty("EnvName"));
		String env = System.getProperty("EnvName");
		propConfig =PropConfig.getInstance();
		try {
			prop = propConfig.load_prop(env);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		df = new DriverFactory();
		driver=	df.inti_driver(prop.getProperty("browser"));

		driver.get(prop.getProperty("app_url"));
		System.out.println(driver);
		loginPage = new LoginPage(driver);
		homePage=new HomePage(driver);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
}
