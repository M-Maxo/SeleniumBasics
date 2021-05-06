package screenShotAndBrokenLinks;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShot {

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
	public void testScreenShot()
	{
		WebElement searchTxt = driver.findElement(By.name("q"));
		searchTxt.sendKeys("Selenium WebDriver");
		searchTxt.submit();
		assertTrue(driver.getTitle().contains("Maxo"));
	}
	
	
	@AfterMethod
	public void takeScreenShotOnFaliure(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			// Create reference of take screenshot
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/" + result.getName() + ".png"));
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
