package capstone.spicejet.tets;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import capstone.spicejet.utils.Reports;
import capstone.spicejet.utils.SJwrappers;
import capstone.spicejet.utils.SeWrappers;

public class FlightStatusTest extends SeWrappers {
	

	SJwrappers sj  = new SJwrappers();
	Reports report = new Reports();
	
	@Parameters({"browser"})
	@Test
	public void checkin(String browserName)
	{
		try {
			report.setTCDesc("Validating the Flight status Page to find the Status of My flight");
			launchCrossBrowser(browserName,"https://www.spicejet.com/");
			
			
			
			sj.flightStatus();
			
			
				
		
	      }
		
		catch(Exception ex)
		{
			System.out.println("Problem while validating Flight Status Page");
			ex.printStackTrace();
		}
		
	}
		
	

}


