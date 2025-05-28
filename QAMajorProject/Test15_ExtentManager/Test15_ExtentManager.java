package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test15_ExtentManager {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setup() {
        // Initialize Extent Reports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("W3Schools Automation Test", "Automating W3Schools website interactions");

        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        test.info("Launching Chrome browser");

        // Navigate to W3Schools
        driver.get("https://www.w3schools.com/");
        test.pass("Navigated to W3Schools successfully");
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        String pageTitle = driver.getTitle();
        test.info("Page title retrieved: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("W3Schools Online Web Tutorials"), "Page title validation failed");
        test.pass("Page title validation successful");
    }

    @Test(priority = 2)
    public void verifyTryItEditorLink() {
        // Check if the "Try it Yourself" button is displayed
        boolean isDisplayed = driver.findElement(By.linkText("Try it Yourself")).isDisplayed();
        test.info("Try it Yourself button displayed: " + isDisplayed);
        Assert.assertTrue(isDisplayed, "Try it Yourself button is NOT visible.");
        test.pass("Try it Yourself button validation successful");
    }

    @Test(priority = 3)
    public void verifySearchFunctionality() {
        // Click search icon and enter a query
        driver.findElement(By.id("search2")).sendKeys("HTML Tutorial");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        test.info("Search functionality tested.");
        Assert.assertTrue(driver.getTitle().contains("HTML"), "Search results validation failed");
        test.pass("Search functionality validation successful");
    }

    @AfterClass
    public void tearDown() {
        // Close browser
        driver.quit();
        test.info("Closed browser");
        extent.flush(); // Generate report
    }
}