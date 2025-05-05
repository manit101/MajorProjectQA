# More on CSS Selectors in Selenium

CSS selectors allow you to efficiently locate elements in a web page using various attribute patterns.

## CSS Selector Operators
### 1. Starts With (`^=`)

- **CSS Syntax:** `div[class^="nav"]`
- **Meaning:** Selects all `<div>` elements where the class **starts with** `"nav"`.
- **Example Match:**
  ```html
  <div class="nav-header">...</div>
  <div class="nav-sprite-v1">...</div>
  ```

### 2. Ends With (`$=`)

- **CSS Syntax:** `img[src$=".png"]`
- **Meaning:** Selects all `<img>` elements where `src` **ends with** `.png`.
- **Example Match:**
  ```html
  <img src="image.png">
  <img src="icon.png">
  ```

### 3. Matches a Whole Word (`~=`)

- **CSS Syntax:** `button[class~=nav-icon]`
- **Meaning:** Selects all `<button>` elements where `"nav-icon"` appears as a separate word in `class`.
- **Example Match:**
  ```html
  <button class="icon nav-icon primary">Click Me</button> <!-- ✅ Matched -->
  <button class="navicon-button">Not Matched</button> <!-- ❌ Not Matched -->
  ```

### 4. Contains (`*=`)

- **CSS Syntax:** `div[class*=nav]`
- **Meaning:** Selects all `<div>` elements where the class **contains** `"nav"` anywhere in the value.
- **Example Match:**
  ```html
  <div class="nav-menu">...</div>  <!-- ✅ Matched -->
  <div class="header-nav">...</div>  <!-- ✅ Matched -->
  ```

### 5. Child Combinator (`>`)

- **CSS Syntax:** `div > button`
- **Meaning:** Selects **direct child** `<button>` elements inside `<div>`.
- **Example Match:**
  ```html
  <div>
      <button>✅ Matched (Direct Child)</button>
      <span><button>❌ Not Matched (Nested inside span)</button></span>
  </div>
  ```

## WebDriver Execution Order in Selenium TestNG
TestNG executes methods in the following order:
```
BeforeMethod -> priority 1 -> AfterMethod -> BeforeMethod -> priority 2 -> AfterMethod -> ...


