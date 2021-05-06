package waits;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fluent {
	
	/* Fluent Wait: Let’s say you have an element which sometime appears in just 1 second and some time
	 * it takes minutes to appear. In that case it is better to use fluent wait,
	 * as this will try to find element again and again 
	 * until it find it or until the final timer runs out.*/
	
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
	public void testFluentWait()
	{
		driver.findElement(By.linkText("Page 4")).click();
		
		Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement message = Fwait.until(new Function<WebDriver , WebElement>()
		{
			public WebElement apply(WebDriver d) 
			{
				return d.findElement(By.id("page4"));
			} 
		});
		assertTrue(message.getText().contains("Nunc nibh tortor"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
