package polarisweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1NikeXPath {
	
	WebDriver driver;
	
	@Test (priority = 1)
	public void openBrowser() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver(); // We use ChromeDriver class to open Chrome web browser, need to create it's object to use it's methods
        driver.manage().window().maximize();
        driver.get("https://www.nike.com/in/w/new-3n82y"); //get method used to get the desired website to open on browser
    }
	
	@Test (priority = 2)
	public void searchXPath() {
		WebElement womenShoesXPath = driver.findElement(By.xpath("(//div[text()=\"Women's Shoes\"])[2]"));
		WebElement shortsFilterXPath = driver.findElement(By.xpath("//a[@href=\"https://www.nike.com/in/w/new-shorts-38fphz3n82y\"]"));
		WebElement hideFiltersXPath = driver.findElement(By.xpath("//span[@class=\"filters-btn__filter_text\"]"));
		WebElement SnkrsXPath = driver.findElement(By.xpath("(//div //a[@class=\"menu-hover-trigger-link\"])[5]")); // lik this we can write xpath after an xpath
		
		womenShoesXPath.click();
		shortsFilterXPath.click();
		hideFiltersXPath.click();
		SnkrsXPath.click();
	}
}