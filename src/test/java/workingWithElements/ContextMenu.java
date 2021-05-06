package workingWithElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenu {
	
	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
	}

	@Test
	public void testContextMenu() 
	{
		WebElement clickMeBtn = driver
				.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		WebElement contextMenu= driver
				.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));
		Actions builder = new Actions(driver);
		builder.contextClick(clickMeBtn)
		.moveToElement(contextMenu)
		.click()
		.perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		assertEquals("clicked: edit", alert.getText());
		alert.dismiss();
	}

}
