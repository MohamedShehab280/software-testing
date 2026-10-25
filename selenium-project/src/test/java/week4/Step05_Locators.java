package week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Step05_Locators {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(new File("src/test/resources/practice-site/forms.html").toURI().toString());
        pause();
    }

    @Test(priority = 1)
    public void byIdAndName() {
        driver.findElement(By.id("first-name")).sendKeys("Ali");
        pause();
        driver.findElement(By.name("lastName")).sendKeys("Hassan");
        pause();
    }

    @Test(priority = 2)
    public void byClassAndTag() {
        System.out.println("Green button: " + driver.findElement(By.className("btn-success")).getText());
        System.out.println("Inputs on the page: " + driver.findElements(By.tagName("input")).size());
        pause();
    }

    @Test(priority = 3)
    public void byLinkText() {
        System.out.println(driver.findElement(By.linkText("Go to the Dropdowns page")).getAttribute("href"));
        System.out.println(driver.findElement(By.partialLinkText("Tables")).getText());
        pause();
    }

    @AfterTest
    public void closeBrowser() {
        pause();
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
