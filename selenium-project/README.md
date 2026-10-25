# Selenium project

Every piece of code from the sections, in one Maven project.

## What you need

- **Java** 11 or newer
- **IntelliJ IDEA** (Community is enough)
- **Google Chrome**

You do **not** need to download ChromeDriver or any `.jar` by hand. Maven downloads Selenium and
TestNG, and Selenium downloads the Chrome driver by itself the first time you run a test.

## Open it

1. IntelliJ › **File › Open** › choose `pom.xml` › **Open as Project**.
2. Wait for Maven to finish downloading (the progress bar at the bottom right). The first time needs internet.
3. Open any class with a green ▶ next to its name and click it. To run all of them: right-click
   `testng.xml` › **Run**.

Each week has the code from that section.

## Week 3 — the browser

| File | What it shows |
|---|---|
| `FirstProject` | The shape of a test: `@Test`, open Chrome, go to a page, print the title, close. |
| `NavigationDemo` | `get()` and `navigate().to()`, back, forward and refresh, then window sizes: maximize, minimize, fullscreen, size and position. |
| `PageInfoDemo` | Reading the page: title, URL, page source and the window handle. |
| `BrowserActions` | Every browser command from the section, each behind a method with a clear name: navigation, window size and position, page title and URL, tabs and handles, closing. It has no `@Test`, so it does not run on its own. |
| `BrowserActionsDemo` | The tests that use `BrowserActions`, in order with `priority`. |

## Your own project

Create your **own** Maven project in IntelliJ — do not just open this one. Add the two
dependencies to `pom.xml` and reload Maven:

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.43.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.12.0</version>
    </dependency>
</dependencies>
```

## If something does not work

| Problem | Fix |
|---|---|
| Red `Cannot resolve symbol` everywhere | Maven is still downloading. Wait, or right-click `pom.xml` › **Maven › Reload project**. |
| `SessionNotCreatedException` | Chrome is not installed, or this is the first run and there is no internet to download the driver. |
| The `java` folder under `test` is not green | Right-click it › **Mark Directory as › Test Sources Root**. |
