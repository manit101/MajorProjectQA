package polarisweb.QAWorkshopDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day3SeleniumFunc {
	
    WebDriver driver; 

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test (priority = 1)
    public void testFunc() throws InterruptedException {
    	// driver functions
    	driver.get("abc.com");
    	driver.findElement(By.cssSelector(".a-icon"));
    	driver.findElement(By.cssSelector(".a-icon")).clear(); // clears the element
    	driver.findElement(By.cssSelector(".a-icon")).click(); // clicks on element
    	String text = driver.findElement(By.cssSelector(".a-icon")).getText(); // returns the text inside the element
    	WebElement login_btn = driver.findElement(By.cssSelector(".login-btn")); // WebElement is an interface
    	
    	driver.navigate().to("xyz.com"); // navigates to new webpage // navigate allows to chain extra functions
    	driver.navigate().refresh(); // refreshes the current page
    	driver.navigate().back(); // clicks the back webpage button
    	driver.navigate().forward(); // clicks the forward webpage button
    	driver.close(); // closes only the current tab
    	driver.quit(); // closes the whole browser
    	
    	// WebDriver and WebElement are interfaces. We can not make their objects.
    	
    	Assert.assertEquals(false, null);
    	Assert.assertTrue(true,"");
    	Assert.assertFalse(true,"");

    	Thread.sleep(2000);
    	//Thread.sleep() is a hard wait not preferred usually
    	
    	// The order of execution of code is:
    	// BeforeMethod -> priority 1 -> AfterMethod -> BeforeMethod -> priority 2 -> AfterMethod      and so on.
    }
    
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(2000);
        driver.quit();
    }
}
