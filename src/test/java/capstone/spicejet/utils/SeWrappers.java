package capstone.spicejet.utils;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;







public class SeWrappers {
	

	public static WebDriver driver=null;


	//method to launch the chrome browser with the given url
		public void norlaunchBrowser(String url)
		{
			try
			{
				driver= new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println("Browser launched successfully");
				
				//to capture logs in the report
				Reports.reportStep("PASS","Chrome browser launched successfully");

			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while launching the browser");

				System.out.println("Problem while launching the browser");
				ex.printStackTrace();

			}
		}
		
		//Launchbrowser with CrossBrowsing
		public void launchCrossBrowser(String browserName, String url)
		{
			try {
				 
			
			if(browserName.equals("chrome"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");

				 driver = new ChromeDriver(options);

			}
			else if (browserName.equals("edge"))
			{
				driver= new EdgeDriver();
			}
			else if(browserName.equals("headlesschrome"))
			{
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--headless");

				 driver = new ChromeDriver(opt);
			}
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			System.out.println("Browser launched successfully");
			Reports.reportStep("PASS","Chrome  and Edge browser launched successfully");
			
		}
		catch(Exception ex)
		{

			Reports.reportStep("FAIL","Problem while launching Chrome and Edge browser");

			System.out.println("Problem while launching the browser");
			ex.printStackTrace();

		}
	}
		
		// Listing Links
		 public void verifyUrl(String linkUrl)
		  {
			 
					
			
		        try 
		        {
		           URL url = new URL(linkUrl);
		           
		           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
		           
		           httpURLConnect.setConnectTimeout(3000);
		           
		           httpURLConnect.connect();
		           
		           if(httpURLConnect.getResponseCode()==200)
		           {
		               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
		            }
		          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
		           {
		               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
		            }
		        } catch (Exception e) {
		           
		        }    
				}
		  
	//method to close the current browser window
	public void closeCurrentBrowser()
	{
		try
		{
			driver.close();
			Reports.reportStep("PASS","Current browser window closed successfully");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while closing the current browser");
			ex.printStackTrace();
		}
	}

	//method to close all the browsers
	public void closeAllBrowsers()
	{
		try
		{
			driver.quit();
			Reports.reportStep("PASS","All browsers closed successfully");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while closing the browsers");

		}
	}

	//method to type text in the web page
	public void typeText(WebElement element, String text)
	{
		try
		{
			element.clear();
			element.sendKeys(text);
			Reports.reportStep("PASS","Typed the text "+text+" successfully");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem whle typing the "+text);

			ex.printStackTrace();
		}
	}
	
	//method to type text in the web page Without Using Clear 
		public void typeTextwithoutClear(WebElement element, String text)
		{
			try
			{
				element.sendKeys(text);
				Reports.reportStep("PASS","Typed the text "+text+" successfully");

			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem whle typing the "+text);

				ex.printStackTrace();
			}
		}
	
	//Type Text with EnterKey
	public void keysEnter(WebElement element, String text)
	{
		try
		{
			element.clear();
			element.sendKeys(text, Keys.ENTER);
			Reports.reportStep("PASS","Typed the text "+text+" and clicked the ENTER Key successfully");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem whle typing the "+text);

			ex.printStackTrace();
		}
	}

	//method to click on the webelement in the web page
	public void clickElement(WebElement ele)
	{
		try
		{
			ele.click();
			Reports.reportStep("PASS","Successfully clicked the element");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while clicking the element");

			ex.printStackTrace();
		}
	}

	//Select dropdown - by Index

	public void selectByindex(WebElement ele, int index)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByIndex(index);
			Reports.reportStep("PASS","Successfully selected the value based on index");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while selecting the value based on index");

			ex.printStackTrace();
		}
	}


	//Select dropdown - By value

	public void selectByValue(WebElement ele, String value)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByValue(value);
			Reports.reportStep("PASS","Successfully Selected the value based on value");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while selecting the value");
			ex.printStackTrace();
			
		}
	}

	//Select dropdown - By Visibletext

	public void selectByVisibleText(WebElement ele, String visibleText)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByVisibleText(visibleText);
			Reports.reportStep("PASS","Successfully selected the value using visibleText");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while selecting visibleText");
			ex.printStackTrace();
		}
	}
	
	

	//Explicit wait

	public void waitForElement(WebElement ele, int timeout)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(ele));
			Reports.reportStep("PASS","Successfully waited for the element using explicit wait ");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while waiting for the element");

			ex.printStackTrace();
		}
	}

