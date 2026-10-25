package week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

public class Step02_WindowHandles {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(new File("src/test/resources/practice-site/forms.html").toURI().toString());
        pause();
    }

    @Test
    public void allOpenTabs() {
        String first = driver.getWindowHandle();
        System.out.println("This tab: " + first);

        driver.findElement(By.linkText("Open the Waits page in a new tab")).click();
        pause();

        Set<String> all = driver.getWindowHandles();
        System.out.println("Open tabs: " + all.size());

        for (String handle : all) {
            driver.switchTo().window(handle);
            System.out.println(handle + "  ->  " + driver.getTitle());
            pause();
        }

        driver.switchTo().window(first);
        System.out.println("Back on: " + driver.getTitle());
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
