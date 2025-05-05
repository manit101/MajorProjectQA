# CSS Selector
- CSS Selectors are patterns used to select and style HTML elements.
- In automation (e.g., Selenium), they are used as an alternative to XPath to locate elements.
- In HTML, we can assign multiple classes to a tag by separating them with spaces, e.g., `<div class="class1 class2 class3">`.

## Example Selectors

| Selector Type     | Syntax                | Example                       |
|------------------|----------------------|------------------------------|
| **Tag**         | `tagname`             | `input`                      |
| **ID**          | `#id`                 | `#username`                   |
| **Class**       | `.class`              | `.btn-primary`                |
| **Attribute**   | `[attr='value']`      | `input[name='email']`        |
| **Class + Attribute** | `.class[attr='value']` | `.form-control[type='text']` |
| **Descendant**  | `parent child`        | `div p`                      |
| **Direct Child** | `parent > child`     | `ul > li`                    |

> **Note:** XPath is generally preferred over CSS Selectors as it allows traversing upwards through parent elements, which is not possible in CSS Selectors.

# Introduction to WebDriver
- **WebDriver** is an **interface** provided by Selenium for automating web application testing.
- It allows direct communication with browsers like Chrome, Firefox, Edge, etc.

## Different Types of Locators

| Locator         | Description                      | Example                                       |
|----------------|----------------------------------|----------------------------------------------|
| **id**         | Finds element by unique ID      | `driver.findElement(By.id("email"))`        |
| **name**       | Finds element by name attribute | `driver.findElement(By.name("q"))`          |
| **className**  | Finds element by class name     | `driver.findElement(By.className("btn"))`   |
| **tagName**    | Finds elements by tag          | `driver.findElement(By.tagName("a"))`       |
| **linkText**   | Finds link by its text         | `driver.findElement(By.linkText("Home"))`   |
| **partialLinkText** | Finds link by partial text  | `driver.findElement(By.partialLinkText("Read"))` |
| **cssSelector** | Finds element using CSS selector | `driver.findElement(By.cssSelector(".login"))` |
| **xpath**      | Finds element using XPath      | `driver.findElement(By.xpath("//input"))`   |

> **Important:** `XPath` is more powerful as it allows dynamic traversal of the DOM, including navigating **backwards** to parent elements, which is not possible with `cssSelector`.

## WebDriver Methods

| Method               | Description                                   | Example                                      |
|----------------------|---------------------------------------------|----------------------------------------------|
| **get(String url)**  | Opens a specific URL                        | `driver.get("https://google.com")`         |
| **getTitle()**       | Returns the page title                      | `driver.getTitle()`                         |
| **getCurrentUrl()**  | Returns the current URL                     | `driver.getCurrentUrl()`                    |
| **getPageSource()**  | Returns the source code of the page         | `driver.getPageSource()`                    |
| **navigate().to(url)** | Navigate to a URL                         | `driver.navigate().to("url")`               |
| **navigate().back()** | Goes back in browser history              | `driver.navigate().back()`                  |
| **navigate().forward()** | Moves forward in browser history       | `driver.navigate().forward()`               |
| **navigate().refresh()** | Refreshes the current page             | `driver.navigate().refresh()`               |
| **close()**          | Closes the current browser window           | `driver.close()`                            |
| **quit()**           | Closes all browser windows opened by WebDriver | `driver.quit()`                           |

> **Note:** `ChromeDriver` is a **class** that provides the concrete implementation for WebDriver when interacting specifically with Chrome.

## WebElement Methods

| Method              | Description                                  | Example                                  |
|--------------------|----------------------------------------------|------------------------------------------|
| **sendKeys("text")** | Enters text into an input field           | `element.sendKeys("Kshitiz")`           |
| **click()**        | Clicks the element                          | `element.click()`                        |
| **getText()**      | Retrieves visible text of the element       | `element.getText()`                      |
| **getAttribute("attr")** | Gets the value of the specified attribute | `element.getAttribute("value")`         |
| **isDisplayed()**  | Checks if the element is visible            | `element.isDisplayed()`                  |
| **isEnabled()**    | Checks if the element is enabled            | `element.isEnabled()`                    |
| **isSelected()**   | Checks if checkbox/radio is selected        | `element.isSelected()`                   |
| **clear()**        | Clears text from input field                | `element.clear()`                        |
| **submit()**       | Submits a form                              | `element.submit()`                       |

> **Note:** `WebElement` is an **interface** that provides methods for interacting with elements on the web page.

