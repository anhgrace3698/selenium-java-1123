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

public class Topic_06_xpathcss {
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
	public void TC_01_register_empty_data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//action
		driver.findElement(By.id("txtFirstname")).clear();
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtCEmail")).clear();
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtCPassword")).clear();
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//verify
		String mess1 = driver.findElement(By.id("txtFirstname-error")).getText();
		Assert.assertEquals(mess1, "Vui lòng nhập họ tên");
		
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	//	Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại. ");
	}
	
	
	@Test
	public void TC_02_invalid_email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//action
		driver.findElement(By.id("txtFirstname")).sendKeys("lan anh");
		driver.findElement(By.id("txtEmail")).sendKeys("lan anh");
		driver.findElement(By.id("txtCEmail")).sendKeys("lan anh");
		driver.findElement(By.id("txtPassword")).sendKeys("12345678");
		driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
		driver.findElement(By.id("txtPhone")).sendKeys("0912989898");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//verify
		
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		
	}
	
	
	@Test
	public void TC_03_incorrect_confirm_email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//action
		driver.findElement(By.id("txtFirstname")).sendKeys("lan anh");
		driver.findElement(By.id("txtEmail")).sendKeys("lananh");
		driver.findElement(By.id("txtCEmail")).sendKeys("lananh10");
		driver.findElement(By.id("txtPassword")).sendKeys("12345678");
		driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
		driver.findElement(By.id("txtPhone")).sendKeys("0912989898");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//verify
		
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void TC_04_invalid_password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//action
		driver.findElement(By.id("txtFirstname")).sendKeys("lan anh");
		driver.findElement(By.id("txtEmail")).sendKeys("lananh@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("lananh@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("12");
		driver.findElement(By.id("txtCPassword")).sendKeys("12");
		driver.findElement(By.id("txtPhone")).sendKeys("0912989898");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//verify
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}
	
	@Test
	public void TC_05_incorrect_confirm_password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//action
		driver.findElement(By.id("txtFirstname")).sendKeys("lan anh");
		driver.findElement(By.id("txtEmail")).sendKeys("lananh@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("lananh@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("12345678");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0912989898");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//verify
		
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}
	
	@Test
	public void TC_06_invalid_phone_number() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//action less than 11 numbers
				driver.findElement(By.id("txtFirstname")).sendKeys("lan anh");
				driver.findElement(By.id("txtEmail")).sendKeys("lananh@gmail.com");
				driver.findElement(By.id("txtCEmail")).sendKeys("lananh@gmail.com");
				driver.findElement(By.id("txtPassword")).sendKeys("12345678");
				driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
				driver.findElement(By.id("txtPhone")).sendKeys("091298");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
		//verify
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

		
		//action more than 11 numbers
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("0912345678999");
		//verify
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
		//action equals 11 numbers, but not valid
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("9912915989");
		//verify
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
}


	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
