package capstone.spicejet.tets;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import capstone.spicejet.utils.Reports;
import capstone.spicejet.utils.SJwrappers;
import capstone.spicejet.utils.SeWrappers;

public class RoundtripTest extends SeWrappers {
	
	SJwrappers sj  = new SJwrappers();
	Reports report = new Reports();
	
	@Parameters({"browser"})
	@Test
	public void roundTrip(String browserName)
	{
		try {
			report.setTCDesc("Validating the RoundTrip Test Scenario");
			launchCrossBrowser(browserName,"https://www.spicejet.com/");
			
			
			
			sj.roundTripgo();
			
			
				
		
	      }
		
		catch(Exception ex)
		{
			System.out.println("Problem while validating Roundtrip");
			ex.printStackTrace();
		}
		
	}
		
	

}



