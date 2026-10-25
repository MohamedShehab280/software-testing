package week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class Step06_Actions {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(new File("src/test/resources/practice-site/forms.html").toURI().toString());
        pause();
    }

    @Test(priority = 1)
    public void typeAndClear() {
        driver.findElement(By.id("first-name")).sendKeys("Aly");
        pause();
        driver.findElement(By.id("first-name")).clear();
        pause();
        driver.findElement(By.id("first-name")).sendKeys("Ali");
        pause();
    }

    @Test(priority = 2)
    public void readBack() {
        System.out.println("getText():              [" + driver.findElement(By.id("first-name")).getText() + "]");
        System.out.println("getAttribute(\"value\"): [" + driver.findElement(By.id("first-name")).getAttribute("value") + "]");
    }

    @Test(priority = 3)
    public void stateOfElements() {
        System.out.println("Disabled field enabled?  " + driver.findElement(By.id("disabled-field")).isEnabled());
        System.out.println("First name displayed?    " + driver.findElement(By.id("first-name")).isDisplayed());
    }

    @Test(priority = 4)
    public void clickAndReadResult() {
        driver.findElement(By.id("save-btn")).click();
        pause();
        System.out.println("Result: " + driver.findElement(By.id("form-result")).getText());
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
