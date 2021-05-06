package waits;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Implicit {
	
	/*  Implicit Wait: During Implicit wait if the Web Driver cannot find it immediately because
	 *  of its availability, it will keep polling (around 250 milli seconds) 
	 *  the DOM to get the element. 
	 *  If the element is not available within the specified Time an NoSuchElementException will be raised.
	 *  The default setting is zero. Once we set a time, 
	 *  the Web Driver waits for the period of the WebDriver object instance. */
	
	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
	}
	@Test
	public void testImplicitWait()
	{
		// set implicit wait time to 20 sec
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Page 4")).click();
		WebElement message = driver.findElement(By.id("page4"));
		assertTrue(message.getText().contains("Nunc nibh tortor"));
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
