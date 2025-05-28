package polarisweb.QAWorkshopDay8;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day8SelectClass2 {

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
    public void singleSelect() throws InterruptedException {
        driver.get("https://selenium-select-practice.vercel.app/");
        WebElement single = driver.findElement(By.xpath("//select[@style=\"width: 100%; padding: 0.5rem; border-radius: 5px; border: 1px solid rgb(204, 204, 204); font-size: 1rem;\"]"));
        Select singleSelectDropdown = new Select(single);
        singleSelectDropdown.selectByIndex(2); 
        String singleSelect = singleSelectDropdown.getFirstSelectedOption().getText();
		System.out.println(singleSelect);
		
		Assert.assertEquals(singleSelect, "Green");
    }
	
	@Test(priority = 2)
    public void multiSelect() throws InterruptedException {
        driver.get("https://selenium-select-practice.vercel.app/");
        WebElement multi = driver.findElement(By.xpath("//select[@style=\"width: 100%; padding: 0.5rem; border-radius: 5px; border: 1px solid rgb(204, 204, 204); font-size: 1rem; height: 120px;\"]"));
        Select multiSelectDropdown = new Select(multi);
        multiSelectDropdown.selectByIndex(2); 
        multiSelectDropdown.selectByValue("CSS");
        multiSelectDropdown.selectByVisibleText("React");
        
        List<String> expectedlist = Arrays.asList("JavaScript","CSS","React");      
        List<WebElement> list = multiSelectDropdown.getAllSelectedOptions();
        
        for (WebElement option : list) {
            System.out.println(option.getText());
            String val = option.getText();
            Assert.assertTrue(expectedlist.contains(val), val);
        }   
        multiSelectDropdown.deselectByValue("CSS");
        List<WebElement> newList = multiSelectDropdown.getAllSelectedOptions();
        List<String> newExpectedlist = Arrays.asList("JavaScript","React"); 
        for (WebElement ele : newList) {
            System.out.println(ele.getText());
            String value = ele.getText();
            Assert.assertTrue(newExpectedlist.contains(value), value);        
        }
    }
	
	@Test(priority = 3)
    public void radioButton() throws InterruptedException {
        driver.get("https://selenium-select-practice.vercel.app/");
        
        WebElement radio = driver.findElement(By.xpath("//label/input[@value=\"Female\"]"));
        System.out.println(radio.getText());        
        radio.click();
        
		Assert.assertEquals(radio.isSelected(), true);
    }
	
	@Test(priority = 4)
    public void checkBox() throws InterruptedException {
        driver.get("https://selenium-select-practice.vercel.app/");
        
        WebElement check1 = driver.findElement(By.xpath("//input[@name=\"banana\"]"));       
        System.out.println(check1.getText());        
        check1.click();
		Assert.assertEquals(check1.isSelected(), true);
        
        WebElement check2 = driver.findElement(By.xpath("//input[@name=\"mango\"]"));       
        System.out.println(check2.getText());        
        check2.click();
		Assert.assertEquals(check2.isSelected(), true);
        
        WebElement check3 = driver.findElement(By.xpath("//input[@name=\"orange\"]"));       
        System.out.println(check3.getText());        
        check3.click();
		Assert.assertEquals(check3.isSelected(), true);
		
		check2.click();
		Assert.assertEquals(check2.isSelected(), false);
    }
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
	    Thread.sleep(2000);
		driver.quit();
	}
}
