package capstone.spicejet.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import capstone.spicejet.utils.SeWrappers;

public class LinkVerifyPage extends SeWrappers {
	
	@FindBy(tagName="a")
	public WebElement lk;

	public void linktag(String url)
	 {
		
		
		 verifyUrl(url);
		 
		 
	 }
 
 	public void exitPag()
 	{
 		closeAllBrowsers();
 	}

	
	

}



