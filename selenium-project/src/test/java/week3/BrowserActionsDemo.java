package week3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class BrowserActionsDemo {
    WebDriver driver;

    BrowserActions browser;

    @BeforeTest
    public void prepare() {
        driver = new ChromeDriver();

        browser = new BrowserActions(driver);
    }

    @Test(priority = 1)
    public void navigation() {
        browser.openPage("https://www.saucedemo.com/");
        browser.pause(1);
        browser.navigation("https://www.selenium.dev/");
        browser.pause(1);
        browser.navigateBack();
        browser.pause(1);
        browser.navigateForward();
        browser.pause(1);
        browser.refresh();
        Set<String> windowHandles = browser.getWindowHandles();
    }

    @Test(priority = 2)
    public void devices() {
        browser.iPhoneDimension();
        browser.pause(2);
        browser.iPadDimension();
        browser.pause(2);
        browser.setPosition(100, 100);
        browser.pause(1);
        browser.maximize();
        browser.pause(1);
        browser.fullScreen();
        browser.pause(1);
    }

    @Test(priority = 3)
    public void tabs() {
        String firstTab = browser.getWindowHandle();
        System.out.println("first tab:  " + firstTab);

        browser.openNewTab();
        browser.pause(1);
        browser.openPage("https://www.selenium.dev/");
        String secondTab = browser.getWindowHandle();
        System.out.println("second tab: " + secondTab);
        System.out.println("open tabs:  " + browser.getWindowHandles().size());
        browser.pause(2);

        browser.closeTab();
        browser.switchToWindow(firstTab);
        System.out.println("back on:    " + browser.getTitle());
    }


}
