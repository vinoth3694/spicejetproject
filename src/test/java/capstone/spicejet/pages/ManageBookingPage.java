package capstone.spicejet.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import capstone.spicejet.utils.SeWrappers;

public class ManageBookingPage extends SeWrappers {
	
	@FindBy(xpath="//div[@data-testid='manage booking-horizontal-nav-tabs']")
	WebElement manage;

	@FindBy(xpath="//input[@autocomplete='new-password']")
	public WebElement ticket;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	public WebElement mail;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73 r-13qz1uu']")
	public WebElement sear;
	
	
	public void manBooking()
	{
		waitForElement(manage,30);
		clickElement(manage);
		
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
	
	public void searBooking() throws InterruptedException
	{
		waitForElement(sear,20);
		actionsClick(sear);
		Thread.sleep(3000);
	}
	
	public void validate()
	{
		System.out.println("Search Failed");
	}
	
	public void exit()
	{
		closeAllBrowsers();
	}
	
}



