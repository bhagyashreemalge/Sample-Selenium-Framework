package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAmazonAccount {

	WebDriver driver;
	
	public CreateAmazonAccount(WebDriver driver) {
		this.driver=driver;
	}
	
	private By customerName=By.cssSelector("input[id='ap_customer_name']");
	private By customerEmail=By.cssSelector("input[id='ap_email']");
	private By continueButton=By.cssSelector("input[id='continue']");
	
	public WebElement getCustomerName()
	{
		return driver.findElement(customerName);
	}
	
	public WebElement getCustomerEmail()
	{
		return driver.findElement(customerEmail);
	}

	public WebElement getContinueButton() {
		// TODO Auto-generated method stub
		return driver.findElement(continueButton);
	}
	
}
