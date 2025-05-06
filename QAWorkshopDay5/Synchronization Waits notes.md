# Synchronization Usage in Selenium

## 1. Thread.sleep()
### Explanation:
- It is a static wait provided by Java, not Selenium-specific.
- Pauses the execution for a fixed duration, irrespective of condition.
- This is a hard wait because it literally pauses the thread's execution for the specified time, preventing it from doing anything else.

### Syntax:
```java
Thread.sleep(3000); // sleeps for 3 seconds
```

### Pros:
- Very simple to use.
- Useful for debugging or fixed delays.

### Cons:
- Not dynamic; waits even if the element is already present.
- Leads to unnecessary delays, slowing down tests.
- Not recommended for production testing.

---

## 2. Implicit Wait
### Explanation:
- This is a **method** provided by the `Timeouts` interface which is part of Selenium's `WebDriver.Options` class.
- Applied globally to all elements.
- This works on presence of locators and if the locator is present then it will continue execution so no need to wait for whole time.
- It uses continuous polling for checking the presence of element every 500ms.
- Tells WebDriver to wait for a defined time before throwing `NoSuchElementException`.

### Syntax:
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

### Pros:
- Improves readability, easy to set once and apply globally.
- Reduces the need for repetitive wait code.

### Cons:
- Not optimized for error checking -> like if 9 test cases takes only about 3 seconds and one takes about 15 seconds to complete we will need to set it as 15 seconds. If any one out nine throws error we will have to wait for 15 seconds to know the error.
- It is not able to check clickablity, enablity, visibility, disappearance, content updates of element or dynamic content loading (elements that appear later due to JavaScript execution).
- Can cause issues when used with explicit waits (can lead to unexpected delays).
- Not flexible; doesn’t wait for specific conditions.

---

## 3. Explicit Wait
### Explanation:
- It is not set globally for all elements, only to the specific element and condition line by line.
- It also checks clickablity, enablity, visibility, disappearance, content updates of element or dynamic content loading.
- Waits for a certain condition to be true before proceeding.
- More flexible and condition-based.

### 3.1 WebDriverWait
#### Explanation:
- A type of explicit wait. (It is a Selenium Class)
- Part of Selenium support library. 
- Used to wait for specific conditions (like visibility, clickability, etc).

#### Syntax:
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.elementToBeClickable(By.id("button")));
```

#### Pros:
- Provides various pre-defined conditions using `ExpectedConditions`.
- Better handling of asynchronous elements.

#### Cons:
- Must be used with proper exception handling.
- Deprecated constructor in older Selenium versions (use with `Duration` in newer versions).

---

### 3.2 Fluent Wait
#### Explanation:
- A type of explicit wait. (It is a Selenium Class)
- You can define polling frequency and exception handling.
- Used for more complex waiting strategies.

#### Syntax:
```java
Wait<WebDriver> fluentWait = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(30))
    .pollingEvery(Duration.ofSeconds(5))
    .ignoring(NoSuchElementException.class);

WebElement element = fluentWait.until(driver -> driver.findElement(By.id("example")));
```

#### Pros:
- Gives full control over the waiting strategy.
- Ideal for handling dynamic and AJAX-heavy pages.

#### Cons:
- More verbose and complex to implement.
- Needs a good understanding of the condition to be checked.

---

### **Key Differences:**
| Feature               | `Thread.sleep()`                  | Implicit Wait                     | WebDriverWait                     | FluentWait                         |
|----------------------|---------------------------------|---------------------------------|---------------------------------|---------------------------------|
| **Type**            | Static Wait (Java-based)         | Global Implicit Wait (Selenium) | Explicit Wait (Selenium)        | Explicit Wait (Advanced)        |
| **Usage Scope**      | Applies globally but blindly    | Applies globally to all elements | Applied per element and condition | Applied per element and condition |
| **Condition Support** | No conditions checked          | Only checks presence of the element in DOM | Supports predefined conditions (`ExpectedConditions`) | Supports custom conditions via functions |
| **Flexibility**      | Least flexible (fixed delay)    | Somewhat flexible (applies globally) | Moderately flexible (element-specific) | Most flexible (polling + exception handling) |
| **Polling Mechanism**| No polling, fixed delay        | No polling, waits till timeout | No polling, waits till timeout | Polling frequency can be set manually |
| **Exception Handling** | No handling, can cause `InterruptedException` | No exception customization | No exception customization | Can ignore exceptions dynamically (`ignoring()`) |
| **Ideal Use Cases**  | Debugging or very simple delays | Handling minor page load delays | Waiting for specific element states (visibility, clickability) | Handling AJAX-heavy pages or dynamic content loading |
| **Drawbacks**        | Causes unnecessary delays, not efficient | Can cause unnecessary wait times if elements appear faster | Needs correct conditions, deprecated in older Selenium versions | More complex implementation, requires custom functions |
| **Syntax Example**   | `Thread.sleep(5000);` (waits 5 sec) | `driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));` | `wait.until(ExpectedConditions.elementToBeClickable(By.id("button")));` | `fluentWait.until(driver -> driver.findElement(By.id("example")));` |