package week3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageInfoDemo {
    WebDriver driver;

    @BeforeTest
    public void prepare() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void readThePage() {
        String url    = driver.getCurrentUrl();
        String title  = driver.getTitle();
        String html   = driver.getPageSource();
        String handle = driver.getWindowHandle();

        System.out.println("URL:    " + url);
        System.out.println("Title:  " + title);
        System.out.println("HTML:   " + html.length() + " characters");
        System.out.println("Handle: " + handle);

        Assert.assertEquals(title, "Swag Labs");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
