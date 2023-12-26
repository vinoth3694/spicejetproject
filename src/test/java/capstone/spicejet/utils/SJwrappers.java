package capstone.spicejet.utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import capstone.spicejet.pages.CheckinPage;
import capstone.spicejet.pages.FlightStatusPage;
import capstone.spicejet.pages.LinkVerifyPage;
import capstone.spicejet.pages.ManageBookingPage;
import capstone.spicejet.pages.OnewayPage;
import capstone.spicejet.pages.RoundtripPage;
import capstone.spicejet.pages.SJetSignupPages;
import capstone.spicejet.pages.SjetLoginPage1;
import capstone.spicejet.pages.SjetLoginPage2;

public class SJwrappers extends SeWrappers {
	
	public void linkValidation(String url)
	{
		LinkVerifyPage lp = PageFactory.initElements(driver, LinkVerifyPage.class);
		
		lp.linktag(url);
		lp.exitPag();
		
	}
	
	public void signUP() throws InterruptedException
	{
		SJetSignupPages sj = PageFactory.initElements(driver, SJetSignupPages.class);
		
		sj.clicSignup();
		sj.optSelect("Mr");
		sj.fnane("Vinoth");
		sj.lname("vino");
		sj.selDate();
		sj.mobText("7010264094");
		sj.mailidSignup("vinothvino716@gmail.com");
		sj.newPasswd("@Vinoth123");
		sj.confirmpass("@Vinoth123");
		sj.termsBox();
		sj.clicSubmit();
		captureScreenshot("Signup-ValidData");
		sj.clicExit();
	}
	
	public void invalidDatalogin() 
	{
		SjetLoginPage1 sj = PageFactory.initElements(driver, SjetLoginPage1.class);
	
		sj.clicLogin();
		sj.number("70123asdff");
		sj.password("@Vinoth123");
		sj.clicSubmit();
		captureScreenshot("Login-InvalidData");		
		sj.exit();
	}
	
	public void validDatalogin() 
	{
		SjetLoginPage2 sj = PageFactory.initElements(driver, SjetLoginPage2.class);
	
		sj.clicLogin();
		sj.number("7010264094");
		sj.password("@Vinoth123");
		sj.clicSubmit();
		sj.validation();
		captureScreenshot("Login-ValidData");	
		sj.exit();
	}
	
	public void oneWaygo() 
	{
		OnewayPage op = PageFactory.initElements(driver, OnewayPage.class);
	
		op.clicOri();
		
		op.selecCiti();
		op.clicdest();
		op.clicDate1();	
		op.flightsearch();
		captureScreenshot("Oneway-Flightsearch");	
		op.searchAgain();
		op.name1("Vinoth");
		op.name2("vino");
		op.number("7010264094");
		op.email("vinothvino716@gmail.com");
		op.entName(200, "vinoth");
		op.entName1("p");
		op.nummber2("7010264094");
		op.clicContinu();
		op.clicContinu1(30);
		op.skipEle();
		op.clicContinu2(30);
		op.switchFrame(500);
		op.cardNum("1221322345558778");
		op.switchFrame1();;
		op.cardName("shakthi");
		op.switchFrame2();
		op.month("06");
		op.switchFrame3();
		op.year("28");
		op.switchFrame4();
		op.securityCode("098");
		op.proceedToPay(300);
			
		op.validation();
		captureScreenshot("ClickPayment-OneWay");
		op.exitone();
		
			
	}
	
	public void roundTripgo() 
	{
		RoundtripPage op = PageFactory.initElements(driver, RoundtripPage.class);
	
		op.clicOri();
		
		op.selecCiti();
		op.clicdest();
		op.clicDate1();
		op.selDate();
		op.clicDate2();
		op.flightsearch();
		captureScreenshot("RoundTrip-Flightsearch");	
		op.searchAgain();
		op.name1("Vinoth");
		op.name2("vino");
		op.number("7010264094");
		op.email("shakthivinoth455@gmail.com");
		op.entName(400, "vinesh");
		op.entName1("p");
		op.nummber2("7010264094");
		op.clicContinu();
		op.clicContinu1(30);
		op.skipEle();
		op.clicContinu2(30);
		op.switchFrame(500);
		op.cardNum("1221322345558778");
		op.switchFrame1();
		op.cardName("shakthi");
		op.switchFrame2();
		op.month("06");
		op.switchFrame3();
		op.year("28");
		op.switchFrame4();
		op.securityCode("098");
		op.proceedToPay(300);
			
		op.validation();
		captureScreenshot("ClickPayment-RoundTrip");
		op.exitone();
	}
	
	public void goCheckin() throws InterruptedException
	{
		CheckinPage cp = PageFactory.initElements(driver, CheckinPage.class);
		
		cp.checkIN();
		cp.ticNum("CCQU7Q");
		cp.email("vinothvino716gmail.com");
		cp.goSearch();
		cp.validation();
		captureScreenshot("Checkin");
		cp.exit();
	}
	
	public void flightStatus()
	{
		FlightStatusPage fs = PageFactory.initElements(driver, FlightStatusPage.class);
		
		fs.clicFlightStatus();
		fs.departure();
		fs.pickDay();
		fs.clicOri();
		fs.selecCiti();
		fs.clicdest();		
		fs.flightsearch();
		fs.validation();
		captureScreenshot("FlightStatus");
		fs.exit();
	}
	
	
	public void goBooking() throws InterruptedException
	{
		ManageBookingPage mb = PageFactory.initElements(driver, ManageBookingPage.class);
		
		mb.manBooking();
		mb.ticNum("CCQU7Q");
		mb.email("vinothvino716@gmail.com");
		mb.searBooking();
		mb.validate();
		captureScreenshot("ManageBooking");
		mb.exit();
	}
	
}



