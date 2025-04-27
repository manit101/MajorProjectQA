# XPath Text Handling - Complete Notes

---

## 1. Using `.` (Dot)

**Syntax:**  
```xpath
//tagname[. = "text"]
```

**Usage:**  
- Finds an element where the **complete visible text**, including from **nested child tags**, matches exactly.

**Example:**
```html
<div>
  <p>text</p>
</div>
```
XPath:  
```xpath
//div[. = "text"]
```

**Key Point:**  
- Works even when **text is inside child elements**.

---

## 2. Using `text()` Function

**Syntax:**  
```xpath
//tagname[text() = "text"]
```

**Usage:**  
- Finds an element where the **direct text node** (no nested tags) matches exactly.

**Example:**
```html
<div>text</div>
```
XPath:  
```xpath
//div[text() = "text"]
```

**Key Point:**  
- Only works when **text is directly inside** the element.
- Fails if text is wrapped inside another tag.

---

## 3. Using `contains()`

**Syntax:**  
```xpath
//tagname[contains(text(), "partial_text")]
//tagname[contains(@attribute, "partial_value")]
```

**Usage:**  
- Used when you need to **match a part of the string** in **text** or **attributes**.
- Useful when you don't know the full text or attribute value, or when they are dynamic.

**Examples:**

- **Partial Text Match**
```html
<button>Get Here</button>
```
XPath:  
```xpath
//button[contains(text(),'ere')]
```
- Checks if the button's **text** contains `"ere"`.

- **Partial Attribute Match**
```html
<button class="btn-primary large-btn">Get Here</button>
```
XPath:  
```xpath
//button[contains(@class,'large')]
```
- Checks if the button's **class** contains `"large"`.

**Key Points:**  
- Can search inside **text** or **any attribute** like `class`, `id`, `name`, etc.
- Very powerful for finding dynamic elements.

---

## 4. Using `starts-with()`

**Syntax:**  
```xpath
//tagname[starts-with(text(), "starting_text")]
//tagname[starts-with(@attribute, "starting_value")]
```

**Usage:**  
- Used when you want to check if the **text** or **attribute** **starts with** a specific string.

**Examples:**

- **Start of Text Match**
```html
<button>Get Here</button>
```
XPath:  
```xpath
//button[starts-with(text(),'Get')]
```
- Matches because the text starts with `"Get"`.

- **Start of Attribute Match**
```html
<button id="submitButtonMain">Submit</button>
```
XPath:  
```xpath
//button[starts-with(@id,'submit')]
```
- Matches because the `id` starts with `"submit"`.

**Key Points:**  
- Very useful when beginning part is constant but rest is dynamic.

---

## Quick Summary Table

| XPath Syntax                              | Works When                                 | Example                           |
|:------------------------------------------|:-------------------------------------------|:----------------------------------|
| `//tagname[. = "text"]`                   | Text inside nested elements                | `<div><p>text</p></div>`           |
| `//tagname[text() = "text"]`               | Text must be directly inside tag           | `<div>text</div>`                 |
| `//tagname[contains(text(),"part")]`       | Text partially matches                     | `<button>Get Here</button>`       |
| `//tagname[contains(@class,"partial")]`    | Attribute partially matches                | `<button class="large-btn">`      |
| `//tagname[starts-with(text(),"str")]`     | Text starts with certain letters           | `<button>Get Here</button>`       |
| `//tagname[starts-with(@id,"prefix")]`     | Attribute starts with certain value        | `<button id="submitMain">`        |

---

## Bonus Tips 💡

- `.` (dot) → Considers **all text inside**, including nested elements.
- `text()` → Considers **only direct text node**, ignores children.
- `contains(text(),"part")` → Match if **any part of text** matches.
- `contains(@attr,"part")` → Match if **any part of attribute value** matches.
- `starts-with(text(),"start")` → Match if **text starts** with specific letters.
- `starts-with(@attr,"start")` → Match if **attribute value starts** with specific letters.

---

# Example Scenarios

| Scenario                                     | Best XPath                                |
|:---------------------------------------------|:------------------------------------------|
| Text inside nested tags                      | Use `.`                                   |
| Text directly inside element                 | Use `text()`                              |
| Need to find by partial text                 | Use `contains(text(), "partial")`         |
| Need to find by partial attribute            | Use `contains(@class, "partial")`         |
| Need to find by starting text                | Use `starts-with(text(), "start")`         |
| Need to find by starting attribute           | Use `starts-with(@id, "prefix")`           |

---

# Final Note 📚

If unsure whether text has child elements or attributes are dynamic, prefer using:
```xpath
//tagname[contains(., "partial text")]
```
or
```xpath
//tagname[contains(@class, "common_part")]
```
to be safe for **both text and attributes**!

---

# Basic XPath Syntax

| Syntax                                | Description                         | Example                           |
|:--------------------------------------|:------------------------------------|:----------------------------------|
| `//tagname`                           | Selects all elements with the tag name | `//section`                    |
| `//tag[@attribute='value']`            | Element with a specific attribute value | `//input[@name='email']`        |
| `//tag[text()='value']`                | Element with exact text             | `//button[text()='Login']`         |
| `//tag[contains(text(),'value')]`      | Element containing partial text     | `//h1[contains(text(),'Welcome')]` |
| `//tag[contains(@attr,'value')]`       | Attribute containing partial value  | `//img[contains(@src, 'logo')]`    |
| `//tag[starts-with(@attr,'val')]`      | Attribute starts with a specific value | `//div[starts-with(@id, 'user-')]` |

---