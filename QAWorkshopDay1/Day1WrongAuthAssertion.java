package polarisweb.QAWorkshopDay1;

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
		WebElement signupBtn = driver.findElement(By.xpath("//a[@class=\"interactive-profile-element profile-link\"]"));
		signupBtn.click();
		
		WebElement emailBox = driver.findElement(By.xpath("//input[@id=\"username\"]"));
		emailBox.sendKeys("dapac62803@cyluna.com");
		
		Thread.sleep(2000);
		
		WebElement continueBtn = driver.findElement(By.xpath("//button[@class=\"nds-btn css-hj7pkf btn-primary-dark  btn-md\"]"));
		continueBtn.click();
		
		Thread.sleep(5000);
		
		WebElement passInput = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		passInput.sendKeys("passInputXPath");
		
		Thread.sleep(2000);
		System.out.println("Hello");
		
		WebElement invalidId = driver.findElement(By.xpath("(//div[@class=\"css-xkocxm\"]//div)[2]"));
		System.out.println(invalidId.getText());
		
		Assert.assertEquals(invalidId.getText(), "Your credentials are invalid");
	}
	
	@Test (priority = 3)
	public void closeBrowser() {
		driver.quit();
	}
}
