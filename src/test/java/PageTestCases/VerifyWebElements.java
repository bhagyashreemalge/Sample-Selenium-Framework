package PageTestCases;

import java.io.IOException;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReuseResources.ReuseComponents;

public class VerifyWebElements extends ReuseComponents {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base64.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeBrowser();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		log.info("driver initialized and browser is maximized");
	}
	
	@Test(enabled=false)
	public void verifyWebElement1()
	{
		Assert.assertTrue(false);
		log.error("could not verify Element 1");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("closing browser");
	}
	

}
