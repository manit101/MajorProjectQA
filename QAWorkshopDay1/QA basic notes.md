# 🧪 Software Testing Notes

## 📌 What is Software Testing?

**Software Testing** is the process used to check the correctness, completeness, and quality of a developed product or software.

---

## 🚀 Importance of Software Testing in Building a Product

1. Detect and solve bugs  
2. Test edge cases  
3. Quality and performance enhancement  
4. Improve user experience  

---

## 👨‍🔬 Importance of Software Testers in the Industry

1. Time constraints  
2. Remove developer bias  
3. Developers may lack diverse skills  
4. Software testers are specialized  

---

## 🔄 Software Development Life Cycle (SDLC)

1. Requirement analysis and Planning  
2. System design (LLD, HLD, Wireframes)  
3. Implementation and Development  
4. Software Testing (If errors found → return to development)  
5. Deployment and DevOps  
6. Maintenance and Monitoring  

---

## 🔁 Software Testing Life Cycle (STLC)

1. Requirement analysis  
2. Test planning  
3. Test designing  
4. Environment and tools setup  
5. Test execution (Manual and Automated)  
6. Regression testing (return to development if issues found)  

---

## 🧪 Ways of Testing

### 1. Automated Testing
- Time saving  
- Scalable and vast coverage  
- Reduces repetitive efforts  

### 2. Manual Testing
- Human intuition  
- Flexible for various unique test cases  
- Low initial cost  

---

## 🧱 Types of Testing

### A. Functional Testing

Functional testing ensures each feature of an application works as intended under various conditions.

#### 1. Unit Testing
- Tests individual components in isolation.  
- **Done by:** Developers

#### 2. Integration Testing
- Checks if different modules work together.  
- **Done by:** Developers (initially), QA Engineers (later)

#### 3. System Testing
- Verifies the complete system against requirements.  
- **Done by:** QA Engineers

#### 4. Acceptance Testing
- Checks if the system meets business needs and is ready for release.  
- **Done by:** QA Engineers, Stakeholders

#### 5. Sanity Testing
- Quick checks after receiving a new build.  
- **Done by:** Testers / QA Engineers

#### 6. Smoke Testing
- Preliminary check to ensure basic features work.  
- **Done by:** Testers / QA Engineers

#### 7. Alpha Testing
- Early testing in the dev environment.  
- **Done by:** Developers / QA Engineers

#### 8. Beta Testing
- Real-world testing by external users.  
- **Done by:** End Users / Customers

#### 9. Black Box Testing
- Tests functionality without knowing internal code.  
- **Done by:** Testers / QA Engineers

#### 10. White Box Testing
- Tests internal logic and code paths.  
- **Done by:** Developers / Advanced QA Engineers

---

### B. Non-Functional Testing

Non-functional testing focuses on performance, usability, reliability, and other quality standards.

#### 1. Performance Testing
- Evaluates speed, responsiveness, and scalability.  
- **Done by:** Performance Testers / QA Engineers

#### 2. Security Testing
- Ensures protection against unauthorized access and data breaches.  
- **Done by:** Security Testers / Ethical Hackers

#### 3. Usability Testing
- Checks user-friendliness and overall experience.  
- **Done by:** UX Designers / QA Engineers / End Users

#### 4. Compatibility Testing
- Ensures app works across browsers, devices, and OS.  
- **Done by:** QA Engineers

---


# 🔍 XPath (XML Path Language)

**XPath** is a query language used to navigate through elements and attributes in an **XML** or **HTML** document.

It allows you to select nodes or a set of nodes using a **path-like syntax**, similar to navigating folders in a file system.

---

## 📂 Types of XPath

### ✅ Absolute XPath

- **Definition:** A complete path from the root element (`<html>`) to the target element.
- **Starts with:** `/`
- **Example:**  
  `/html/body/div[2]/ul/li[3]/a`
- **Use Case:**  
  - Good for learning  
  - ❌ Not recommended in real scenarios (fragile and easily breakable)
  - ❌ Difficult to maintain in dynamic web applications.

---

### ✅ Relative XPath

- **Definition:** A path that starts from **anywhere** in the document (not necessarily the root).
- **Starts with:** `//`
- **Example:**  
  `//a[@href='/contact']`
- **Use Case:**  
  - ✅ Preferred in automation testing
  - ✅ Resilient to changes in layout or structure. 
  - More **flexible** and **reliable**

---

> 🧪 _Commonly used in web automation tools like Selenium for identifying web elements._

