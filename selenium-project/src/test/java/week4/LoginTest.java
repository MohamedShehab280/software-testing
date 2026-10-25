package week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openLoginPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    private void login(String user, String password) {
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Test(priority = 1)
    public void validLogin() {
        login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(driver.findElement(By.className("title")).getText(), "Products");
    }

    @Test(priority = 2)
    public void wrongPassword() {
        login("standard_user", "wrong");
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 3)
    public void lockedOutUser() {
        login("locked_out_user", "secret_sauce");
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(error.contains("locked out"), "Expected a locked-out message, got: " + error);
    }

    @Test(priority = 4)
    public void emptyUsername() {
        login("", "secret_sauce");
        String error = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(error, "Epic sadface: Username is required");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
