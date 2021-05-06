package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IsElementPresent {
	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
	}
	
	
	@Test
	public void testIsElementPresent()
	{
		if (isElementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))) 
		{
			WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			if(!check1.isSelected())
				check1.click();
		}
		else 
		{
			Assert.fail("CheckBox doesn't exist!..");
		}
	}

	private boolean isElementPresent(By by) 
	{
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
