package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonLoginPage {

	WebDriver driver;
	public AmazonLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By email=By.xpath("//input[@id='ap_email']");
	private By continueButton=By.xpath("//input[@id='continue']");
	private By createAccountButton=By.xpath("//a[@id='createAccountSubmit']");
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement continueButton()
	{
		return driver.findElement(continueButton);
	}
	
	public CreateAmazonAccount createAccountButton()
	{
		driver.findElement(createAccountButton).click();
		return new CreateAmazonAccount(driver);
		
	}
	
	public String createAccountButtonText()
	{
		return driver.findElement(createAccountButton).getText();
	}
	
}
