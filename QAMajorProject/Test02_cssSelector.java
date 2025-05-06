package polarisweb.QAMajorProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test02_cssSelector {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");
    }

    @Test
    public void automateUsingCSSSelectors() {
        try {
            // Click on "Learn HTML" using CSS Selector
            WebElement htmlLink = driver.findElement(By.cssSelector("a.w3-bar-item.w3-button[href='/html/']"));
            htmlLink.click();

            // Click on "Try it Yourself" button using CSS Selector
            WebElement tryItButton = driver.findElement(By.cssSelector("a.w3-button.w3-green"));
            tryItButton.click();

            // Interact with the text box in the editor using CSS Selector
            WebElement codeEditor = driver.findElement(By.cssSelector("textarea#textareaCode"));
            codeEditor.clear();
            codeEditor.sendKeys("<h1>Hello, W3Schools Automation with CSS!</h1>");
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
