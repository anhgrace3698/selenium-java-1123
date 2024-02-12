package webdriver;

import java.lang.StackWalker.Option;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
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

public class Topic_08_web_element {
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
	public void TC_01_web_element() {
		//tương tac voi browser thi truc tiep driver...
		// tuong tac voi element thì driver.findelement....
		// HTML element: textbox, dropdown, link, button
		// tìm trước, chua tương tác 
		
		driver.findElement(By.id("check"));
		
		// tim, tuong tac luon
		driver.findElement(By.id("check")).click();
		driver.findElement(By.id("check")).sendKeys("Hello");
		
		// tim va luu vao 1 bien (chua tuong tac)
		// goi ra su dung sau
		
		WebElement FullnameTextbox =  driver.findElement(By.id("login"));
		FullnameTextbox.clear();
		FullnameTextbox.sendKeys("Nguyenduy");
		FullnameTextbox.getAttribute("css");
		
		
		driver.findElement(By.id("login")).clear(); //*
		driver.findElement(By.id("login")).click(); //**
		driver.findElement(By.id("login")).sendKeys("Nguyenduy"); //**
		
		//tim tu node cha vao node con, tuy nhien nen viet binh thuong k nen viet nhu nay
		driver.findElement(By.id("form-login")).findElement(By.id("login"));
		
		// tra ve nhieu element thoa ma dieu kien
		List<WebElement> textBox = driver.findElements(By.id("login")); 
		
		//verify check box dropdown da chon chua
		Assert.assertTrue(driver.findElement(By.id("")).isSelected()); //*
		Assert.assertFalse(driver.findElement(By.id("")).isSelected());
		
		// veridy 1 element co hien thi ko
		Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());//**
		Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());
		
		// verify 1 element co dc tac dong len ko (read-only hay ko)
		Assert.assertTrue(driver.findElement(By.id("")).isEnabled());  //*
		Assert.assertTrue(driver.findElement(By.id("")).isEnabled());
		
		//HTML element
		// <html lang="en" id="top" class="no-js ie7">
		driver.findElement(By.id("login")).getAttribute("id"); //*
		driver.findElement(By.id("login")).getAttribute("type");
		driver.findElement(By.id("login")).getAttribute("title");
		
		//tab accesibility vaf property tren web > selenium ver 4
		//driver.findElement(By.id("login")).getDom....
		
		//tab styles
		//font size color
		driver.findElement(By.id("login")).getCssValue("color");
		
		// vi tri cua element so voi do phan giia man hinh
		Point toa_do = driver.findElement(By.id("login")).getLocation();
		//lay ra toa do
		toa_do.getX();
		toa_do.getY();

		//lay ra size kich thuoc element 
		Dimension nameSize = driver.findElement(By.id("login")).getSize();
		
		// lay ra size va location cua element. it dung
		Rectangle nameRect = driver.findElement(By.id("login")).getRect();
		
		Point nameRectPoint = nameRect.getPoint(); // lay ra toa do location cua element
		
		Dimension nameRectDimension = nameRect.getDimension(); // lay ra kich thuoc size cua element
		nameRectDimension.getHeight();
		nameRectDimension.getWidth();
		
		//shasow element -> slenium 4 -javascrpit exxcutor
		//driver.findElement(By.id("login")).get..
		
		// Từ id/ class/ css/ name/ xpath,... có thể suy ngược lại tagname. Co the dung dau ra the ny la dau vao the khac
		
		driver.findElement(By.id("login")).getTagName(); // input
		driver.findElement(By.className("form-login")).getTagName(); // p
		driver.findElement(By.cssSelector("#firstname")).getTagName(); // input
		
		// dau ra la tag name cua element A
		String formLogin = driver.findElement(By.id("login")).getTagName(); //input
		
		// dau vao cua element B can toi tag name A
		driver.findElement(By.xpath("//div[@class='home-popup__close-area']/preceding-sibling::"+formLogin));
		
		
		// lay text. Nhung text bi an thi k get dc
		driver.findElement(By.id("login")).getText(); //** 
		 
		//chup hinh get screen shot -> slenium ver 4 FILE/BASE64/BYTES //**
		//driver.findElement(By.id("login")).getSreenShotas();
		
		//chi dung cho element la form hoac nam trong the form
		driver.findElement(By.id("login")).submit(); // giong nhu hanh vi submit form //*

	}
	
	@Test
	public void TC_02_something() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
