package capstone.spicejet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import capstone.spicejet.utils.SeWrappers;

public class SJetSignupPages extends SeWrappers {
	
	@FindBy(xpath="//div[text()='Signup']")
	WebElement button;
	
	@FindBy(xpath="//select[@class='form-control form-select ']")  
	WebElement option;
	
	@FindBy(id="first_name")
	WebElement fname;
	
	@FindBy(id="last_name")
	WebElement lname;
	
	@FindBy(id="dobDate")
	WebElement date;
	
	@FindBy(xpath="//div[text()='12']")
	WebElement day;
	
	@FindBy(id="email_id")
	WebElement mail;
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement phone;
	
	@FindBy(xpath="//label[text()='About']")
	WebElement scroll;
	
	@FindBy(id="new-password")
	WebElement pass1;
	
	@FindBy(id="c-password")
	WebElement pass2;
	
	@FindBy(xpath ="//input[@class='form-check-input mt-02']")
	WebElement box;
	
	@FindBy(xpath ="//button[text()='Submit']")
	WebElement submit;
	
	public void clicSignup()
	{
		//waitForElement(button,20);		
		windowHandlingParentWindow(button);
		
		
	}
	
	public void optSelect(String visibleText)
	{
		
		waitForElement(option,20);
		actionsClick(option);
		selectByVisibleText(option,visibleText);
	}
	
	public void fnane(String text) throws InterruptedException
	{
		Thread.sleep(3000);
		waitForElement(fname,20);
		typeText(fname,text);
	}
	
	public void lname(String text)
	{
		waitForElement(lname,20);
		typeText(lname,text);
		
		
	}
	
	public void selDate() {	
		
		waitForElement(date,20);
		clickElement(date);
		actionsClick(day);

		System.out.print("Date is Successfully selected");
		
		
	
		
	}
	
	
	public void mobText( String text)
	{
		//javascriptExecutorScrollToWebelement(scrollDownValue);
		waitForElement(phone,20);
		typeText(phone,text);
		javascriptExecutorClickWebElement(scroll);
		
	}
	
	public void mailidSignup(String text)
	{
		waitForElement(mail,20);
		typeText(mail,text);
	}
	
	public void newPasswd(String text)
	{
		waitForElement(pass1,20);
		typeText(pass1,text);
	}
	
	public void confirmpass(String text) throws InterruptedException
	{
		waitForElement(pass2,20);
		typeText(pass2,text);
		Thread.sleep(2000);
		
	}
	
	public void termsBox() throws InterruptedException
	{
		
		waitForElement(box,30);
		Thread.sleep(3000);
		clickElement(box);
		if(box.isSelected()) {
			System.out.println("The Tick Box is Selected");
		}
		else {
			System.out.println("The Tick Box is not selected");
		}
		Thread.sleep(3000);
	}
	
	public void clicSubmit()
	{
		waitForElement(submit,30);
		actionsClick(submit);
		
	}
	
	public void clicExit() throws InterruptedException
	{
		javascriptExecutorStartingContent();
		Thread.sleep(5000);
		closeAllBrowsers();
	}
	
	
	
	

}


