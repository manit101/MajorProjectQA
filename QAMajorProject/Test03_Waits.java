package polarisweb.QAMajorProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Test03_Waits {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");

        // **Implicit Wait**
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void automateUsingWaits() {
        try {
            // **Explicit Wait** Example - Waiting for "Learn HTML" Link to be Clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement htmlLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Learn HTML']")));
            htmlLink.click();

            // **Explicit Wait** Example - Waiting for "Try it Yourself" button
            WebElement tryItButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Try it Yourself')]")));
            tryItButton.click();

            // **Fluent Wait** Example - Waiting for Editor to be Present
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            WebElement codeEditor = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id='textareaCode']")));
            codeEditor.clear();
            codeEditor.sendKeys("<h1>Hello, W3Schools Automation with Waits!</h1>");

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
