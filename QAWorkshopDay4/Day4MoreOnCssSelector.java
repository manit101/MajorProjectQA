package polarisweb.QAWorkshopDay4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day4MoreOnCssSelector {

    WebDriver driver; 

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test (priority = 1)
    public void testFunc() throws InterruptedException {
    	driver.get("https://www.amazon.in/s?rh=n%3A1375424031%2Cp_123%3A308445&dc&pf_rd_i=1375424031&pf_rd_m=A1VBAL9TL5WCBF&pf_rd_p=b2755823-01da-4553-a2d9-690e44a54b58&pf_rd_r=DQQW1VNKJKW18QX159YK&pf_rd_s=merchandised-search-26&qid=1738154218&rnid=91049095031&ref=sr_nr_p_123_0");
    	
    	WebElement startsWithCssSelector = driver.findElement(By.cssSelector("div[class^=nav-sprite-v1]"));
    	// div[class^="nav"]       (^= startsWith)
    	// gives all the div with class starting from "nav"
    	
    	WebElement endsWithCssSelector = driver.findElement(By.cssSelector("img[src$=png]"));
    	// img[src$=".png"]       ($= endsWith)
    	// gives all img with src ending with "png"
    	// useful to get elements with a specific extension
    	
    	WebElement matchesAWholeWordCssSelector = driver.findElement(By.cssSelector("button[class~=nav-icon]"));
    	// button[class~=nav-icon]       (~= matchesAWholeWord)
    	// gives all button with class having "nav-icon" only in between them 
    	
    	WebElement containsCssSelector = driver.findElement(By.cssSelector("div[class*=nav]"));
    	// div[class*=nav]       (*= contains)
    	// gives all div with class having "nav" in between or at start or at the end of them 
    	
    	WebElement childCombinatorCssSelector = driver.findElement(By.cssSelector("div > button"));
    	// div > button       (> childCombinator)
    	// gives all direct child button inside a div, button with div as direct parent
    	
    	
    	// Find path of checkbox text under "Specific Uses" section going from parent to child using cssSelector
    	WebElement speficUsesStudentOption = driver.findElement(By.cssSelector("div > div > ul > span.a-declarative > span > li > span.a-list-item > a[href$=WZs] >  span"));
    }

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
	    driver.quit();
	}
}
