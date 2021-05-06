package waits;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Explicit {
	
	
	
	/* Explicit Wait: There can be instance when a particular element takes more than a minute to load.
	 * In that case you definitely not like to set a huge time to Implicit wait,
	 * as if you do this your browser will going to wait for the same time for every element.
	 * To avoid that situation you can simply put a separate time on the required element only.
	 * By following this your browser implicit wait time would be short for every element 
	 * and it would be large for specific element.*/
	
	
	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.google.com");
	}
	
	@Test
	public void testExplicitWait()
	{
		WebElement queryTxt = driver.findElement(By.name("q"));
		queryTxt.sendKeys("Selenium WebDriver");
		queryTxt.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Selenium"));
		assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
