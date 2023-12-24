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

public class Topic_02_Selenium_Locator {
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
		
		//Open register page
		driver.get("https://demo.nopcommerce.com/register");
	}
	//HTML cua o firstname
	//<input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
	
	// Ten the cua element aka Tagname cua HTML: INPUT
	// Ten cua thuoc tinh aka attribute name: type, data-val,..
	// Gia tri cua thuoc tinh aka attribute value: text, true,..
	
	
	@Test
	public void TC_01_ID() {
		// Muon thao tac element thi phai tim dc element do.
		// cach find: find theo -> id, name, css, xpath,... 
		// sau khi tim dc element -> action len element do: click/sendkey
		// find theo id thi id must be unique, neu ko thi se nham lan va selenium bat cai dau tien 
		driver.findElement(By.id("FirstName")).sendKeys("Tô Lan Anh");;
	}

	@Test
	public void TC_02_Class() {
		//Open Search page
		// Nhap text vao o search
		driver.get("https://demo.nopcommerce.com/search");
		driver.findElement(By.className("search-text")).sendKeys("iPad Pro M1 used");
		
	}

	@Test
	public void TC_03_Name() {
		//Click vao advanced checkbox
		driver.findElement(By.name("advs")).click();
	}
	
	@Test
	public void TC_04_Tagname() {
		//tim ra bao nhieu the input tren man hinh hien tãi 
		System.out.println(driver.findElements(By.tagName("input")).size());
		
	}
	
	@Test
	public void TC_05_LinkText() {
		//click vao duong link address 
		driver.findElement(By.linkText("Addresses")).click();
		
	}
	
	@Test
	public void TC_06_PartialLinkText() {
		//click vao link apply for vendor - tuong doi - chay cham hon
		driver.findElement(By.partialLinkText("vendor account")).click();
	}
	
	//css va xpath la nhieu ki thuat nhat
	@Test
	public void TC_07_Css() {
		//Mo lai trang register
		driver.get("https://demo.nopcommerce.com/register");
		
		// 1
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Check1");
		
		//2
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Check2");
		
		//3
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("Check3");
		
	}
	
	//tu css sang xpath: them // va @ attribute
	
	@Test
	public void TC_08_Xpath() {
		//Mo lai trang register
		driver.get("https://demo.nopcommerce.com/register");
		
		// 1
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Check1-xpath");
		
		//2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Check2-xpath");
		
		//3
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("Check3-xpath");
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
