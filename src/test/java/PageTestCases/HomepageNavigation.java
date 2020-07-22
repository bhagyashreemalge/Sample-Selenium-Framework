package PageTestCases;

import java.io.IOException;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.AmazonHomePage;
import ReuseResources.ReuseComponents;



public class HomepageNavigation extends ReuseComponents {
	public WebDriver driver;
	AmazonHomePage hmpage;
	public static Logger log=LogManager.getLogger(Base64.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeBrowser();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		log.info("driver initialized and browser is maximized");
	}
	
	@Test
	public void search() throws IOException
	{
		hmpage=new AmazonHomePage(driver);
		hmpage.getsearchTextbox().sendKeys("laptops");
		hmpage.getSearchicon().click();
		driver.navigate().back();
		log.info("searched for laptops");
	}
	
	@Test
	public void openHomepage() throws IOException
	{
		/*driver=initializeBrowser();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));*/
		AmazonHomePage hmpage1=new AmazonHomePage(driver);
		hmpage1.getBookslink().click();
		log.debug("clicked on books link");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("closing browser");
	}
	

}
