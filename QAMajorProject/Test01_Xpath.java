package polarisweb.QAMajorProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Test01_Xpath {
	
	
	    WebDriver driver;

	    @BeforeMethod
	    public void setup() {
	        // Initialize WebDriver
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.w3schools.com/");
	    }

	    @Test
	    public void automateW3Schools() {
	        try {
	            // Example: Click on "Learn HTML" using XPath
	            WebElement htmlLink = driver.findElement(By.xpath("//a[text()='Learn HTML']"));
	            htmlLink.click();

	            // Example: Click on "Try it Yourself" button in an example
	            WebElement tryItButton = driver.findElement(By.xpath("//a[contains(text(),'Try it Yourself')]"));
	            tryItButton.click();

	            // Example: Interact with the text box in the editor using XPath
	            WebElement codeEditor = driver.findElement(By.xpath("//textarea[@id='textareaCode']"));
	            codeEditor.clear();
	            codeEditor.sendKeys("<h1>Hello, W3Schools Automation!</h1>");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
