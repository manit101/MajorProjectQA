# Select Class (Multiple Select) in Selenium

In Selenium, the **Select** class is used to interact with `<select>` dropdown elements. To deselect an option in a `<select>` element (typically a multi-select dropdown), you can use methods like `deselectByIndex()`, `deselectByValue()`, `deselectByVisibleText()`, or `deselectAll()`. These methods only work if the `<select>` element has the `multiple` attribute, allowing multiple selections.

## Deselect Methods in Select Class

- `deselectByIndex(int index)`: Deselects an option at the specified index (0-based).
- `deselectByValue(String value)`: Deselects an option with the specified `value` attribute.
- `deselectByVisibleText(String text)`: Deselects an option with the specified visible text.
- `deselectAll()`: Deselects all selected options in a multi-select dropdown.

---

## isSelected Method

### Description:
- A method in Selenium’s `WebElement` interface that checks if a web element is selected.
- Returns a boolean:
  - `true` if the element is selected (e.g., a checkbox is checked, a radio button is selected, or an option in a dropdown is selected).
  - `false` if the element is not selected.

### When It Works:
- Applicable to input elements like:
  - **Checkboxes** (`<input type="checkbox">`): Checks if the checkbox is checked.
  - **Radio buttons** (`<input type="radio">`): Checks if the radio button is selected.
  - **Options in a `<select>` dropdown** (`<option>`): Checks if an option is selected.
- Does not apply to elements like buttons, links, or text fields, as they cannot be in a "selected" state.
- The element must be present in the DOM and accessible.

### Use Case:
- Verify the state of a checkbox or radio button before performing an action (e.g., clicking to toggle).
- Ensure a dropdown option is selected as expected.

### Notes:
- Always check if the element is enabled (`isEnabled()`) before calling `isSelected()` to avoid interacting with disabled elements.
- For multi-select dropdowns, use the **Select class’s** `getAllSelectedOptions()` to check all selected options.
- If called on an unsupported element (e.g., a `<div>`), it typically returns `false` without an error.
- Be cautious with dynamic UIs where selection states change asynchronously; use **explicit waits** (e.g., `WebDriverWait`).

**Example with a radio button:**
```java
WebElement element = driver.findElement(By.id("elementId"));
boolean isChecked = element.isSelected();
```

---

## isEnabled Method

### Description:
- In Selenium, the `isEnabled()` method is used to check whether a web element (e.g., button, input field, checkbox, etc.) is enabled and interactable.
- Returns a boolean value: `true` if the element is enabled, `false` if it is disabled (e.g., has a `disabled` attribute in HTML).

### Usage:
- Applicable Elements: Any web element that can be enabled or disabled, such as `<input>`, `<button>`, `<select>`, etc.

### Syntax:
```java
WebElement element = driver.findElement(By.id("elementId"));
boolean isElementEnabled = element.isEnabled();
```