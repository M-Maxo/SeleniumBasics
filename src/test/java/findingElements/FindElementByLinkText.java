package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByLinkText {
	
ChromeDriver driver;
	
	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}
	
	@Test
	public void findElementByLinkText()
	{
		WebElement linkTxt = driver.findElement(By.linkText("Elemental Selenium"));
		System.out.println(linkTxt.getAttribute("href"));
	}
	
	@Test
	public void findElementByPartialText()
	{
		WebElement linkTxt = driver.findElement(By.partialLinkText("Elemental"));
		System.out.println(linkTxt.getAttribute("href"));
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}

}
