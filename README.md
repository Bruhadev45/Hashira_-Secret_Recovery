

# Shamir Secret Recovery Assignment

## Overview

This project recovers the constant term (`c`) of a polynomial using a simplified version of Shamir's Secret Sharing algorithm.
Given encoded shares in JSON format, the program decodes them and uses Lagrange interpolation to reconstruct the secret.

---

## 📂 Project Structure

```
Main/
└── src/
    ├── Problem.java
    ├── testcase1.json
    ├── testcase2.json
    └── untitled.iml
```

* `Problem.java` - Main Java source code.
* `testcase1.json` - Sample test input.
* `testcase2.json` - Original/main test input.
* `untitled.iml` - IntelliJ module file (can be ignored).
* `.gitignore` - Ignores IDE/config files.

---

## 🚀 How to Run

1. **Download and add org.json library**
   [Download json-20230227.jar](https://repo1.maven.org/maven2/org/json/json/20230227/json-20230227.jar)
   Place it in the `Main/src` directory (or any location you prefer).

2. **Open terminal in `Main/src` folder**

3. **Compile:**

   * **Windows:**

     ```sh
     javac -cp ".;json-20230227.jar" Problem.java
     ```
   * **Mac/Linux:**

     ```sh
     javac -cp ".:json-20230227.jar" Problem.java
     ```

4. **Run:**

   * **Windows:**

     ```sh
     java -cp ".;json-20230227.jar" Problem
     ```
   * **Mac/Linux:**

     ```sh
     java -cp ".:json-20230227.jar" Problem
     ```

---

## 📥 Input Format

Each testcase JSON file contains:

* `keys` (object) – contains `n` (number of shares), `k` (threshold)
* Share objects: Each with `base` (number base), `value` (string representation in that base). The key of each object is the share index (as a string).

**Example (`testcase1.json`):**

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

## 🧮 Output

The program prints the recovered secret for both test cases, for example:

```
Secret for Test Case 1: 3
Secret for Test Case 2: 79836264049851
```

---

## ⚡️ Notes

* Only the `org.json` library is used for parsing; all decoding and interpolation is implemented manually.
* Tested on Java 8 and above.

---

## 👨‍💻 Author

**Bruhadev45**
