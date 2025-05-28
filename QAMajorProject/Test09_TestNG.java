import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Test09_TestNG {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Setting up database...");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test: Setting up browser config...");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class: Initializing WebDriver...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: Navigating to W3Schools...");
        driver.get("https://www.w3schools.com/");
    }

    @Test(priority = 1, description = "Verify Learn HTML navigation", invocationCount = 2)
    public void testLearnHTMLLink() {
        System.out.println("Test: Clicking Learn HTML...");
        WebElement htmlLink = driver.findElement(By.linkText("Learn HTML"));
        htmlLink.click();

        String expectedTitle = "HTML Tutorial";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }

    @Test(priority = 2, dependsOnMethods = "testLearnHTMLLink", expectedExceptions = NullPointerException.class)
    public void testExceptionHandling() {
        System.out.println("Test: Checking exception handling...");
        String str = null;
        str.length();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: Cleaning up test-specific data...");

    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class: Closing browser...");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test: Cleanup test-specific resources...");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: Closing database connections...");
    }
}