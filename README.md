# Software Engineering 2 — Sections

Faculty of Computers and Information, Menoufia University · 1st term 2026–2027
Eng. Mohamed Shehab

Slides, lab sheets and the Selenium project for every section. A new week is added after each section.

## Get it

**With Git** (recommended — you only clone once):

```bash
git clone https://github.com/MohamedShehab280/se2-sections.git
```

Then every week:

```bash
git pull
```

**Without Git:** the green **Code** button at the top of this page › **Download ZIP**.

## One branch per week

`main` always has the latest week. Each week also has its own branch, with the project exactly as it
was at the end of that section:

| Week | Branch | Topic | Slides | Code |
|---|---|---|---|---|
| 3 | [`week-03`](../../tree/week-03) | Defect Reports and First Selenium Script | [slides](week-03/Week%203%20-%20Defect%20Reports%20and%20First%20Selenium%20Script.pptx) | [`week3`](selenium-project/src/test/java/week3) |
| 4 | [`week-04`](../../tree/week-04) | Locators | [slides](week-04/Week%204%20-%20Locators%20and%20Assertions.pptx) | [`week4`](selenium-project/src/test/java/week4) |

To move to a week's branch after cloning:

```bash
git checkout week-03
```

Recordings of every section: [YouTube playlist](https://www.youtube.com/playlist?list=PLKnIp8idj8qM)

## The task for weeks 3 and 4

**[Weeks 3-4 - Lab Sheet.docx](week-04/Weeks%203-4%20-%20Lab%20Sheet.docx)** — download it and fill it in
Word ([PDF](week-04/Weeks%203-4%20-%20Lab%20Sheet.pdf) to read). One task, three parts:

| Part | What you do |
|---|---|
| A | Test saucedemo.com by hand: find the 8 defects of problem_user (the first is done for you), and write a full report for one |
| B | Write `ShopVisit`: navigation, window sizes, tabs and priorities |
| C | Six locators from DevTools, then `ShopOrder`: automate an order from login to Generate PDF |

Parts B and C are written in a ready project on the **[`java-task`](../../tree/java-task)** branch:

```bash
git checkout java-task
```

**This repo is for reading. Do not submit here.**

## The Selenium project

[`selenium-project/`](selenium-project/) is one Maven project that grows every week: a package per
week (`week3`, `week4`, …) with the code from that section. How to open and run it is in its own
[README](selenium-project/README.md).

It also has a **practice site** — nine local pages with every kind of element to practise on, each with Java hints: [`selenium-project/src/test/resources/practice-site`](selenium-project/src/test/resources/practice-site/index.html).

## Questions

mohamed.shehab.fci@gmail.com · Telegram @shebo280
