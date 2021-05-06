package findingElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByElements {
	
ChromeDriver driver;
	
	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com");
	}
	
	@Test
	public void findElements()
	{
		// Get all links on this webPage
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		// Print each link value 
		for(WebElement link : links) 
		{
			System.out.println(link.getAttribute("href"));
		}
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}

}
