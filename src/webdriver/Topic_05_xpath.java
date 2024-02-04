//test commit code
//test add index1111
//test commit code 2
//test commit code 3
package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_xpath {
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
		
		//Open page
		driver.get("https://automationfc.github.io/basic-form/");
	}
	
	
	@Test
	public void TC_01_xpathText() {

		// 1.Truyen locator vao de check hien thi (displayed) 
		// tuyet doi -> nen su dung
		driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']")).isDisplayed();
		
		// tuong doi -> han che dung
		driver.findElement(By.xpath("//p[contains(text(),'Mail Personal or Business Check')]")).isDisplayed();
	}
	
	
	@Test
	public void TC_02_xpathText() {
		
		// 2. Get text ra roi so sanh
		String textNine = driver.findElement(By.xpath("//h5[@id='nine']/p[1]")).getText();
		Assert.assertTrue(textNine.contains("Cashier's Check or money order to"));
		
	}

	@Test
	public void TC_03_xpathString() {
		
		// contains string quet tat ca cha va con
		// contains text chi quet tai node do
		//contains .  va contain string giong nhau
		String textNine = driver.findElement(By.xpath("//h5[@id='nine']/p[1]")).getText();
		Assert.assertTrue(textNine.contains("Cashier's Check or money order to"));
		
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
