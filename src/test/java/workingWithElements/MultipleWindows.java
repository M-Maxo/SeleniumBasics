package workingWithElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindows {
	
	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
	}
	
	@Test(priority = 1)
	public void testWindowUsingName()
	{
		// Store parent window handle
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.id("visitbutton")).click();
		
		for(String windowId : driver.getWindowHandles())
		{
			String title = driver.switchTo().window(windowId).getTitle();
			if(title.equals("Visit Us"))
			{
				assertEquals("Visit Us", driver.getTitle());
				// here we can write any code to handle elements in visit us page
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	
	@Test(priority = 2)
	public void testWindowUsingName2()
	{
		// store parent window
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.id("helpbutton")).click();
		driver.switchTo().window("HelpWindow");
		assertEquals("Help", driver.getTitle());
		// we can write any code to handle elements in Help page
		driver.close();
		driver.switchTo().window(parentWindow);
	}

}
