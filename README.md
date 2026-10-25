# Java task — weeks 3 and 4

Software Engineering 2 · Faculty of Computers and Information, Menoufia University
Eng. Mohamed Shehab

This branch is a ready Maven project for Parts B and C of the lab sheet. Everything is set up: you only
write the two classes. The lab sheet itself is on [`main`](../../tree/main/week-04).

## Get it

```bash
git clone https://github.com/MohamedShehab280/software-testing.git
cd software-testing
git checkout java-task
```

**Without Git:** choose `java-task` from the branch list at the top of this page, then **Code › Download ZIP**.

Open it in IntelliJ: **File › Open** › choose `pom.xml` › **Open as Project**, and wait for Maven.

## What is in it

| File | |
|---|---|
| `Setup.java` | Ready. `Setup.chrome()` opens Chrome in incognito, and `Setup.pause()` waits two seconds. |
| `ShopVisit.java` | Empty. **You write it** — Part B, Exercise 5. |
| `ShopOrder.java` | Empty. **You write it** — Part C, Exercise 6. |

All three are in `src/test/java/task`.

## Part B — `ShopVisit`

| Method | Annotation | What it does |
|---|---|---|
| `prepare` | `@BeforeTest` | `driver = Setup.chrome();` |
| `openShop` | `@Test(priority = 1)` | Opens https://www.saucedemo.com/ and prints the title and the URL |
| `goAndBack` | `@Test(priority = 2)` | `navigate().to("https://www.selenium.dev/")`, then back, then prints the title |
| `devices` | `@Test(priority = 3)` | Phone size (390 × 844), tablet size (1366 × 1024), then maximize, with `Setup.pause()` between |
| `newTab` | `@Test(priority = 4)` | Prints the window handle, opens a new tab with https://www.google.com/, prints the new handle |
| `tearDown` | `@AfterTest` | Closes the browser |

## Part C — `ShopOrder`

Place an order on saucedemo from start to end. Call `Setup.pause()` after every step.

| Method | Annotation | What it does |
|---|---|---|
| `prepare` | `@BeforeTest` | `driver = Setup.chrome();` |
| `login` | `@Test(priority = 1)` | Opens https://www.saucedemo.com/ and logs in as `standard_user` / `secret_sauce` |
| `addToCart` | `@Test(priority = 2)` | Add to cart on Sauce Labs Backpack, then opens the cart |
| `checkout` | `@Test(priority = 3)` | Checkout, first name, last name, postal code, Continue |
| `finish` | `@Test(priority = 4)` | Finish |
| `downloadPdf` | `@Test(priority = 5)` | Generate PDF order — the PDF lands in your Downloads folder |
| `tearDown` | `@AfterTest` | Closes the browser |

**Use `Setup.chrome()`, not `new ChromeDriver()`.** On saucedemo, Chrome shows a "password found in a data
breach" box after the login, and every click after it does nothing. In incognito that box does not appear.

Run a class with the green ▶ next to its name, or both with right-click `testng.xml` › **Run**.

**This repo is for reading. Do not submit here.**
