package javatester;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_assert {
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
		
	@Test
	public void TC_verifyTestNG() {
		
		// Trong Java co nhieu thu vien verify du lieu voi nhieu cap do
		// unit/ intergaration/ UI
		// Kieu du lieu la true/false
		driver.get("https://anhtester.com/blog/nhung-tinh-nang-moi-trong-selenium-4-b464.html");
		
		// Khi mong muon tra ve la dung thi dung assert True de verify
		Assert.assertTrue(driver.getPageSource().contains("Selenium"));
		
		//Khi mong muon du lieu tra ve la sai -> dung asert false
		Assert.assertFalse(driver.getPageSource().contains("Junit"));
		
		// khi nao dung cac ham true false nay
		// thuong dung cac ham is..
		
		driver.findElement(By.xpath("")).isDisplayed();
		driver.findElement(By.xpath("")).isEnabled();
		driver.findElement(By.xpath("")).isSelected();
	//	driver.findElement(By.xpath("")).isMultiple(); > ver 4 chac v :D
		
		// unit test
		Object name = null;
		Assert.assertNull(name); // khai bao null -> thanh null
		
		Object name1 = "Testing";
		Assert.assertNull(name1); // not null
		
		// Thuong so sanh thuc te va mong doi - tuyệt đối
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.netflix.com/browse");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
