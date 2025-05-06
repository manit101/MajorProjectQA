package polarisweb.QAMajorProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test07_AlertsFrame {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
    }

    @Test
    public void automateJavaScriptAlerts() {
        try {
            // Switch to iframe (W3Schools editor)
            driver.switchTo().frame("iframeResult");

            // Locate and click the "Try it" button to trigger alert
            WebElement tryItButton = driver.findElement(By.xpath("//button[text()='Try it']"));
            tryItButton.click();
            Thread.sleep(2000);

            // Handle **Alert** pop-up
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Message: " + alert.getText());
            alert.accept(); // Clicks "OK"

            // Navigate to Confirmation Alert example
            driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
            driver.switchTo().frame("iframeResult");
            WebElement confirmButton = driver.findElement(By.xpath("//button[text()='Try it']"));
            confirmButton.click();
            Thread.sleep(2000);

            // Handle **Confirmation Alert**
            Alert confirmAlert = driver.switchTo().alert();
            System.out.println("Confirmation Alert Message: " + confirmAlert.getText());
            confirmAlert.dismiss(); // Clicks "Cancel"

            // Navigate to Prompt Alert example
            driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
            driver.switchTo().frame("iframeResult");
            WebElement promptButton = driver.findElement(By.xpath("//button[text()='Try it']"));
            promptButton.click();
            Thread.sleep(2000);

            // Handle **Prompt Alert**
            Alert promptAlert = driver.switchTo().alert();
            System.out.println("Prompt Alert Message: " + promptAlert.getText());
            promptAlert.sendKeys("Hello, W3Schools Automation!");
            promptAlert.accept(); // Clicks "OK"

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

