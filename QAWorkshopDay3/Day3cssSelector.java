package polarisweb.QAWorkshopDay3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day3cssSelector {
	
    WebDriver driver; 

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test (priority = 1)
    public void amazonCSSSelector() {
    	driver.get("https://www.amazon.in/s?k=watch&crid=C6UFJTYTF79R&sprefix=watch%2Caps%2C220&ref=nb_sb_noss_2");
    	// cssSelector is written in a same way as we write css
    	// for classes we need to add a "." and for IDs we need to add "#"
    	
    	
    	// We can give multiple classes to a tag using gaps like <div class = "class1 class2 class3"> </div>
    	
    	WebElement classCSS = driver.findElement(By.cssSelector(".s-image"));
    	// Selects all elements with the class "s-iamge", in this case these are the images of listed products
    	
    	WebElement idCSS = driver.findElement(By.cssSelector("#priceRefinements"));
    	// Selects the particular element with this id, in this case it is the price refinement bar

    	// cssSelector gives more count compared to xPath as it does not checks the HTML tag where as in xPath we have a specified tag
    	// This is only valid if single class is given to the element as then only we can search .class1 and //tag[@class="class1"]
    	// or else we need to provide complete list of classes for xPath which will be unfair.
    	
    	WebElement tagCssSelector = driver.findElement(By.cssSelector("i.s-image"));
    	WebElement divTagCssSelectorClass = driver.findElement(By.cssSelector("div.sg-col-inner"));
    	WebElement divTagCssSelectorID = driver.findElement(By.cssSelector("div#departments"));
    	// searches for particular class in the given tag only
    	
    
    	WebElement attributeCssSelector = driver.findElement(By.cssSelector("input[class=nav-progressive-attribute]"));
    	WebElement attributeCssSelector2 = driver.findElement(By.cssSelector("div[cel_widget_id=Navigation-desktop-navbar]"));

    	// We can also use cssSelector for any other attributes also other then class and id
    }
    
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
    	Thread.sleep(2000);
        driver.quit();
    }
}
