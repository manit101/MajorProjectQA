package polarisweb.QAWorkshopDay2;



import org.openqa.selenium.By;
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
		
		WebElement signupPage = driver.findElement(By.xpath("//a[@class=\"sign-in-form__sign-in-cta my-2 py-1 btn-md btn-secondary block min-h-[40px] babybear:w-full\"]"));
		signupPage.click();
		Thread.sleep(2000);
		
		WebElement emailInput = driver.findElement(By.id("username"));
		emailInput.sendKeys("yourMail");
		
		WebElement passInput = driver.findElement(By.id("password"));
		passInput.sendKeys("yourPass");
		
		WebElement signBtn = driver.findElement(By.xpath("//button[@class=\"btn__primary--large from__button--floating\"]"));
		signBtn.click();
		
		WebElement profilePic = driver.findElement(By.xpath("//img[@class=\"profile-card-profile-picture evi-image lazy-image ember-view\"]"));
		profilePic.click();
		Thread.sleep(5000);

	}
	
	@AfterMethod
	 public void tearDown () {
		 driver.quit();
	 } 
}