// Clickable Element Wait
	public void waitForClickElement(WebElement ele, int timeout)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			Reports.reportStep("PASS","Successfully waited for the element using explicit wait ");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while waiting for the element");

			ex.printStackTrace();
		}
	}
	//fluent wait

	public void fluentWaitForElement(WebElement ele, int pollingFrequency,  int timeout)
	{
		try
		{
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.pollingEvery(Duration.ofSeconds(pollingFrequency))
					.withTimeout(Duration.ofSeconds(timeout));

			wait.until(ExpectedConditions.visibilityOf(ele));
			Reports.reportStep("PASS","Successfully waited for the element using explicit wait");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while waiting for the element");
			ex.printStackTrace();
		}
	}


	//action class - click, doubliclick, contextclick,
	
	
	public void actionsDoubleClick(WebElement ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.doubleClick(ele).build().perform();
			Reports.reportStep("PASS","Successfully performed the doubleClick action");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while performing doubleClick action");
			ex.printStackTrace();;
		}
	}
	
	public void actionsRightClick(WebElement ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.contextClick(ele).build().perform();
			Reports.reportStep("PASS","Successfully performed the contextClick action");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while performing contextClick action");
			ex.printStackTrace();
		}
	}
	
	public void actionsMoveToElement(WebElement ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			Reports.reportStep("PASS","Successfully performed moveToElement action");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while performing moveToElement action");
			ex.printStackTrace();
		}
	}
	
	
	public void actionsDragAndDrop(WebElement source,WebElement target)
	{
		try
		{
			Actions action = new Actions(driver);
			action.dragAndDrop(source,target).build().perform();
			Reports.reportStep("PASS","Successfully performed dragAndDrop action");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while performing dragAndDrop action");
			ex.printStackTrace();
		}
	}
	
	public void actionsClick(WebElement ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.click(ele).build().perform();
			Reports.reportStep("PASS","Successfully performed the click action");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while performing click action");
			ex.printStackTrace();
		}
	}
	
	//SwitchTo Frames by Index
	public void selectFrameByIndex(int index)
	{
		try
		{
			driver.switchTo().frame(index);
			Reports.reportStep("PASS","Successfully switched to the frame based on index");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while switching to the frame");
			ex.printStackTrace();
		}
	}
	
	//SwitchTo Frames by Id
	public void selectFrameByNameOrId(String nameId)
	{
		try
		{
			driver.switchTo().frame(nameId);
			Reports.reportStep("PASS","Successfully switched to the frame based on nameId");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while switching to the frame");
			ex.printStackTrace();
		}
	}
	
	//SwitchTo Frame by WebElemet
	public void selectFrameByWebElement(WebElement ele)
	{
		try
		{
			driver.switchTo().frame(ele);
			Reports.reportStep("PASS","Successfully switched to the frame based on WebElement");
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while switching to the frame");
			ex.printStackTrace();
		}
	}

	//Windowhandling --> 
	public void windowHandlingParentWindow(WebElement ele)
	{
		try
		{

			String parentWindow= driver.getWindowHandle();
			
			ele.click();
			
			Set<String> allWindows = driver.getWindowHandles();
			
			for(String eachWindow:allWindows)
			{
				driver.switchTo().window(eachWindow);
			}
			Reports.reportStep("PASS","Successfully switched to the child Window");

		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem while Switching to the child Window");
			ex.printStackTrace();
		}
	}
		
		public void windowHandlingSwitchParentWindow()
		{
			try
			{
				
				String parentWindow= driver.getWindowHandle();

				driver.switchTo().window(parentWindow);
				Reports.reportStep("PASS","Successfully switched to the Parent Window");

			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Switching to the Parent Window");
				ex.printStackTrace();
			}
		}
		
		public void windowHandlingDefaultContent(String parentWindow)
		{
			try
			{

				driver.switchTo().defaultContent();
				Reports.reportStep("PASS","Successfully switched to the Default content");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Switching to the Default content");
				ex.printStackTrace();
			}
		}
		
		

		//JavascriptExecutor --> click, scrollUp, scrollDown , write for all actions we have seen
		
		//To ScrollDown - Method 1
		public void javascriptExecutorScrollVertical(int scrolldownValue)
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;

				//To ScrollDown
				js.executeScript("window.scrollBy(0,"+scrolldownValue+");");
				Reports.reportStep("PASS","Successfully Scrolled to the ScrollDownValue "+scrolldownValue);
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Scrolling to the ScrollDownValue "+scrolldownValue);
				ex.printStackTrace();
			}
		}
		
		
		
		///////ScrollTo Downward - method 2
		public void javascriptExecutorScrollToWebelement(int scrollDownValue)
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;

				//To ScrollDown to the WebElement
				js.executeScript("window.scrollTo(0,"+scrollDownValue+");");
				Reports.reportStep("PASS","Successfully Scrolled to the ScrollDownValue "+scrollDownValue);
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Scrolling to the ScrollDownValue "+scrollDownValue);
				ex.printStackTrace();
			}
		}
		
		//To ScrollUp
		
			public void javascriptExecutorScrollHorizontal(int scrollupValue)
			{
				try
				{
					JavascriptExecutor js = (JavascriptExecutor)driver;

					
					js.executeScript("window.scrollBy("+scrollupValue+",0);");
					Reports.reportStep("PASS","Successfully Scrolled to the ScrollUpValue "+scrollupValue);
				}
				catch(Exception ex)
				{
					Reports.reportStep("FAIL","Problem while Scrolling to the ScrollUpValue "+scrollupValue);
					ex.printStackTrace();
				}
			}
			
		
			
			
		//To ScrollDown to the End of the Content
		
		public void javascriptExecutorEndContent()
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;

				//To ScrollDown to the End of the Content
				js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
				Reports.reportStep("PASS","Successfully Scrolled to the End of the Content");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Scrolling to the End of the Cotent");
				ex.printStackTrace();
			}
		}
		
		//To ScrollUp to the Starting of the Content
		
		public void javascriptExecutorStartingContent()
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;

				//To ScrollUp to the Starting of the Content
				js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
				Reports.reportStep("PASS","Successfully Scrolled to the Starting Content");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Scrolling to the Starting Cotent");
				ex.printStackTrace();
			}
		}
		
		//Scroll Right
		
		public void javascriptExecutorScrollRight()
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;

				//To ScrollRight to the End of the Content
				js.executeScript("window.scrollTo(document.body.scrollWidth,0);");
				Reports.reportStep("PASS","Successfully Scrolled to the End of the Content");

			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Scrolling to the End of the Cotent");
				ex.printStackTrace();
			}
		}

		//Print Title
		public void javascriptExecutorTitle()
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;

				//Getting the Title 
				System.out.print(js.executeScript("return document.title;"));
				Reports.reportStep("PASS","Successfully Returned the Document Title");

			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Returning the Document Title");
				ex.printStackTrace();
			}
		}
		
		public void javascriptExecutorScrollWebElement(WebElement ele)
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;

				//to scroll until a particular webElement

				js.executeScript("arguments[0].scrollIntoView(true);",ele);
				Reports.reportStep("PASS","Successfully Scrolled to the Mentioned WebElement");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Scrolling to the Mentioned WebElement");
				ex.printStackTrace();
			}
		}

		
		public void javascriptExecutorClickWebElement(WebElement ele)
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;

				//to click on a particular webElement

				js.executeScript("arguments[0].click();", ele);
				Reports.reportStep("PASS","Successfully Clicked the Particular WebElement");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Clicking the Particular WebElement");
				ex.printStackTrace();
			}
		}

		
		public void javascriptExecutorTypeText(WebElement ele, String value)
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;

				//type in text in a input box

				js.executeScript("arguments[0].value='"+value+"';", ele);
				Reports.reportStep("PASS","Successfully Typed Text in the Input Box");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Typing Text in the Input Box");
				ex.printStackTrace();
			}
		}
		
		
		public void acceptAlert()
		{
			try
			{
				Alert alert=driver.switchTo().alert();
				alert.accept();
				Reports.reportStep("PASS","Successfully Accepted the Alert");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Accepting the Alert");
				ex.printStackTrace();
			}
		}
		
		public void getTextAlert()
		{
			try
			{
				Alert alert=driver.switchTo().alert();
				alert.getText();
				System.out.println(alert.getText());
				Reports.reportStep("PASS","Successfully got the text");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while getting the Text");
				ex.printStackTrace();
			}
		}
		
		
		public void dismissAlert()
		{
			try
			{
				Alert alert=driver.switchTo().alert();
				alert.dismiss();
				Reports.reportStep("PASS","Successfully Dismissed the Alert");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Dismissing the Alert");
				ex.printStackTrace();
			}
		}
		
		public void typeInAlert(String value)
		{
			try
			{
				Alert alert=driver.switchTo().alert();
				alert.sendKeys(value);
				Reports.reportStep("PASS","Successfully Passed on Value to the Alert");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Passing Value to the Alert");
				ex.printStackTrace();
			}
		}
		
		
		public boolean verifySelected(WebElement ele)
		{
			boolean retVal=false;
			try
			{
				if(ele.isSelected())
				{
					retVal=true;
				}
				Reports.reportStep("PASS","Successfully Selected the WebElement");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while selecting the WebElement");
				ex.printStackTrace();
			}
			return retVal;
		}
		
		//To Check Whether the Element is Displayed or Not
		public boolean verifyDisplayed(WebElement ele)
		{
			boolean retVal=false;
			try
			{
				if(ele.isDisplayed())
				{
					retVal=true;
				}
				Reports.reportStep("PASS","Successfully Displayed the WebElement");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Displaying the WebElement");
				ex.printStackTrace();
			}
			return retVal;
		}
		
		public boolean verifyEnabled(WebElement ele)
		{
			boolean retVal=false;
			try
			{
				if(ele.isEnabled())
				{
					retVal=true;
				}
				Reports.reportStep("PASS","Successfully Enabled the WebElement");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Enabling the WebElement");
				ex.printStackTrace();
			}
			return retVal;
		}
		
		//takes the screenshot of a specific page
		public void captureScreenshot(String screenshotName)
		{
			try
			{
				File src=( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dest= new File(System.getProperty("user.dir")+"/screenshots/"+screenshotName+".png");
				FileUtils.copyFile(src, dest);
				Reports.reportStep("PASS","Successfully Captured the File");
			}
			catch(Exception ex)
			{
				Reports.reportStep("FAIL","Problem while Capturing the File");
				ex.printStackTrace();
			}
			
		}
		
}



