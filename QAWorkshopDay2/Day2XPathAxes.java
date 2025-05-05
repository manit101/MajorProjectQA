package polarisweb.QAWorkshopDay2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2XPathAxes {
	
	WebDriver driver;
	
	
	@Test (priority = 1)
	public void openBrowser() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
	}
	
	//Find parent of a checkbox text in sidebar using axes
	@Test (priority = 2)
	public void axesXPath() {
		WebElement checkboxParent = driver.findElement(By.xpath("(//span[@class=\"a-size-base a-color-base\"])[4]/parent::*"));
		WebElement bannerTitleParent = driver.findElement(By.xpath("(//span[@class=\"sl-sobe-carousel-sub-card-title\"])[18]/parent::*"));
		WebElement bannerTitleAncestorDiv = driver.findElement(By.xpath("(//span[@class=\"sl-sobe-carousel-sub-card-title\"])[18]/ancestor::div"));
		WebElement bannerDescendantDiv = driver.findElement(By.xpath("//div[@id=\"sobe_d_b_ms_12-carousel\"]/descendant::div"));
		WebElement bannerDescendantBtn = driver.findElement(By.xpath("//div[@id=\"sobe_d_b_ms_12-carousel\"]/descendant::button"));
		WebElement bannerFollowingBtn = driver.findElement(By.xpath("//div[@id=\\\"sobe_d_b_ms_12-carousel\\\"]/following::button"));
		WebElement bannerPrecedingBtn = driver.findElement(By.xpath("//div[@id=\\\"sobe_d_b_ms_12-carousel\\\"]/preceding::button"));

	}
	
	
	@Test (priority = 3)
	public void closeBrowser() {
		driver.quit();
	}
}
