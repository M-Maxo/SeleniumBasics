package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickWithActions {
	
	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}
	
	@Test
	public void doubleClick()
	{
		WebElement message = driver.findElement(By.id("message"));
		//System.out.println(message.getCssValue("background-color"));
		Assert.assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color"));
		Actions builder = new Actions(driver);
		builder.doubleClick(message).perform();
		Assert.assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color"));
		//System.out.println(message.getCssValue("background-color"));		
	}

}
