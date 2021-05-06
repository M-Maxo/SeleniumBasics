package javaScriptExecuter;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptCalls {

	ChromeDriver driver;
	
	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
	}
	
	@Test
	public void testJavaScript()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = (String) js.executeScript("return document.title");
		assertEquals("Google", title);
		System.out.println(title);
		
		long links = (Long) js
				.executeScript("var links = document.getElementsByTagName('A'); return links.length");
		System.out.println(links);
		assertEquals(19, links);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
