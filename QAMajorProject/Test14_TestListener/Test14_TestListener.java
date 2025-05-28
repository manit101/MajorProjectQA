import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class) // Attach the Listener
public class Test14_TestListener {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
    }

    @Test
    public void verifyTitle() {
        String expectedTitle = "W3Schools Online Web Tutorials";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}