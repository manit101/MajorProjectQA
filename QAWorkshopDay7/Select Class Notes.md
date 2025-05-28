
# Select Class in Selenium

- The **Select** class in Selenium is used to interact with `<select>` HTML tags (dropdown menus). It provides methods to select and deselect options.

- Use **Select** only when the element is defined using the `<select>` tag.

```html
<select id="dropdown">
  <option value="1">Option 1</option>
  <option value="2">Option 2</option>
</select>
```

## Select Class element’s syntax

```java
WebElement dropdown = driver.findElement(By.id("dropdown"));
Select select = new Select(dropdown);
```

## Methods of Select Class

### 1. Selecting options
- `selectByIndex(int index)` – selects by position (starts from 0)
- `selectByValue(String value)` – selects the `<option>` with the `value="..."` attribute
- `selectByVisibleText(String text)` – selects based on what is visible in the dropdown

**Example:**
```java
select.selectByIndex(1);
select.selectByValue("2");
select.selectByVisibleText("Option 1");
```

### 2. Getting selected options
- `getFirstSelectedOption()` – returns the first selected option (used in single-select)
- `getAllSelectedOptions()` – returns a list of all selected options (used in multi-select)

**Example:**
```java
WebElement selected = select.getFirstSelectedOption();
List<WebElement> allSelected = select.getAllSelectedOptions();
```

### 3. Getting all options
- `getOptions()` – returns all `<option>` elements in the dropdown