import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test12_ReadingXlSX {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Read login credentials from Excel file
        String excelFilePath = "credentials.xlsx";
        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();

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