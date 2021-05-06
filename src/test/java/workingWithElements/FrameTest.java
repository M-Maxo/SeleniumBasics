package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest {
	
	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");
	}

	@Test
	public void testFrameExample()
	{
		driver.switchTo().frame("left");
		WebElement msg = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This is Left Frame", msg.getText());
		System.out.println(msg.getText());
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("right");
		WebElement msg2 = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This is Right Frame", msg2.getText());
		System.out.println(msg2.getText());
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		WebElement msg3 = driver.findElement(By.tagName("p"));
		Assert.assertEquals("This Frame doesn't have id or name", msg3.getText());
		System.out.println(msg3.getText());
		driver.switchTo().defaultContent();
	}
	

}
