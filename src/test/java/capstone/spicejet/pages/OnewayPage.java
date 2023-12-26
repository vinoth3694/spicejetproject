package capstone.spicejet.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import capstone.spicejet.utils.SeWrappers;

public class OnewayPage extends SeWrappers{
	
	@FindBy(xpath="//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")
	WebElement origin;
		
	@FindBy(xpath="//div[text()='Delhi']")
	WebElement cities;
	
	@FindBy(xpath="//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu']")
	WebElement dest;
	
	@FindBy(xpath="//div[text()='Bengaluru']")
	WebElement cities1;
	
	@FindBy(xpath="//div[text()='13']")
	WebElement date1;
	
		
	@FindBy(xpath="//div[text()='Search Flight']")
	WebElement flight;
	
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']")
	WebElement search;
	

	@FindBy(xpath="//input[@data-testid='first-inputbox-contact-details']")
	WebElement fname;
	

	@FindBy(xpath="//input[@data-testid='last-inputbox-contact-details']")
	WebElement lname;
	

	@FindBy(xpath="//input[@data-testid='contact-number-input-box']")
	WebElement num;
	

	@FindBy(xpath="//input[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement mail;
	

	@FindBy(xpath="//input[@data-testid='traveller-0-first-traveller-info-input-box']")
	WebElement name1;
	
	@FindBy(xpath="//input[@data-testid='traveller-0-last-traveller-info-input-box']")
	WebElement name2;
	
	@FindBy(xpath="//input[@data-testid='sc-member-mobile-number-input-box']")
	WebElement num1;
	

	@FindBy(xpath="//div[text()='Continue']")
	WebElement continue1;		
		
	@FindBy(xpath="(//div[@data-testid='add-ons-continue-footer-button'])[3]")
	WebElement continue2;

	@FindBy(id="skipfrompopup")
	WebElement skip;
	
	@FindBy(xpath="(//div[@data-testid='add-ons-continue-footer-button'])[3]")
	WebElement continue3;
	
	@FindBy(xpath="//iframe[@class='card_number_iframe']")
	WebElement frame;
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement card;
	
	@FindBy(xpath="//iframe[@class='name_on_card_iframe']")
	WebElement frame1;
	
	@FindBy(xpath="//input[@placeholder='Cardholder Name']")
	WebElement cname;
	
	@FindBy(xpath="//iframe[@class='card_exp_month_iframe']")
	WebElement frame2;
	
	@FindBy(id="card_exp_month")
	WebElement month;
	
	@FindBy(xpath="//iframe[@class='card_exp_year_iframe']")
	WebElement frame3;
	
	@FindBy(id="card_exp_year")
	WebElement yr;
	
	@FindBy(xpath="//iframe[@class='security_code_iframe']")
	WebElement frame4;
	
	@FindBy(id="security_code")
	WebElement code;
	
	@FindBy(xpath="//div[@data-testid='common-proceed-to-pay']")
	WebElement proceed;
	
	@FindBy(xpath="//div[text()='Payment Failed']")
	WebElement verify;
		
		
	
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
	
	public void clicDate1()
	{
		waitForElement(date1,20);
		clickElement(date1);
		
		
	}
	
	public void flightsearch()
	{
		waitForElement(flight,20);
		actionsDoubleClick(flight);
		//actionsClick(flight);
		
		if(flight.isDisplayed())
		{
			System.out .println("Flight Search button is Clicked");
		}
		
		
	}
	
	public void searchAgain()
	{
		waitForElement(search,20);
		clickElement(search);
		
	}
	
	public void name1(String text)
	{
		waitForElement(fname,20);
		typeText(fname,text);
		
	}
	
	public void name2(String text)
	{
		waitForElement(lname,20);
		typeText(lname,text);
		
	}
	
	public void number(String text)
	{
		waitForElement(num,20);
		typeText(num,text);
		
	}
	
	public void email(String text)
	{
		waitForElement(mail,20);
		typeText(mail,text);
		
	}
	
	public void entName(int scrollDownValue,String text)
	{
		javascriptExecutorScrollToWebelement(scrollDownValue);
		waitForElement(name1,20);
		typeText(name1,text);
		
	}
	
	public void entName1(String text)
	{
		
		waitForElement(name2,20);
		typeText(name2,text);
		
	}
	
	public void nummber2(String text)
	{
		
		waitForElement(num1,20);
		typeText(num1,text);
		
	}
	
	public void clicContinu()
	{
		waitForElement(continue1,20);
		actionsClick(continue1);
		
	}
		
	
/*	public void popup()
	{
		waitForElement(book1,20);
		actionsClick(book1);
		
	}
	*/
	
	public void clicContinu1(int timeout)
	{
		//waitForElement(continue2,20);
		waitForClickElement(continue2,timeout);
		clickElement(continue2);
		
	}
	

	public void skipEle()
	{
		waitForElement(skip,20);
		clickElement(skip);
		
	}
	
	public void clicContinu2(int timeout)
	{
		waitForElement(continue3,20);
		waitForClickElement(continue3,timeout);
		
	}
	
	public void switchFrame(int scrollDownValue)
	{
		javascriptExecutorScrollToWebelement(scrollDownValue);
		selectFrameByWebElement(frame);
		
	}
	
	public void cardNum(String text)
	{		
		
		waitForElement(card,20);
		
		typeText(card,text);
		driver.switchTo().defaultContent();
		
	}
	
	public void switchFrame1()
	{
		
		selectFrameByWebElement(frame1);
		
	}
	
	
	public void cardName(String text)
	{
		
		waitForElement(cname,20);		
		typeText(cname,text);
		
		driver.switchTo().defaultContent();
		
	}
	
	public void switchFrame2()
	{
		
		selectFrameByWebElement(frame2);
		
	}
	
	public void month(String text)
	{
		
		waitForElement(month,20);
		clickElement(month);
		typeText(month,text);
		
		driver.switchTo().defaultContent();
		
	}
	
	public void switchFrame3()
	{
		
		selectFrameByWebElement(frame3);
		
	}
	
	public void year(String text)
	{
		
		waitForElement(yr,20);
		clickElement(yr);
		typeText(yr,text);
		
		driver.switchTo().defaultContent();
		
	}
	
	public void switchFrame4()
	{
		
		selectFrameByWebElement(frame4);
		
	}
	
	public void securityCode(String text)
	{
		
		waitForElement(code,20);
		clickElement(code);
		typeText(code,text);
		
		driver.switchTo().defaultContent();
		
	}
	
	public void proceedToPay(int scrollDownValue)
	{
		javascriptExecutorScrollToWebelement(scrollDownValue);
		waitForElement(proceed,20);
		actionsClick(proceed);
		
	}
	
	public void validation()
	{
		if(verify.getText().equals("Payment Failed"))
		{
			System.out.println("While Clicking the Proceed to Pay button it says, "+verify.getText());
		}
			
	}
	
	public void exitone()
	{
		closeAllBrowsers();		
	}

}



