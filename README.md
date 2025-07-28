# Shamir Secret Recovery Assignment

## Overview

This Java project reconstructs the secret (constant term) of a polynomial using a simplified version of Shamir's Secret Sharing.
Given encoded shares in JSON format, it decodes them and uses Lagrange interpolation to recover the original secret.

---

## 📁 Folder Structure

```
Main/
├── src/
│   └── Problem.java         # Main Java source file
├── testcase1.json           # Sample test input (JSON)
├── testcase2.json           # Original/main test input (JSON)
└── untitled.iml             # IntelliJ module/project file
```

---

## 🚀 How to Compile and Run

### 1. **Download org.json Library**

* Download [json-20230227.jar](https://repo1.maven.org/maven2/org/json/json/20230227/json-20230227.jar)
* Place it in the `Main/src/` directory.

---

### 2. **Open Terminal in `Main/src/`**

```sh
cd Main/src
```

---

### 3. **Compile the Code**

#### **Windows:**

```sh
javac -cp ".;json-20230227.jar" Problem.java
```

#### **Mac/Linux:**

```sh
javac -cp ".:json-20230227.jar" Problem.java
```

---

### 4. **Run the Code**

#### **Windows:**

```sh
java -cp ".;json-20230227.jar" Problem
```

#### **Mac/Linux:**

```sh
java -cp ".:json-20230227.jar" Problem
```

---

### **NOTE:**

Since the test case files are in the parent directory (`Main/`),
your code should read them as:

```java
new FileReader("../testcase1.json")
new FileReader("../testcase2.json")
```

**(If not already, update your file paths in Problem.java to use `"../testcase1.json"` and `"../testcase2.json"`.)**

---

## 📝 About the Code

* **JSON Parsing:** Uses `org.json` (JSON-java) library for reading JSON.
* **Computation:** All number decoding and Lagrange interpolation are implemented manually.
* **Input:** Reads `../testcase1.json` and `../testcase2.json` from the parent directory.

---

## 📚 Example Input (testcase1.json)

```json
{
  "keys": { "n": 4, "k": 3 },
  "1": { "base": "10", "value": "4" },
  "2": { "base": "2", "value": "111" },
  "3": { "base": "10", "value": "12" },
  "6": { "base": "4", "value": "213" }
}
```

---

## 🖨️ Sample Output

```
Secret for Test Case 1: 3
Secret for Test Case 2: 79836264049851
```

---

## 💡 Notes

* Place the JSON files (`testcase1.json`, `testcase2.json`) in the `Main/` directory (one level above `src/`).
* Make sure your code reads them as `../testcase1.json` and `../testcase2.json`.
* Only `org.json` is used for parsing; all recovery logic is hand-coded.
