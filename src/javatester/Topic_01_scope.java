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

public class Topic_01_scope {
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

		// muon dung cho nay thi pai khoi tao = new neu k se gap loi nullpointerexception
		// dung tren trinh duyet nao thi khoi tao voi trinh duet do
		driver = new FirefoxDriver(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	// tuong tac browser -> driver
	// tuong tac element -> web elementr
	
	String homePageUrl = ""; // khai bao declare, bien global
	String fullName = "Automation FC";     // khai bao + khoi tao initial
		
	@Test
	public void TC_00_scope() {
		
		
		String homePageUrl; // bien local
		// trong ham function neu 2 bien trung ten (global/local) -> uu tien local
		//driver.get(homePageUrl); -> bao loi vi chua khoi tao ma da dung (moi khai bao thoi, thieu khoi tao)
		
		// muon dung global o trong funtion thay cho local -> dung this
		// bien global chua initial dung -> ko bao loi luc complie viet code nhung run loi
		driver.get(this.homePageUrl);
		
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
