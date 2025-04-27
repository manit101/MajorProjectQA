package polarisweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1WrongAuthAssertion {
	
	WebDriver driver;
	
	@Test (priority = 1)
	public void openBrowser() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.nike.com/in/w/new-3n82y"); 
    }
	
	@Test (priority = 2)
	public void wrongLogIn() throws InterruptedException {
		WebElement signupBtnXPath = driver.findElement(By.xpath("//a[@class=\"interactive-profile-element profile-link\"]"));
		signupBtnXPath.click();
		
		WebElement emailBoxXPath = driver.findElement(By.xpath("//input[@id=\"username\"]"));
		emailBoxXPath.sendKeys("dapac62803@cyluna.com");
		
		Thread.sleep(2000);
		
		WebElement continueBtnXPath = driver.findElement(By.xpath("//button[@class=\"nds-btn css-hj7pkf btn-primary-dark  btn-md\"]"));
		continueBtnXPath.click();
		
		Thread.sleep(5000);
		
		WebElement passInputXPath = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		passInputXPath.sendKeys("passInputXPath");
		
		Thread.sleep(2000);
		System.out.println("Hello");
		
		WebElement invalidIdXPath = driver.findElement(By.xpath("(//div[@class=\"css-xkocxm\"]//div)[2]"));
		System.out.println(invalidIdXPath.getText());
		
		Assert.assertEquals(invalidIdXPath.getText(), "Your credentials are invalid");
	}
	
	@Test (priority = 3)
	public void closeBrowser() {
		driver.quit();
	}
}
