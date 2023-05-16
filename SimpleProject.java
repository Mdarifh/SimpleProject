package Day1;



import java.util.concurrent.TimeUnit;

import org.bouncycastle.asn1.dvcs.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleProject {
	public static WebDriver driver;
	public static SoftAssert softassert = new SoftAssert();
	
	//@Test(priority=1,dataProvider = "getData")
	public void LoginTest(String username,String password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("input-password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Thread.sleep(2000);
		softassert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		softassert.assertAll();
		driver.quit();
	}
	
	
		
		@DataProvider
		
		public Object[][] getData() {
			Object[][] data = {{"seleniumpanda@gmail.com","Selenium@123"},
							   {"seleniumpanda1@gmail.com","Selenium@123"},
							   {"seleniumpanda2@gmail.com","Selenium@123"},
							   {"seleniumpanda3@gmail.com","Selenium@1234"}};
		return data;
	}
		
		
		@Test(priority=2,dataProvider = "rediffData")
		public static void rediffLoginTest(String username,String password)  {
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
		
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.id("login1")).sendKeys(username);
			
			driver.findElement(By.id("password")).sendKeys(password);
			
			driver.findElement(By.cssSelector("input.signibtn")).click();
			
			softassert.assertTrue(driver.findElement(By.linkText("a.rd_logout")).isDisplayed());
			
			softassert.assertAll();
			
			driver.quit();
			
		}
		
		@DataProvider
		public  Object[][] rediffData(){
			Object[][] data = {{"seleniumpanda@rediffmail.com","Selenium@123"},
					   {"seleniumpanda@rediffmail.com","Selenium@123"}};
					 //  {"seleniumpanda@rediffmail.com","Selenium@123"},
					  // {"seleniumpanda@rediffmail.com","Selenium@1234"}};
			return data;
			
		}

}
