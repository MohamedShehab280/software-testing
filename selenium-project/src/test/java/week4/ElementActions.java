package week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {
    private final WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getAttribute(By locator, String name) {
        return driver.findElement(locator).getAttribute(name);
    }

    public boolean isDisplayed(By locator) {
        return !driver.findElements(locator).isEmpty() && driver.findElement(locator).isDisplayed();
    }

    public int count(By locator) {
        return driver.findElements(locator).size();
    }
}
