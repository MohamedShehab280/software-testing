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

Each week has two files, to show you the shape. The rest you write yourself in the lab sheet.

## The practice site

[`src/test/resources/practice-site/`](src/test/resources/practice-site/) is a small website that lives inside
this project: nine pages, one for each kind of element — forms, dropdowns, checkboxes and radio buttons,
tables, alerts and modals, waits, iFrames, file upload, and drag and drop. Every element has a hint with its
locators, in Java.

It sits in `src/test/resources`, the Maven folder for files your tests need. Open a page with its path from
the project folder — the same way as in the course:

```java
File website = new File("src/test/resources/practice-site/forms.html");
driver.get(website.toURI().toString());
```

Double-click `src/test/resources/practice-site/index.html` to look at it in Chrome first. The **Hide hints**
button at the top hides every hint; in code, add `?hints=off` to the address:

```java
driver.get(website.toURI() + "?hints=off");
```

## Week 3 — the browser

| File | What it shows |
|---|---|
| `FirstProject` | The shape of a test: `@Test`, open Chrome, go to a page, print the title, close. |
| `BrowserActions` | Every browser command from the section, each behind a method with a clear name: navigation, window size and position, page title and URL, tabs and handles, closing. It has no `@Test`, so it does not run on its own. Use it as a reference. |

## Week 4 — locators and assertions

| File | What it shows |
|---|---|
| `ElementActions` | Every element command behind a method: `type`, `click`, `getText`, `getAttribute`, `isDisplayed`, `count`. Like `BrowserActions`, it has no `@Test`. |
| `LoginTest` | Four real tests with asserts: a valid login, a wrong password, a locked-out user and an empty username. Uses `@BeforeMethod` so every test starts with a fresh browser. Run it: all four pass. |

Before you write a locator in code, test it in Chrome: **F12 › Elements › Ctrl + F**, type it, and
look for **1 of 1**.

## Your task

The [lab sheet for weeks 3 and 4](../week-04/Weeks%203-4%20-%20Lab%20Sheet.pdf). Do Parts B and C in
your **own** Maven project — create it yourself, do not just open this one. Add the two
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
