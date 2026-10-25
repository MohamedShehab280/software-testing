package week3;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationDemo {
    WebDriver driver;

    @BeforeTest
    public void prepare() {
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void navigation() {
        driver.get("https://www.saucedemo.com/");
        pause();
        driver.get("https://www.selenium.dev/");
        pause();
        driver.navigate().back();
        System.out.println("after back():    " + driver.getCurrentUrl());
        pause();
        driver.navigate().forward();
        System.out.println("after forward(): " + driver.getCurrentUrl());
        pause();
        driver.navigate().to("https://www.saucedemo.com/");
        pause();
        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void window() {
        driver.manage().window().maximize();
        pause();
        driver.manage().window().setSize(new Dimension(800, 600));
        pause();
        driver.manage().window().setPosition(new Point(100, 100));
        pause();
        driver.manage().window().fullscreen();
        pause();
        driver.manage().window().minimize();
        pause();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    private void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
