package findingElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByTagName {

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
	public void findElementByTagName()
	{
		WebElement loginBtn = driver.findElement(By.tagName("button"));
		System.out.println(loginBtn.getText());
	}
	
	@Test
	public void findTableByTagName()
	{
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.get(3).getText());
		
	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}

}
