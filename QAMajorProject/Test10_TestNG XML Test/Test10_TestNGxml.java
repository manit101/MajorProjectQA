import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Test10_TestNGxml {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Setting up database...");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test: Setting up browser properties...");
    }

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser) {
        System.out.println("Before Class: Initializing WebDriver for browser: " + browser);
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: Navigating to W3Schools...");
        driver.get("https://www.w3schools.com/");
    }

    @Test(priority = 1, description = "Verify Learn HTML navigation", groups = {"smoke", "regression"})
    public void testLearnHTMLLink() {
        System.out.println("Test: Clicking Learn HTML...");
        WebElement htmlLink = driver.findElement(By.linkText("Learn HTML"));
        htmlLink.click();
        Assert.assertEquals(driver.getTitle(), "HTML Tutorial", "Title does not match!");
    }

    @Test(priority = 2, dataProvider = "userData", groups = "regression")
    public void testDynamicSearch(String searchItem) {
        System.out.println("Test: Performing search for - " + searchItem);
        WebElement searchBox = driver.findElement(By.id("search2"));
        searchBox.sendKeys(searchItem);
        searchBox.submit();
        Assert.assertTrue(driver.getTitle().contains("Search"), "Search failed!");
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][]{
            {"HTML"},
            {"CSS"},
            {"JavaScript"}
        };
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: Cleaning test-specific data...");
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
        System.out.println("After Test: Cleanup test resources...");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: Closing database connections...");
    }
}