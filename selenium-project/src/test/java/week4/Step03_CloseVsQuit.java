package week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Step03_CloseVsQuit {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(new File("src/test/resources/practice-site/forms.html").toURI().toString());
        pause();
    }

    @Test
    public void closeOneTab() {
        String first = driver.getWindowHandle();
        driver.findElement(By.linkText("Open the Waits page in a new tab")).click();
        System.out.println("Before close(): " + driver.getWindowHandles().size() + " tabs");
        pause();

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(first)) {
                driver.switchTo().window(handle);
            }
        }
        pause();
        driver.close();
        System.out.println("After close():  " + driver.getWindowHandles().size() + " tab");
        pause();

        driver.switchTo().window(first);
        System.out.println("Still open: " + driver.getTitle());
        pause();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    private void pause() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
