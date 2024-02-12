package webdriver;

import java.lang.StackWalker.Option;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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
	
	@Test
	public void TC_01_invalid_phone_number() {
		// java cach su dung f3
		
		// >=2 tab 
		
		driver.close(); // dong 1 tab ma no dang đứng /*
		
		driver.quit(); // đóng toàn bộ browser /**
		
		
		// tim element voi 1 locator nao do. Tìm với loại by nào đó và trả về  /**
		// ko tìm thấy -> fail ở step này -> throw ra no such element
		// trả về 1 element, nếu tìm thấy > 1 cũng chỉ nhặt giá trị đầu tiên
		driver.findElement(By.xpath("input@[title='dang nhap']")); 
	
		// tìm các element thỏa mãn dkien, nếu có nhiều thì lưu vào list. Lưu vào list vì cho phép các giá trị element trùng lặp
		// ko tìm thấy -> trả về list rỗng
		driver.findElements(By.xpath("input@[title='dang nhap']"));		 //*
		
		// 2 hàm này ảnh hưởng bơi timeout implicit wait trước đó
		
		
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
		
		// lay ra id cua tab hoac cac tab ma browser dang mo. Lưu vào set vì k cho các ID trùng lặp /*
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
		
		//wwin - tuong tac voi browser- test responseive
		Window win = opt.window();
		win.fullscreen();
		win.maximize(); //**
		win.getPosition();
		win.getSize();
		win.setSize(new Dimension(1200,1300));
		
		// set cho broser ow vi tri nao so voi phan giai man hinh
		// can chu y man hinh dang chay lich thuoc bao nhieu de chia ti le cho dung
		win.setPosition(new Point(150,200));
		
		
		//navigate dieu huong trang wweb
		
		Navigation nav = driver.navigate();
		nav.back();
		nav.forward();
		nav.refresh();
		
		// cung mo ra tab moi o current browser tuong tu voi cai nay. nav. to thi co support cho back, forward,.. cac thu hon
		nav.to("https://www.netflix.com/browse"); // truyen fix cung url
		driver.get("https://www.netflix.com/browse");
		
		// hoac la
		//nav.to(new URL("https://www.netflix.com/browse"));
		
		// swtich to /**
		 TargetLocator tar = driver.switchTo();
		 
		 // ham lien quan alert
		 tar.alert().accept();
		 tar.alert().dismiss();
		 tar.alert().getText();
		 tar.alert().sendKeys("hi");
		 
		 //swtich/ handle frame co 3 cach dung
		 //index/ ID(NAME)/ element
		 
		 tar.frame(0);
		 tar.frame("23435");
		 tar.frame(driver.findElement(By.id("check")));
		 
		 tar.defaultContent(); //swithc ve html chua frame truoc do
		 tar.parentFrame();  // tu frame trong di ra frame ngoai chua no
		 
		 // lay ra ID cua cua so tab hien tai 
		 tar.window(loginWindowID);
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
