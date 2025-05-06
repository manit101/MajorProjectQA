package polarisweb.QAMajorProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test06_JSExecutor {
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");
        
        // Initialize JavaScript Executor
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void automateUsingJSExecutor() {
        try {
            // **Scroll Down using JavaScript**
            js.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(2000);

            // **Scroll to a specific element**
            WebElement htmlLink = driver.findElement(By.xpath("//a[text()='Learn HTML']"));
            js.executeScript("arguments[0].scrollIntoView(true);", htmlLink);
            Thread.sleep(2000);

            // **Click element using JavaScript**
            js.executeScript("arguments[0].click();", htmlLink);
            Thread.sleep(2000);

            // **Change the background color of an element**
            js.executeScript("arguments[0].style.backgroundColor = 'yellow';", htmlLink);
            Thread.sleep(2000);

            // **Retrieve title using JavaScript**
            String pageTitle = (String) js.executeScript("return document.title;");
            System.out.println("Page Title: " + pageTitle);

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
