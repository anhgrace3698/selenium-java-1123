package webdriver;

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
		
		driver.close(); // dong 1 tab ma no dang đứng /*
		
		driver.quit(); // đóng toàn bộ browser /**
		
		driver.findElement(By.xpath("")); // tim element voi 1 locator nao do /**
	
		driver.findElements(By.xpath(""));		 //*
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
		
		// mo ra url  **
		driver.get("https://www.netflix.com/browse");
		
		//lay ra url cua page hien tai
		driver.getCurrentUrl();

		Assert.assertEquals(driver.getCurrentUrl(),"https://www.netflix.com/browse");

		// lay ra source html cua page hien tai
		// verify tuong doi
		driver.getPageSource();
		Assert.assertTrue(driver.getPageSource().contains("Tôi yêu bạn"));
		
		//tra ve title hien tai
		Assert.assertEquals(driver.getTitle(),"Tôi yêu bạn");
		
		// lay ra id cua tab hoac cac tab ma browser dang mo /*
		String loginWindowID = driver.getWindowHandle();
		
		Set<String> allID = driver.getWindowHandles();
		
		//cookie - cache /*
		
		Options opt =driver.manage();
		Options opt1 =driver.manage();

		
		// login thanh cong -> luu cookie lai
		opt.getCookies();
		
		// dung cho testcase khac thi dung lai cookie cu nay la dc

		opt.logs(); // bai sau se hoc
		
		// khonag thoi gian cho 1 element xuat hien trong 1 tieng /**
		Timeouts time = opt1.timeouts(); 
		time.implicitlyWait(1, TimeUnit.HOURS);
		time.implicitlyWait(60, TimeUnit.MINUTES);
		time.implicitlyWait(3600, TimeUnit.SECONDS);
		
		//cho cho 1 page xuat hien trong vong 30 s
		time.pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//cho cho script thuc thi xong trong vong 30s
		time.setScriptTimeout(30, TimeUnit.SECONDS);
		
		//wwin - tuong tac voi browser
		Window win = opt.window();
		win.fullscreen();
		win.maximize(); //**
		win.getPosition();
		win.getSize();
		
		//navigate dieu huong
		
		Navigation nav = driver.navigate();
		nav.back();
		nav.forward();
		nav.refresh();
		// cung mo ra tab moi o current browser tuong tu voi cai nay. nav. to thi co support cho back, forward,.. cac thu hon
		nav.to("https://www.netflix.com/browse");
		driver.get("https://www.netflix.com/browse");
		
		// swtich to /**
		 TargetLocator tar = driver.switchTo();
		 tar.alert();
		 
		 tar.frame("");
		 
		 tar.window(loginWindowID);
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
