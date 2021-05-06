package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByName {
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
	public void findElementByName()
	{
		WebElement usernameTxt = driver.findElement(By.name("username"));
		WebElement passwordTxt = driver.findElement(By.name("password"));

		System.out.println(usernameTxt.getTagName());
		System.out.println(passwordTxt.getTagName());
	}


	@Test
	public void TryCatchElementByWrongName()
	{
		try {
			WebElement usernameTxt = driver.findElement(By.name("abc"));
			WebElement passwordTxt = driver.findElement(By.name("abc"));

			System.out.println(usernameTxt.getTagName());
			System.out.println(passwordTxt.getTagName());

		} catch (NoSuchElementException e) {
			System.out.println("The Element Not Found Please Try Another Attribute!..");
		}

	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}

}
