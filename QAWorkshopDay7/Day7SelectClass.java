package polarisweb.QAWorkshopDay7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day7SelectClass {

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
	public void selectClassAmazon() {
		driver.get("https://www.amazon.in/b?node=976419031");
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
		
		Select dropDown = new Select(staticDropdown);
		
		dropDown.selectByIndex(0); 
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		dropDown.selectByVisibleText("Amazon Fresh");
		System.out.println(dropDown.getFirstSelectedOption().getText());

		dropDown.selectByValue("search-alias=fashion");
		System.out.println(dropDown.getFirstSelectedOption().getText());
	}
	
	@Test(priority = 2)
	public void selectClassSearch() throws InterruptedException {
		driver.get("https://www.amazon.in/b?node=976419031");
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
		
		Select dropDown = new Select(staticDropdown);
		
		dropDown.selectByVisibleText("All Categories"); //Selecting All Categories
		System.out.println(dropDown.getFirstSelectedOption().getText());
	
		Thread.sleep(2000);
		
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.sendKeys("Batman");
		searchBar.sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		
		WebElement firstAllSearch = driver.findElement(By.xpath("(//h2[@class=\"a-size-base-plus a-spacing-none a-color-base a-text-normal\"]/span)[1]"));
		String firstBatman = firstAllSearch.getText();
		
		WebElement staticDropdownTwo = driver.findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
		Select dropDownTwo = new Select(staticDropdownTwo);
		dropDownTwo.selectByVisibleText("Books");
		System.out.println(dropDownTwo.getFirstSelectedOption().getText());
		
		WebElement searchBarTwo = driver.findElement(By.id("twotabsearchtextbox"));
		searchBarTwo.clear();
		searchBarTwo.sendKeys("batman");
		searchBarTwo.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		WebElement firstBooks = driver.findElement(By.xpath("(//h2[@class=\"a-size-medium a-spacing-none a-color-base a-text-normal\"]/span)[1]"));
		String secondBatman = firstBooks.getText();
		
		System.out.println(firstBatman);
		System.out.println(secondBatman);
		Assert.assertNotEquals(firstBatman, secondBatman);
	}
	
	@Test(priority=3)
	public void selectClassFlipkart() throws InterruptedException {
		driver.get("https://www.flipkart.com/search?q=laptop&sid=6bo%2Cb5g&as=on&as-show=on&otracker=AS_QueryStore_HistoryAutoSuggest_1_3_na_na_na&otracker1=AS_QueryStore_HistoryAutoSuggest_1_3_na_na_na&as-pos=1&as-type=HISTORY&suggestionId=laptop%7CLaptops&requestId=6df323eb-8acd-4691-940b-0d28c435ea4c");
		WebElement minDropdown = driver.findElement(By.xpath("//div[@class=\"suthUA\"]/select"));
		WebElement maxDropdown = driver.findElement(By.xpath("//div[@class=\"tKgS7w\"]/select"));

		
		Select dropdownMin = new Select(minDropdown);
		Select dropdownMax = new Select(maxDropdown);

		Thread.sleep(2000);
		
		dropdownMin.selectByIndex(3);
		System.out.println(dropdownMin.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		
		dropdownMax.selectByVisibleText("₹60000");
		System.out.println(dropdownMax.getFirstSelectedOption().getText());
	}
	
	@Test(priority=4)
	public void listingAllCategory() {
		driver.get("https://www.amazon.in/b?node=976419031");
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
        Select dropDown = new Select(staticDropdown);

        List<WebElement> list = dropDown.getOptions();
        for (WebElement option : list) {
            System.out.println(option.getText());
        }
    }
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
	    Thread.sleep(2000);
		driver.quit();
	}
}
