package javaScriptExecuter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollToBtton {
	
ChromeDriver driver;
	
	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com/");
	}
	
	@Test
	public void testScrollToButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,4300)");
		
		WebElement lang = driver.findElement(By.cssSelector("span.icp-color-base"));
		Assert.assertEquals("English", lang.getText());
		System.out.println(lang.getText());
	}

}
