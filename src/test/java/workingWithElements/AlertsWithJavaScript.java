package workingWithElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class AlertsWithJavaScript {
	
	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	
	@Test(priority = 1)
	public void alertTest() throws InterruptedException
	{
		WebElement btnAlert = driver.findElement(By.id("simple"));
		btnAlert.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Hello! I am an alert box!", alert.getText());
		alert.accept();
		Thread.sleep(3000);
	}
	
	
	@Test(priority = 2)
	public void promptAlert() throws InterruptedException
	{
		WebElement promptBtn = driver.findElement(By.id("prompt"));
		promptBtn.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Maxo");
		Thread.sleep(3000);
		alert.accept();
		WebElement promptDemo = driver.findElement(By.id("prompt_demo"));
		Assert.assertEquals("Hello Maxo! How are you today?", promptDemo.getText());
	}
	
	@Test(priority = 3)
	public void confirmAlert() throws InterruptedException

	{
		//Confirm
		WebElement confirmBtn = driver.findElement(By.id("confirm"));
		confirmBtn.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		WebElement message = driver.findElement(By.id("demo"));
		Assert.assertEquals("You Accepted Alert!", message.getText());
		
		//Dismiss
		WebElement dismissBtn = driver.findElement(By.id("confirm"));
		dismissBtn.click();
		Thread.sleep(3000);
		Alert dismissAlert = driver.switchTo().alert();
		dismissAlert.dismiss();
		WebElement msg = driver.findElement(By.id("demo"));
		Assert.assertEquals("You Dismissed Alert!", msg.getText());
		
	}
}
