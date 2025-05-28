package polarisweb.QAWorkshopDay6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day6ExceptionalHandling {

	WebDriver driver; 
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	// There are two types of errors 
	// 1. Checked type (Compile time error)
	// 2. Unchecked type (Run time error
	
	// Java forces you to handle these exceptions using try-catch or throws declaration.
	
	@Test (priority = 1)
	public void ArithmeticExceptionHandle() {
		try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
	}
	
	@Test(priority = 2)
	public void elementNotFound() {
		try {
			WebElement nonExistentElement = driver.findElement(By.id("nonExistentId"));
			nonExistentElement.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		}
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
	    Thread.sleep(2000);
		driver.quit();
	}
}
