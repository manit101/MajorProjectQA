package polarisweb.QAWorkshopDay2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2TextXPathHandling {

	WebDriver driver;

	
	@Test (priority = 1)
	public void openBrowser() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
	}
	
	@Test (priority = 2)
	public void searchXPath() throws InterruptedException {
		driver.get("https://www.amazon.in/electronics/b/?ie=UTF8&node=976419031&ref_=nav_cs_electronics");
		
		WebElement laptopSectionXPath = driver.findElement(By.xpath("//img[@src=\"https://m.media-amazon.com/images/G/31/IMG24/Smart_Watches/ELP_revamp/laptop._SS400_QL85_.jpg\"]"));
		laptopSectionXPath.click();
		
		WebElement notebookLaptopXPath = driver.findElement(By.xpath("(//span[.=\"Notebook\"])[2]"));
	}
	
		// 1.
//		. dot function
//		//button[.="text"]
//		Used when we need to find test in nested childs like '<button> <p> text </p> </button>'
		
		// 2.
//		text function text()
//		//button[text()="text"]
//		used only for single attribute <button> text </button>
		
		// 3.
//		contains()
//		used if we need to check for partial string like from 'Get Here' we need to check 'ere'
//		//button[contains(text(),'ere')]         checks for 'ere' in text 
//		//button[contains(@class, 'ere')]        checks for 'ere' in class name	
	
	// Find XPath of laptop name using contains()
	@Test (priority = 3)

	public void textHandling() {
		WebElement laptopXPath = driver.findElement(By.xpath("//span[contains(text(),\"7320U\")]"));
	}
	
	@Test (priority = 4)
	public void closeBrowser() {
		driver.quit();
	}
}
