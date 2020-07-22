package PageTestCases;

import java.io.IOException;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AmazonHomePage;
import PageObjects.AmazonLoginPage;
import PageObjects.BookLinkPage;
import PageObjects.CreateAmazonAccount;
import ReuseResources.ReuseComponents;

public class BooksTestCases extends ReuseComponents{
	public WebDriver driver;
	AmazonHomePage hmpage;
  public static Logger log=LogManager.getLogger(Base64.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeBrowser();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		log.info("initialized driver with chrome browser and URL -window maximized");
	}
	
	@Test(dataProvider = "getCreds")
	public void login(String username,String password,String type) throws IOException
	{
		driver.get(prop.getProperty("URL"));
		hmpage=new AmazonHomePage(driver);
		AmazonLoginPage loginpage=hmpage.getLoginlink();
		loginpage.getEmail().sendKeys(username);
		loginpage.continueButton().click();
		log.info(type+" tried to login");
		CreateAmazonAccount createAccount=loginpage.createAccountButton();
		log.info("create account button object got created");
		createAccount.getCustomerName().sendKeys(username);
		log.info(username+" passed to create account page");
		createAccount.getContinueButton().click();
		log.info("creating new customer failed");
		
	}
	
	@Test
	public void verifyCreateButtonText()
	{
		AmazonHomePage hmpage=new AmazonHomePage(driver);
		AmazonLoginPage loginpage=hmpage.getLoginlink();
		Assert.assertEquals(loginpage.createAccountButtonText(), "Create your Amazon account");
		log.debug("create amazon account button text validated");
		
	}
	@Test
	public void selectTextbooks() throws IOException
	{
			//driver=initializeBrowser();
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
			hmpage.getBookslink().click();
			BookLinkPage bookspage=new BookLinkPage(driver);
			Actions a=new Actions(driver);
			a.moveToElement(bookspage.getBestsellers()).click().build().perform();
			log.info("clicked on best sellers tab");
			
	}
	
	@Test
	public void verifyNavigationbar()
	{
		driver.get(prop.getProperty("URL"));
		AmazonHomePage hmpage=new AmazonHomePage(driver);
		Assert.assertTrue(hmpage.navigationbar().isDisplayed());
		log.info("navigation bar on home page is displayed");
	}
	
	@DataProvider
	public Object[][] getCreds()
	{
		Object[][] creds=new Object[2][3];
		creds[0][0]="bhagyashree@isos.com";
		creds[0][1]="1234";
		creds[0][2]="not permitted user";
		
		creds[1][0]="sam@isos.com";
		creds[1][1]="djwt";
		creds[1][2]="permitted user";
		
		return creds;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("closing browser");
	}
	
}
