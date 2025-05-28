# Exception Handling in Selenium

![Excepton Flowchart](/Checked-and-Unchecked-exceptions-in-java.jpg)


## Checked vs Unchecked Exceptions

### Checked Exceptions
- Checked exceptions are checked at compile time.
- Java forces you to handle these exceptions using `try-catch` or `throws` declaration.
- They represent recoverable errors — situations where the application can reasonably recover.

#### Examples:
- `IOException`
- `SQLException`
- `FileNotFoundException`
- `InterruptedException`

### Unchecked Exceptions
- Unchecked exceptions are not checked at compile time.
- They extend `RuntimeException`.
- Java doesn’t force you to catch or declare them.
- They usually represent programming bugs or unexpected issues (like null references or illegal arguments).

#### Examples:
- `NullPointerException`
- `IllegalArgumentException`
- `ArrayIndexOutOfBoundsException`
- `ArithmeticException`

## Application in Selenium
Most exceptions in Selenium WebDriver are unchecked — they extend `RuntimeException`.  
You are not required to catch them, but you should handle them to avoid test failures.

### Common Unchecked Exceptions in Selenium:

| Exception Name | Description |
|---------------|-------------|
| `NoSuchElementException` | When WebDriver cannot find an element on the page |
| `TimeoutException` | When an explicit wait times out |
| `StaleElementReferenceException` | When the element is no longer attached to the DOM |
| `ElementNotInteractableException` | When an element is present but cannot be interacted with |
| `WebDriverException` | Base class for all WebDriver-related exceptions |

