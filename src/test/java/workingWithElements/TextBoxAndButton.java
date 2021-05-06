package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxAndButton {

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
	public void testLogin()
	{
		WebElement txtUsername = driver.findElement(By.id("username"));
		WebElement txtPassword = driver.findElement(By.id("password"));
		WebElement btnLogin	   = driver.findElement(By.className("radius"));

		txtUsername.clear();
		txtUsername.sendKeys("tomsmith");

		txtPassword.clear();
		txtPassword.sendKeys("SuperSecretPassword!");

		btnLogin.click();

		WebElement success = driver.findElement(By.id("flash"));
		System.out.println(success.getText());

		Assert.assertTrue(success.getText().contains("You logged into a secure area!"));
	}

	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}

}
