package capstone.spicejet.tets;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import capstone.spicejet.utils.Reports;
import capstone.spicejet.utils.SJwrappers;
import capstone.spicejet.utils.SeWrappers;

public class CheckinTest extends SeWrappers{
	

	SJwrappers sj  = new SJwrappers();
	Reports report = new Reports();
	
	@Parameters({"browser"})
	@Test
	public void checkin(String browserName)
	{
		try {
			report.setTCDesc("Validating the Checkin Page");
		
			launchCrossBrowser(browserName,"https://www.spicejet.com/");
			
			
			
			sj.goCheckin();	
			
			
				
		
	      }
		
		catch(Exception ex)
		{
			System.out.println("Problem while validating Checkin Page");
			ex.printStackTrace();
		}
		
	}
		
	

}



