package uploadAndDoanloadFile;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile {

	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://the-internet.herokuapp.com/upload");
	}

	@Test
	public void uploadFile()
	{
		String imgPath = System.getProperty("user.dir")+"/Uploads/cupe.jpg";

		WebElement fileUploader = driver.findElement(By.id("file-upload"));
		fileUploader.sendKeys(imgPath);
		WebElement fileSubmit = driver.findElement(By.id("file-submit"));
		fileSubmit.click();

		WebElement fileUploaded = driver.findElement(By.id("uploaded-files"));
		System.out.println(fileUploaded.getText());

		Assert.assertEquals("cupe.jpg" , fileUploaded.getText());
	}

//	@Test
//	public void uploadUsingRobotClass() throws InterruptedException, AWTException
//	{
//		String imgPath = System.getProperty("user.dir")+"\\Uploads\\cupe.jpg";
//		WebElement fileUploader = driver.findElement(By.id("file-upload"));
//		fileUploader.click();
//		
//		// code for using robot class for file upload
//		Robot robot = new Robot();
//		
//		//  CTRL+C copy image path
//		StringSelection selection = new StringSelection(imgPath);
//		System.out.println(imgPath);
//		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//		clipboard.setContents(selection, null);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		robot.delay(2000);
//		
//		// click on CTRL+V
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.delay(2000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(3000);
//		
//		WebElement fileSubmit = driver.findElement(By.id("file-submit"));
//		fileSubmit.click();
//		WebElement fileUploaded = driver.findElement(By.id("uploaded-files"));
//		System.out.println(fileUploaded.getText());
//		Thread.sleep(3000);
//		Assert.assertEquals("cupe.jpg" , fileUploaded.getText());
//
//
//	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
