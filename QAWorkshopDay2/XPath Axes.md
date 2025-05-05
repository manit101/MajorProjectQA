# The XML Example Document

We will use the following XML document in the examples below:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<bookstore>

  <book>
    <title lang="en">Harry Potter</title>
    <price>29.99</price>
  </book>

  <book>
    <title lang="en">Learning XML</title>
    <price>39.95</price>
  </book>

</bookstore>
```
# XPath Axes

An axis represents a relationship to the context (current) node, and is used to locate nodes relative to that node on the tree.

| Axis Name             | Result |
|:----------------------|:-------|
| `ancestor`             | Selects all ancestors (parent, grandparent, etc.) of the current node |
| `ancestor-or-self`     | Selects all ancestors (parent, grandparent, etc.) of the current node and the current node itself |
| `attribute`            | Selects all attributes of the current node |
| `child`                | Selects all children of the current node |
| `descendant`           | Selects all descendants (children, grandchildren, etc.) of the current node |
| `descendant-or-self`   | Selects all descendants (children, grandchildren, etc.) of the current node and the current node itself |
| `following`            | Selects everything in the document after the closing tag of the current node |
| `following-sibling`    | Selects all siblings after the current node |
| `namespace`            | Selects all namespace nodes of the current node |
| `parent`               | Selects the parent of the current node |
| `preceding`            | Selects all nodes that appear before the current node in the document, except ancestors, attribute nodes, and namespace nodes |
| `preceding-sibling`    | Selects all siblings before the current node |
| `self`                 | Selects the current node |

---

# Location Path Expression

A location path can be **absolute** or **relative**.

- **Absolute Location Path**: starts with a slash (`/`)  
  Example:  
  ```
  /step/step/...
  ```

- **Relative Location Path**: does **not** start with a slash  
  Example:  
  ```
  step/step/...
  ```

Each step is evaluated against the nodes in the current node-set.

A step consists of:
- An **axis** (defines the tree-relationship between the selected nodes and the current node)
- A **node-test** (identifies a node within an axis)
- **Zero or more predicates** (to further refine the selected node-set)

The syntax for a location step is:
```
axisname::nodetest[predicate]
```
# XPath Axis Examples

| Axis | Description | Example |
|:-----|:------------|:--------|
| `child::` | Selects all child elements of the current node | `//ul/child::li` |
| `parent::` | Selects the parent of the current node | `//span/parent::label` |
| `following::` | All nodes after the current node (in document order) | `//h3/following::div` |
| `preceding::` | All nodes before the current node | `//button[@id='submit']/preceding::input` |
| `following-sibling::` | All siblings after the current node | `//label[@for='email']/following-sibling::input` |
| `preceding-sibling::` | All siblings before the current node | `//input[@id='password']/preceding-sibling::label` |

---

# XPath Examples

| Example                        | Result |
|:--------------------------------|:-------|
| `child::book`                   | Selects all `book` nodes that are children of the current node |
| `attribute::lang`               | Selects the `lang` attribute of the current node |
| `child::*`                      | Selects all element children of the current node |
| `attribute::*`                  | Selects all attributes of the current node |
| `child::text()`                 | Selects all text node children of the current node |
| `child::node()`                 | Selects all children (elements + text) of the current node |
| `descendant::book`              | Selects all `book` descendants of the current node |
| `ancestor::book`                | Selects all `book` ancestors of the current node |
| `ancestor-or-self::book`        | Selects all `book` ancestors of the current node - and the current node itself if it is a `book` |
| `child::*/child::price`         | Selects all `price` grandchildren of the current node |
