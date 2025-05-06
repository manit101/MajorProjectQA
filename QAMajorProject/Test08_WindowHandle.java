package polarisweb.QAMajorProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Test08_WindowHandle {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");
    }

    @Test
    public void automateWindowHandling() {
        try {
            // Store main window handle
            String mainWindow = driver.getWindowHandle();
            
            // Open a new window/tab by clicking "Try it Yourself"
            WebElement tryItButton = driver.findElement(By.xpath("//a[contains(text(),'Try it Yourself')]"));
            tryItButton.click();

            // Get all window handles
            Set<String> allWindows = driver.getWindowHandles();
            
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(mainWindow)) {
                    // Switch to new window
                    driver.switchTo().window(windowHandle);
                    
                    // Perform actions in the new window
                    System.out.println("New Window Title: " + driver.getTitle());

                    // Close the new window
                    driver.close();
                }
            }

            // Switch back to the main window
            driver.switchTo().window(mainWindow);
            System.out.println("Back to Main Window: " + driver.getTitle());

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

