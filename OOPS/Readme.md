## Object-Oriented Programming (OOP) — Real-World Java Applications

This repository is a **practical implementation of Object-Oriented Programming (OOP) concepts in Java**, built to understand how OOP works in **real-world application design** rather than isolated examples.

The project is organized into **two complete real-life systems** — a **Food Delivery Application** and a **Social Media Platform** — each carefully structured to demonstrate how OOP principles are applied in production-style codebases.

Every class is **intentionally designed and commented** to explain **which OOP concept is being used and why**, making this repository ideal for learning, revision, and interview preparation.

---

## 📁 Project Structure

### 🍔 Food Delivery Application (`foodapp/`)

Models a real-world food delivery system with clear object relationships and responsibilities.

**Key Highlights:**

* **Encapsulation:** User, Order, Restaurant, MenuItem classes with controlled access to data
* **Inheritance & Polymorphism:**

  * `MenuItem → VegDish / NonVegDish`
* **Abstraction & Interfaces:**

  * `Payable`, `Rateable` interfaces to define behavior contracts
* **Composition & Aggregation:**

  * Orders composed of menu items
  * Users associated with orders and delivery partners
* **Exception Handling:**

  * Custom exceptions like `PaymentFailedException`, `RestaurantClosedException`
* **Static & Lifecycle Concepts:**

  * Centralized app control via `FoodDeliveryApp`
* **Execution:**

  * `FoodDeliveryDemo.java` demonstrates the system flow

---

### 📱 Social Media Platform (`socialmedia/`)

Simulates a simplified social media platform focusing on extensibility and behavioral abstraction.

**Key Highlights:**

* **Abstraction & Interfaces:**

  * `Likeable`, `Commentable` for post interactions
* **Inheritance & Polymorphism:**

  * `Post → TextPost / PhotoPost`
* **Encapsulation:**

  * User and Post data protected via access modifiers
* **Custom Exceptions:**

  * `TooManyPostsException` to enforce platform constraints
* **Modular Design:**

  * Separation into `app`, `post`, `user`, and `demo` packages
* **Execution:**

  * `SocialMediaDemo.java` demonstrates runtime polymorphism and interactions

---

## 🧠 OOP Concepts Covered

✔ Encapsulation
✔ Abstraction (Abstract classes & Interfaces)
✔ Inheritance
✔ Polymorphism (Runtime & Compile-time)
✔ Association, Aggregation & Composition
✔ Access Modifiers
✔ Constructors & Object Lifecycle
✔ Static Members
✔ Custom Exception Handling

Each concept is **explicitly documented within the code using comments** to explain its real-world relevance.

---

## 🎯 Purpose of This Repository

This repository was created to:

* Understand how **OOP concepts map to real application design**
* Practice structuring **clean, modular, and scalable code**
* Serve as a **reference for interviews and revision**
* Act as a **learning playground** by modifying access levels, inheritance, and abstractions

---

## 🚀 How to Run

```bash
git clone https://github.com/itisar-345/Notes.git
cd Notes/OOPS
```

Run:

* `FoodDeliveryDemo.java` for the food delivery system
* `SocialMediaDemo.java` for the social media platform

---

## 📌 Who This Is For

* Students learning OOP
* Developers revising core OOP concepts
* Interview preparation for Java / OOP roles
* Anyone wanting to see **OOP used the right way in real systems**

---

Made with ❤️ by **Ritisa Behera**  
⭐ Star the repo & follow me on GitHub: https://github.com/itisar-345
