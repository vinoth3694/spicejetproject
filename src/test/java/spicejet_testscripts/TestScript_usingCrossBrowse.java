package spicejet_testscripts;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestScript_usingCrossBrowse {
	
static WebDriver driver=null;


	
	
	@BeforeMethod
	@Parameters({"browser"})
	public void launchBrowser(String browserName,String url)
	{
		
		if(browserName.equals("chrome"))
		{
			driver= new ChromeDriver();

		}
		else if (browserName.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void validateTitle()
	{
		driver.get("https://www.spicejet.com/");
		
		String parentWindow= driver.getWindowHandle();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Signup']")));
		driver.findElement(By.xpath("//div[text()='Signup']")).click();	
		
		String url =driver.getCurrentUrl();
		System.out.println("current Url is : -->"+url);
		
		Set<String> allWindows=driver.getWindowHandles();
		
		for(String eachWindow:allWindows)
		{
			
			driver.switchTo().window(eachWindow);
		}              
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@class='form-control form-select ']")));
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@class='form-control form-select ']")));
		sel.selectByVisibleText("Mr");
		//sel.selectByIndex(0);
		
		
		driver.findElement(By.id("first_name")).sendKeys("Vignesh");
		
		driver.findElement(By.id("last_name")).sendKeys("Palanisamy");
		
		WebElement date = driver.findElement(By.xpath("//img[@class='d-inline-block datepicker']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(date).build().perform();
		act.click(date);
		
		Select sel1 = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		sel.selectByValue("1998");
		
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		sel2.selectByIndex(10);
		
		//driver.switchTo().window(parentWindow);

		
		
	}

}



