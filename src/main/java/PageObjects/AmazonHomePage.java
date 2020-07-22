package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {
	
	WebDriver driver;
	public AmazonHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By searchtextbox=By.xpath("//input[@id='twotabsearchtextbox']");
	private By searchicon=By.xpath("//input[@type='submit']");
	private By mobiles=By.linkText("Mobiles");
	private By books=By.linkText("Books");
	private By loginlink=By.xpath("//a[@id='nav-link-accountList']");
	private By navbar=By.xpath("//div[@id='nav-xshop']");
	
	public WebElement getsearchTextbox()
	{
		return driver.findElement(searchtextbox);
	}
	public WebElement getMobileslink()
	{
		return driver.findElement(mobiles);
	}
	public WebElement getBookslink()
	{
		return driver.findElement(books);
	}
	public AmazonLoginPage getLoginlink()
	{
		driver.findElement(loginlink).click();
		AmazonLoginPage amzloginpage=new AmazonLoginPage(driver);
		return amzloginpage;
	}
	public WebElement getSearchicon()
	{
		return driver.findElement(searchicon);
	}
	public WebElement navigationbar()
	{
		return driver.findElement(navbar);
	}

}
