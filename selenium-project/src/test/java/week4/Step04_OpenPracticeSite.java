package week4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Step04_OpenPracticeSite {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void openFromResources() {
        File website = new File("src/test/resources/practice-site/forms.html");
        System.out.println("Opening: " + website.toURI());
        driver.get(website.toURI().toString());
        System.out.println("Title: " + driver.getTitle());
        pause();
        pause();
    }

    @Test(priority = 2)
    public void openWithoutHints() {
        driver.get(new File("src/test/resources/practice-site/forms.html").toURI() + "?hints=off");
        pause();
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
