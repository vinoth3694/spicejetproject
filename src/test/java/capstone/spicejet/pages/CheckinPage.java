package capstone.spicejet.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import capstone.spicejet.utils.SeWrappers;



public class CheckinPage extends SeWrappers {
	
	@FindBy(xpath="//div[text()='check-in']")
	public WebElement click;
	
	@FindBy(xpath="//input[@autocomplete='new-password']")
	public WebElement ticket;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	public WebElement mail;
	
	@FindBy(xpath="//div[text()='Search Booking']")
	public WebElement search;
	
		
	public void checkIN()
	{
		waitForElement(click,30);
		actionsClick(click);
		
	}

	public void ticNum(String text)
	{
		waitForElement(ticket,20);
		typeText(ticket,text);
	}
	
	public void email(String text)
	{
		waitForElement(mail,20);
		typeText(mail,text);
	}
	
	public void goSearch() throws InterruptedException
	{
		waitForElement(search,20);
		actionsClick(search);
	
		Thread.sleep(3000);
	}
	
	public void validation()
	{
		
		System.out.println("Unable to fetch booking Details. Please check the inputs provided and try again.");
		
	}
	
	public void exit()
	{
		closeAllBrowsers();
	}

}



