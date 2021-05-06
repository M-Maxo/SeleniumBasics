package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SubmitMethod {

	ChromeDriver driver;
	WebElement txtSearch;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");
	}

	@Test
	public void testSumbit()
	{
		txtSearch = driver.findElement(By.name("q"));
		txtSearch.sendKeys("Selenium Web Driver");
		txtSearch.submit();
		txtSearch = driver.findElement(By.name("q"));
		txtSearch.clear();
		txtSearch.sendKeys("Facebook");
		txtSearch.submit();

	}

}
