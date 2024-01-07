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

public class Topic_03_findElement {
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
		
		//Open account page
		driver.get("http://live.techpanda.org/");
	}
	
	
	
	@Test
	public void TC_01_xpath_parent() {
		
		// click vao my account o header
		// element dau tien tim thay ko thao tac duoc nen se bao loi
		// co ceh cua selenium: thao tac voi element dc tim thay dau tien 
		// nen neu viet //a[@title='My Account'] thi k xac dinh dc unique
		// can xac dinh them thong qa parent 
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		// co nhieu thong tin de tim bug
		// reproduce xem co dung la bug ko
		// code viet sai
		// thieu thoi gian (time out)
		// page chua load xong 
			
	}
	
//	@Test
//	public void TC_02_xpath_span() {
//		
//		//Open page item 
//		
//		driver.get("http://live.techpanda.org/index.php/checkout/cart/");
//		String successMessageText = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
//		//Lay ra text Samsung Galaxy was added to your shopping cart.
//		//so sanh text lay ra va text mong muon
//		Assert.assertEquals(successMessageText,"Samsung Galaxy was added to your shopping cart.");
//		
//	}
	
	@Test
	public void TC_03_ham() {
		
		// tuyet doi: dau = va all gia tri
		// tuong doi: dau , chi can lay 1 phan
		// ham: dung voi text va attribute deu duoc. 
		
		driver.get("http://live.techpanda.org/index.php/checkout/cart/");
		driver.findElement(By.xpath("//h1[contains(text(),'Empty')]"));
		
		// driver.findElement(By.xpath("//input[contains(@id,'coupon_code')]")).sendKeys("ABC");
		//co the ap dung start with khi attribute thay doi moi lan reload trang
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
