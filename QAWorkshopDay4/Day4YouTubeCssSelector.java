package polarisweb.QAWorkshopDay4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day4YouTubeCssSelector {

    WebDriver driver; 

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test (priority = 1)
    public void ytSearchDriverMethods () throws InterruptedException {
    	driver.get("https://www.youtube.com/");
    	WebElement searchBox = driver.findElement(By.cssSelector("input[name=\"search_query\"]"));
    	
    	searchBox.sendKeys("Polaris School of Technology");
    	searchBox.sendKeys(Keys.ENTER);
    	Thread.sleep(1000);
    	
    	driver.navigate().to("https://www.amazon.in/");
    	Thread.sleep(1000);
    	
    	driver.navigate().back();
    	Thread.sleep(1000);
    	
    	driver.navigate().forward();
    	Thread.sleep(1000);
    }
    
    @Test (priority = 2)
    public void ytSearchDriverMethods2 () throws InterruptedException {
    	driver.get("https://www.youtube.com/");
    	WebElement searchBox = driver.findElement(By.cssSelector("input[name=\"search_query\"]"));
    	
    	searchBox.sendKeys("Polaris");
    	searchBox.sendKeys(Keys.ENTER);
    	Thread.sleep(1000);
    	
    	driver.navigate().to("https://www.flipkart.com/");
    	Thread.sleep(1000);
    	
    	driver.navigate().back();
    	Thread.sleep(1000);
    	
    	driver.navigate().forward();
    	Thread.sleep(1000);
    }
    
    // The order of execution of code is:
	// BeforeMethod -> priority 1 -> AfterMethod -> BeforeMethod -> priority 2 -> AfterMethod      and so on.
    
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
	    driver.quit();
	}
}
