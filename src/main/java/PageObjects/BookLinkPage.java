package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookLinkPage {

	
	WebDriver driver;
	public BookLinkPage(WebDriver driver) {
		this.driver=driver;
	}
	private By bestsellers=By.linkText("Best Sellers");
	private By textbooks=By.linkText("Textbooks");
	
	public WebElement getBestsellers()
	{
		return driver.findElement(bestsellers);
	}
	public WebElement getTextbooks()
	{
		return driver.findElement(textbooks);
	}
	
}
