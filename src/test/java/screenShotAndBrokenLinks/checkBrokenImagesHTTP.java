package screenShotAndBrokenLinks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class checkBrokenImagesHTTP {
	
	
	public ChromeDriver driver;
	private int invalidImageCount;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://the-internet.herokuapp.com/broken_images");
	}
	
	@Test
	public void testBrokenImage()
	{
		invalidImageCount = 0;
		java.util.List<WebElement> imageList = driver.findElements(By.tagName("img"));
		for(WebElement imgElement : imageList)
		{
			if(imgElement != null)
			{
				VerifyImageActive(imgElement);
			}
		}
	}
	
	public void VerifyImageActive(WebElement imgElemenet)
	{
		// the code in video cannot import
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}


}
