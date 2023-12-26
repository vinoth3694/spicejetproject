package capstone.spicejet.tets;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import capstone.spicejet.utils.Reports;
import capstone.spicejet.utils.SJwrappers;
import capstone.spicejet.utils.SeWrappers; 

public class OnewayTest extends SeWrappers {
	
	SJwrappers sj  = new SJwrappers();
	Reports report = new Reports();
	
	@Parameters({"browser"})
	@Test
	public void OneWay(String browserName)
	{
		try {
			report.setTCDesc("Validating the OneWay Trip and the Payment method");
			launchCrossBrowser(browserName,"https://www.spicejet.com/");
			
			
			
			sj.oneWaygo();	
			
			
				
		
	      }
		
		catch(Exception ex)
		{
			System.out.println("Problem while validating the OneWay Trip");
			ex.printStackTrace();
		}
		
	}
		
	

}



