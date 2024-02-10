package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Web_driver {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	// tuong tac browser -> driver
	// tuong tac element -> web element
	
	
	@Test
	public void TC_01_invalid_phone_number() {
		// java cach su dung f3
		
		// >=2 tab 
		
		driver.close(); // dong 1 tab ma no dang đứng
		
		driver.quit(); // đóng toàn bộ browser
		
		driver.findElement(By.xpath("")); // tim element voi 1 locator nao do
	
		driver.findElements(By.xpath(""));		
		//tim 1 element
		// luu voa bien de dung cho sau nay
		
		WebElement  mailTextbox = driver.findElement(By.xpath(""));
		mailTextbox.clear();
		mailTextbox.sendKeys("hello");
		
		//hoac dung luon k can tao bien
		
		driver.findElement(By.xpath("")).sendKeys("hello");
		
		 // tim nhieu element
		List<WebElement> boxes = driver.findElements(By.xpath(""));
		boxes.clear();
		
		// mo ra url 
		driver.get("https://www.youtube.com/watch?v=9S7_ODHZmQ8");
		
		//lay ra url cua page hien tai
		driver.getCurrentUrl();

		Assert.assertEquals(driver.getCurrentUrl(),"https://www.netflix.com/browse");

		// lay ra source html cua page hien tai
		// verify tuong doi
		driver.getPageSource();
		Assert.assertTrue(driver.getPageSource().contains("Tôi yêu bạn"));

		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
