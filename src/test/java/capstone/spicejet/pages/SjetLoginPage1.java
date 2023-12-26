package capstone.spicejet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import capstone.spicejet.utils.SeWrappers;

public class SjetLoginPage1 extends SeWrappers{
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement button1;
	
	@FindBy(xpath="//input[@type='number']")
	WebElement  num;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement pass;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement login;
	
	@FindBy(xpath="//div[text()='Hi Vinoth']")
	WebElement verify;
	
	public void clicLogin()
	{
		waitForElement(button1,20);
		clickElement(button1);
		
	}
	
	public void number(String text)
	{
		waitForElement(num,20);
		typeText(num,text);
		
	}
	
	public void password(String text)
	{
		waitForElement(pass,20);
		typeText(pass,text);
		
	}	
	
	
	public void clicSubmit()
	{
		waitForElement(login,20);
		clickElement(login);
		
	}
	
	public void validation()
	{
		waitForElement(verify,20);
		if(verify.getText().equals("Hi Vinoth"))
		{
			System.out.println("The Validation Text name is : "+verify.getText());
		}else
		{
			System.out.println("Error in Login Data's.");
		}
		
	}
	
	public void exit()
	{
		closeAllBrowsers();
	}


}


