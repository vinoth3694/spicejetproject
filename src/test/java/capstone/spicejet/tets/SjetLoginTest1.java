package capstone.spicejet.tets;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import capstone.spicejet.utils.Reports;
import capstone.spicejet.utils.SJwrappers;
import capstone.spicejet.utils.SeWrappers;

public class SjetLoginTest1 extends SeWrappers{
	
	SJwrappers sj  = new SJwrappers();
	Reports report = new Reports();
	
	@Parameters({"browser"})
	@Test
	public void loginTest(String browserName)
	{
		try {
			report.setTCDesc("Validating the Login Page with Correct Data");
			launchCrossBrowser(browserName,"https://www.spicejet.com/");
			
			
			
		
			sj.validDatalogin();
			 
			
				
		
	      }
		
		catch(Exception ex)
		{
			System.out.println("Problem while validating Login");
			ex.printStackTrace();
		}
		
	}
		
	


}


