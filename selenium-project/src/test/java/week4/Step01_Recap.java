package week4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Step01_Recap {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void openTheShop() {
        driver.get("https://www.saucedemo.com/");
        System.out.println("Title: " + driver.getTitle());
        pause();
    }

    @Test(priority = 2)
    public void goAndBack() {
        driver.navigate().to("https://www.selenium.dev/");
        pause();
        driver.navigate().back();
        System.out.println("After back: " + driver.getCurrentUrl());
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
