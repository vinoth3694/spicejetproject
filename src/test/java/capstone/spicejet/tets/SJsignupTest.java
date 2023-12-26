package capstone.spicejet.tets;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import capstone.spicejet.utils.Reports;
import capstone.spicejet.utils.SJwrappers;
import capstone.spicejet.utils.SeWrappers;

public class SJsignupTest extends SeWrappers {
	
	SJwrappers sj  = new SJwrappers();
	Reports report = new Reports();
	
	@Parameters({"browser"})
	@Test
	public void signupTest(String browserName)
	{
		try {
			report.setTCDesc("Validating the SignUp Page with Incorrect and Correct Data");
			launchCrossBrowser(browserName,"https://www.spicejet.com/");
			
			
			
			sj.signUP();	
			
			
				
		
	      }
		
	
	catch(Exception ex)
	{
		System.out.println("Problem while validating Signup");
		ex.printStackTrace();
	}
	
}

}



