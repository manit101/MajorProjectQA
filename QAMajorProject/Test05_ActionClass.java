package polarisweb.QAMajorProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test05_ActionClass {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");
    }

    @Test
    public void automateUsingActionsClass() {
        try {
            Actions actions = new Actions(driver);

            // **Hover over the "Tutorials" menu**
            WebElement tutorialsMenu = driver.findElement(By.xpath("//a[@id='navbtn_tutorials']"));
            actions.moveToElement(tutorialsMenu).perform();
            Thread.sleep(2000); // Pause to see hover effect

            // **Right-click on the "Learn HTML" link**
            WebElement htmlLink = driver.findElement(By.xpath("//a[text()='Learn HTML']"));
            actions.contextClick(htmlLink).perform();
            Thread.sleep(2000);

            // **Double-click on an element (Example on W3Schools)**
            driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
            driver.switchTo().frame("iframeResult");
            WebElement doubleClickButton = driver.findElement(By.xpath("//p[@ondblclick='myFunction()']"));
            actions.doubleClick(doubleClickButton).perform();
            Thread.sleep(2000);

            // **Drag and drop (Example on W3Schools)**
            driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");
            driver.switchTo().frame("iframeResult");
            WebElement source = driver.findElement(By.id("drag1"));
            WebElement target = driver.findElement(By.id("div1"));
            actions.dragAndDrop(source, target).perform();
            Thread.sleep(2000);

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

