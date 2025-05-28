import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class Test13_ReadingCSV {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Read login credentials from CSV file
        String csvFilePath = "credentials.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            br.readLine(); // Skip header row

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String username = values[0].trim();
                String password = values[1].trim();

                // Automate login
                driver.get("https://www.w3schools.com/");
                driver.findElement(By.id("login")).click(); // Adjust selector based on the actual login button
                
                driver.findElement(By.name("username")).sendKeys(username);
                driver.findElement(By.name("password")).sendKeys(password);
                driver.findElement(By.id("loginBtn")).click(); // Adjust based on actual button

                // Assert login success (Modify as per actual UI elements)
                try {
                    WebElement profileElement = driver.findElement(By.className("profile-icon")); // Example
                    System.out.println("Login successful for: " + username);
                } catch (NoSuchElementException e) {
                    System.out.println("Login failed for: " + username);
                }

                driver.navigate().refresh(); // Prepare for next login attempt
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close browser
        driver.quit();
    }
}