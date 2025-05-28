package polarisweb.QAWorkshopDay8;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day8SelectClassSpicejet {

	WebDriver driver; 
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	@Test(priority = 1)
    public void spicejetDateAssert() throws InterruptedException { 
        driver.get("https://www.spicejet.com/");
        
        // The "Return Date" option will be having different CSS then the "Departure Date" when round trip is not selected so that "Return Date" looks disabled.
        
        // One Way and Round Trip have custom HTML tags like circle so can't find it's xpath 
        // Initially One Way is selected by default
        WebElement departureDate = driver.findElement(By.xpath("//div[@data-testid=\"departure-date-dropdown-label-test-id\"]"));
        String deptDateClass = departureDate.getAttribute("class");
        
        WebElement returneDate = driver.findElement(By.xpath("//div[@data-testid=\"return-date-dropdown-label-test-id\"]"));
        String returnDateClass = returneDate.getAttribute("class");

		Assert.assertNotEquals(deptDateClass, returnDateClass);
		
		// Now when we click on the the "Return Date" it gets enabled so it should have same CSS as of "Departure Date"
		returneDate.click();
		String deptDateClass2 = departureDate.getAttribute("class");
		String returnDateClass2 = returneDate.getAttribute("class");

		Assert.assertEquals(deptDateClass2, returnDateClass2);
    }
	
	@Test(priority=2)
    public void blrToDel() throws InterruptedException {
    	driver.get("https://www.spicejet.com");
    	
    	WebElement fromInput = driver.findElement(By.xpath("(//input[@class=\"css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu\"])[1]"));
    	fromInput.sendKeys("Be");
    	
    	// Getting list of all WebElements which we get on this dynamic dropDown when we send "Be"
    	List<WebElement> fromPlaces = driver.findElements(By.xpath("//div[@class=\"css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3\"]/div/div/div/div"));
    	for(WebElement place : fromPlaces) {
    		if(place.getText().equals("Bengaluru")) {
    			System.out.println(place.getText());
    			place.click();
    			break;
    		}
    	}
    	
    	WebElement toInput = driver.findElement(By.xpath("(//input[@class=\"css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu\"])[2]"));
    	toInput.sendKeys("De");	
    	
    	// Getting list of all WebElements which we get on this dynamic dropDown when we send "De"
    	List<WebElement> toPlaces = driver.findElements(By.xpath("//div[@class=\"css-1dbjc4n r-19yat4t r-1rt2jqs\"]/div/div/div/div/div"));
    	for(WebElement place : toPlaces) {
    		if(place.getText().equals("Delhi")) {
    			System.out.println(place.getText());
    			place.click();
    			break;
    		}
    	}
    }
	
	@AfterMethod
	 public void tearDown () {
		 driver.quit();
	 } 
}
