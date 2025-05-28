package polarisweb.QAWorkshopDay6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day6SynchronizationWaits2 {
	   
	WebDriver driver; 
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	   
	}
	
	@Test(priority = 1)
	public void googleSearch() throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// Wait class is used to impliment FluentWait
		// It ia powerfiul action as we can
		// 1. give wait duration  2. set polling rate  3. ignore exceptions
		Wait <WebDriver> fw = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(1))
				.pollingEvery(Duration.ofMillis(300))
				.ignoring(NoSuchElementException.class);
		
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.cssSelector("textarea#APjFqb"));
		searchBox.sendKeys("Polaris VS Scaler");
        searchBox.sendKeys(Keys.ENTER);
        
        Thread.sleep(10000);
        
        // Clicking on first link should give error due to no implicit/Thread.sleep wait, but don't know why its working fine without wait also
        WebElement firstItem = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h3[@class=\\\"LC20lb MBeuO DKV0Md\\\"])[1]")));
        WebElement firstItem2 =fw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h3[@class=\\\"LC20lb MBeuO DKV0Md\\\"])[1]")));
        firstItem.click();
        firstItem2.click();
	}
	
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
	    Thread.sleep(2000);
		driver.quit();
	}
}
