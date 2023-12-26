package capstone.spicejet.tets;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import capstone.spicejet.utils.Reports;
import capstone.spicejet.utils.SJwrappers;
import capstone.spicejet.utils.SeWrappers;



public class LinkVerifyTest extends SeWrappers {
	
	SJwrappers sj = new SJwrappers();
	
	Reports report = new Reports();
	
	
	@Parameters({"browser"})
	@Test	
	public void signupTest1(String browserName)
	{
		try {
			report.setTCDesc("Validating the URL to check Links Validity ");
			launchCrossBrowser(browserName,"https://www.bestbuy.com/");			    
			
			
			
			sj.linkValidation("https://www.spicejet.com/");
						
		}	
		
	      
		
catch(Exception ex)
{
	System.out.println("Problem while validating URL Links");
	ex.printStackTrace();
}
	
}


}

