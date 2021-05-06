package screenShotAndBrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class checkBrokenLinksHTTP {
	
	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.google.com");
	}
	
	@Test
	public void testBrokenLinks()
	{
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links is: " + links.size());
		for (int i=0 ; i< links.size() ; i++)
		{
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			VerifyLink(url);
		}
	}
	
	public static void VerifyLink(String urlLink)
	{
		try 
		{
			URL link = new URL(urlLink);
			//create connection url object
		    HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();	
		    httpconn.setConnectTimeout(2000);
		    httpconn.connect();
		    
		    //use getResponseCode() to get the response code
		    if(httpconn.getResponseCode() == 200)
		    {
		    	System.out.println(urlLink + " - " + httpconn.getResponseMessage());
		    }
		    
		    if(httpconn.getResponseCode() == 404)
		    {
		    	System.out.println(urlLink + " - " + httpconn.getResponseMessage());
		    }
		}
		
		catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
