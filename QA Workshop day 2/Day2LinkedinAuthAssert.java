package polarisweb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2LinkedinAuthAssert {
	
	WebDriver driver;
	
	@BeforeMethod
	  public void runTest() {
      WebDriverManager.chromedriver().setup(); 
      driver = new ChromeDriver();
      driver.manage().window().maximize();
	}
	
	@Test (priority = 1)
	public void linkedinAuth() throws InterruptedException {
		driver.get("https://www.linkedin.com/");
		Thread.sleep(2000);
		
		WebElement signupPageXPath = driver.findElement(By.xpath("//a[@class=\"sign-in-form__sign-in-cta my-2 py-1 btn-md btn-secondary block min-h-[40px] babybear:w-full\"]"));
		signupPageXPath.click();
		Thread.sleep(2000);
		
		WebElement emailInputXPath = driver.findElement(By.id("username"));
		emailInputXPath.sendKeys("yourMail");
		
		WebElement passInputXPath = driver.findElement(By.id("password"));
		passInputXPath.sendKeys("yourPass");
		
		WebElement signBtnXPath = driver.findElement(By.xpath("//button[@class=\"btn__primary--large from__button--floating\"]"));
		signBtnXPath.click();
		
		WebElement profilePicXPath = driver.findElement(By.xpath("//img[@class=\"profile-card-profile-picture evi-image lazy-image ember-view\"]"));
		profilePicXPath.click();
		Thread.sleep(5000);

	}
	
	@AfterMethod
	 public void tearDown () {
		 driver.quit();
	 } 
}
