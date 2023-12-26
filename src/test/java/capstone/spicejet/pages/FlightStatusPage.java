package capstone.spicejet.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import capstone.spicejet.utils.SeWrappers;

public class FlightStatusPage extends SeWrappers {
	

	@FindBy(xpath="//div[text()='flight status']")
	WebElement fstat;
	
	@FindBy(xpath="//div[text()='Departure Date']")
	public WebElement depart;
	
	@FindBy(xpath="//div[text()='Tomorrow']")
	public WebElement day;
	
	@FindBy(xpath="//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")
	WebElement origin;
		
	@FindBy(xpath="//div[text()='Delhi']")
	WebElement cities;
	
	@FindBy(xpath="//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")
	WebElement dest;	
		
	@FindBy(xpath="//div[text()='Bengaluru']")
	WebElement cities1; 
	
	@FindBy(xpath="//div[text()='Search Flights']")
	WebElement flight;
	
	@FindBy(xpath="//div[text()='SG 8536']")
	WebElement verify;

	
	public void clicFlightStatus()
	{
		waitForElement(fstat,20);
		clickElement(fstat);
	}

	public void departure()
	{
		waitForElement(depart,20);
		clickElement(depart);
	}
	
	public void pickDay()
	{
		waitForElement(day,20);
		clickElement(day);
	}
	
	public void clicOri()
	{
		waitForElement(origin,20);
		clickElement(origin);
		
		
	}
	
	public void selecCiti()
	{
		waitForElement(cities,20);		
		clickElement(cities);
	}
	
	
		
	public void clicdest()
	{
		waitForElement(cities1,20);
		clickElement(cities1);
		
		
	}
	
	public void flightsearch()
	{
		waitForElement(flight,20);
		actionsClick(flight);
		
		
	}
	
	public void validation()
	{
		waitForElement(verify,20);
		clickElement(verify);
		if(verify.getText().equals("SG 8536"))
		{
			System.out.println("Validation Text is => "+verify.getText());
		}
	}
	
	public void exit()
	{
		closeAllBrowsers();
	}
	
}



