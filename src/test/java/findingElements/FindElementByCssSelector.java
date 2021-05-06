package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByCssSelector {
	
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
	public void findElementByCssSelector()
	{
		WebElement usernameTxt = driver.findElement(By.cssSelector("input#username"));
		WebElement passwordTxt = driver.findElement(By.cssSelector("input#password"));
		WebElement loginBtn    = driver.findElement(By.cssSelector("button.radius"));
		
		System.out.println(usernameTxt.getTagName());
		System.out.println(passwordTxt.getTagName());
		System.out.println(loginBtn.getText());
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}

}
