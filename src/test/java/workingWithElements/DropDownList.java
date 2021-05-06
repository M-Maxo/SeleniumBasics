package workingWithElements;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownList {

	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
	}

	@Test
	public void dropDownTest() throws InterruptedException
	{
		WebElement optionList = driver.findElement(By.id("dropdown"));
		Select selectOptions = new Select(optionList);
		
		Assert.assertFalse(selectOptions.isMultiple());
		Assert.assertEquals(3, selectOptions.getOptions().size());
		
		selectOptions.selectByVisibleText("Option 2");
		Thread.sleep(2000);
		selectOptions.selectByValue("1");
		Thread.sleep(2000);
		selectOptions.selectByIndex(2);
	}


}
