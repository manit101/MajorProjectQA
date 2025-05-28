import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test11_Screenshot {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void captureErrorScreenshot() {
        try {
            // Open W3Schools
            driver.get("https://www.w3schools.com/");
            
            // Simulating an error by searching for a non-existent element
            WebElement errorElement = driver.findElement(By.id("invalidElement"));
            
        } catch (NoSuchElementException e) {
            System.out.println("Error detected: " + e.getMessage());
            
            // Take Screenshot on error
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            // Save Screenshot
            try {
                FileUtils.copyFile(screenshot, new File("ErrorScreenshot.png"));
                System.out.println("Screenshot of error captured successfully!");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}