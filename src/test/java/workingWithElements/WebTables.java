package workingWithElements;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebTables {


	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
	}

	@Test
	public void testWebTable()
	{
		WebElement webTable = driver.findElement(By.id("table1"));

		List<WebElement> rows = webTable.findElements(By.tagName("tr"));
		Assert.assertEquals(5, rows.size());

		for(WebElement row : rows)
		{
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(WebElement col : cols)
			{
				System.out.print(col.getText() + "     |     ");
			}
			System.out.println();
		}
	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
