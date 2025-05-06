package polarisweb.QAMajorProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test04_SelectClass {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_select");
    }

    @Test
    public void automateDropdownUsingSelect() {
        try {
            // Switch to iframe (W3Schools editor)
            driver.switchTo().frame("iframeResult");

            // Locate the dropdown element
            WebElement dropdown = driver.findElement(By.xpath("//select"));

            // Initialize Select class
            Select select = new Select(dropdown);

            // Select by visible text
            select.selectByVisibleText("Volvo");

            // Select by index
            select.selectByIndex(2); // Selects "Opel"

            // Select by value attribute
            select.selectByValue("audi");

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

