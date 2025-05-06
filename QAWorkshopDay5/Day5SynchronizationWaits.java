package polarisweb.QAWorkshopDay5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day5SynchronizationWaits {
	   
	WebDriver driver; 
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	   
	}
	
	// Synchronization 
	
//	 1. Thread.sleep();
//	 This is a Java method used to give waits.
//	 This is a hard wait because it literally pauses the thread's execution for the specified time, preventing it from doing anything else
	
//	 2. Implicit wait
//	 This is a method provided by the Timeouts interface which is part of Selenium's WebDriver.Options class.
//	 This is a global wait so need to give wait again and again
//	 This works on presence of locators and as it finds the locator it will continue execution so no need to wait for whole time
//	 It uses continuous polling and checking the presence of element every 500ms
//	 Improves readability, 
//	 Reduces optimization for error checking -> like if 9 test cases takes only about 3 seconds and one takes about 15 seconds to complete 
//	we will need to set it as 15 seconds. If any one out nine throws error we will have to wait for 15 seconds to know the error
//	 It is not able to check clickablity, disability, visibility of element
	
//	 3. Explicit wait
//	 This is not global, it is line by line
//	 This also checks clickablity, disability, visibility with the presence of element
//	 		a) Web Driver wait
//			WebDriverWait a = new WebDriverWait(driver, duration.ofSeconds(5));            
//			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
//	      b) Fluent wait
//	      same as Web Driver wait but here we can change the polling interval of wait
	
	@Test (priority = 1)
	public void clickFirstItemWithoutWait() throws InterruptedException {
		driver.get("https://www.amazon.in/ref=nav_logo");
		WebElement inputBox = driver.findElement(By.id("twotabsearchtextbox"));
		inputBox.sendKeys("bat");
        
        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
        searchBtn.click();
        
        // Clicking on first product should give error due to no implicit/Thread.sleep wait, but don't know why its working fine without wait also
        WebElement firstItem = driver.findElement(By.xpath("(//a[@class=\"a-link-normal s-line-clamp-4 s-link-style a-text-normal\"])[1]"));
        firstItem.click();
	}
	
	@Test (priority = 2)
	public void addToCartWithoutWait() {
		driver.get("https://www.amazon.in/ref=nav_logo");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement inputBox = driver.findElement(By.id("twotabsearchtextbox"));
		inputBox.sendKeys("bat");
        
        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
        searchBtn.click();
        
        // Clicking on "add to cart" should give error due to no implicit/Thread.sleep wait, but don't know why its working fine without wait also
        WebElement firstItemAddToCartBtn = driver.findElement(By.id("a-autoid-1-announce"));
        firstItemAddToCartBtn.click();
        
        WebElement cartBtn = w.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count")));
        cartBtn.click();
	}
	
	@Test (priority = 3)
	public void flipkartLoginPopUpCross() {
		driver.get("https://www.flipkart.com");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.navigate().refresh();
		
        // Clicking on "crossing the login pop up" should give error due to no clickablity, but don't know why its working fine without wait also
		WebElement loginPopUpCross = w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span._30XB9F")));
		loginPopUpCross.click();
	}
	
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
	    Thread.sleep(2000);
		driver.quit();
	}
}
