package workingWithElements;

import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;


public class CookiesHandle {
	
	ChromeDriver driver;

	@BeforeTest
	public void openURL()
	{
		String chromePath = System.getProperty("user.dir")+"\\Sources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://magento-demo.lexiconn.com/");
	}
	
	
	@Test
	public void testCookies()
	{
		WebElement selectLang = driver.findElement(By.id("select-language"));
		Select select = new Select(selectLang);
		Assert.assertEquals("English", select.getFirstSelectedOption().getText());
		//store cookies should be null
		Cookie storeCookie = driver.manage().getCookieNamed("store");
		Assert.assertEquals(null, storeCookie);
		//select German Language
		select.selectByVisibleText("German");
		storeCookie = driver.manage().getCookieNamed("store");
		Assert.assertEquals("german", storeCookie.getValue());
		System.out.println(storeCookie.getValue());
		
		
		//Get All cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Number Of Cookies is: " + cookies.size());
		
		Iterator<Cookie> itr = cookies.iterator();
		while(itr.hasNext())
		{
			Cookie cookie = itr.next();
			System.out.println("Domain: "+cookie.getDomain());
			System.out.println("Name: "+cookie.getName());
			System.out.println("Path: "+cookie.getPath());
			System.out.println("Value: "+cookie.getValue());
			System.out.println("Expiry Date: "+cookie.getExpiry());
			System.out.println("---------------------------------------------");
		}
	}
	
}
