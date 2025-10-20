# 🧩 Custom Linked List Implementations in Java

This repository contains **clean, well-structured implementations** of three types of linked lists written in **Java** — each demonstrating different data structure behaviors, traversal patterns, and internal node management.

---

## 📘 Project Overview

This project is designed to help learners and interview candidates understand **Linked List internals** — from basic singly linked structures to **doubly** and **circular doubly linked lists** — including insertion, deletion, and traversal logic.

Each implementation comes with:
- Full CRUD operations (Insert, Delete, Find)
- Index-based operations
- Safe boundary checks
- Forward and reverse traversal
- Clear console outputs for step-by-step understanding

---

## 🏗️ Implementations Included

### 1️⃣ `CustomLinkedList` (Singly Linked List)
A simple **singly linked list** implementation with operations such as:
- `insertFirst(int data)`
- `insertLast(int data)`
- `insert(int index, int data)`
- `deleteFirst()`, `deleteLast()`, `deleteAt(int index)`
- `find(int data)`
- `display()`

**Example Output**
```
26 -> 35 -> 74 -> 97 -> 20 -> 25 -> End
Deleted first: 26
Deleted last: 25
Deleted at index 3: 97
```

---

### 2️⃣ `CustomDoubleLinkedList` (Doubly Linked List)
A **doubly linked list** with both forward and reverse traversal support.

**Key Features**
- Bi-directional traversal (`displayForward()` and `displayReverse()`)
- Fast access from head or tail depending on index
- Constant-time insertion/removal at both ends

**Example Usage**
```java
listD.insertFirst(26);
listD.insertLast(25);
listD.insert(4, 20);
listD.displayForward();
listD.displayReverse();
```

---

### 3️⃣ `CustomCircularLinkedList` (Circular Doubly Linked List)
A **circular doubly linked list** where:
- The `tail.next` always points to `head`
- The `head.prev` always points to `tail`

**Core Operations**
- `insertFirst(int data)`
- `insertLast(int data)`
- `insert(int index, int data)`
- `deleteFirst()`, `deleteLast()`, `deleteAt(int index)`
- `displayForward()`, `displayReverse()`

**Example Output**
```
Forward:
12 -> 15 -> 8 -> 20 -> (back to head)
Reverse:
20 -> 8 -> 15 -> 12 -> (back to tail)
deleteAt(1) => 15
deleteFirst() => 12
deleteLast() => 20
8 -> (back to head)
```

---

## 🧠 Concepts Covered
- Node-based data structure design
- Memory references (`next`, `prev` pointers)
- Circular reference handling
- Safe index validation
- Object-oriented programming principles in Java

---

## 🚀 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/nithinsankarbahunadam/CustomLinkedLists.git
   cd CustomLinkedLists
   ```

2. Open the project in any Java IDE (IntelliJ, VS Code, Eclipse)

3. Run the `Main.java` file inside the `com.linkedlist` package:
   ```bash
   javac com/linkedlist/Main.java
   java com.linkedlist.Main
   ```

4. Observe the console output for linked list operations.

---

## 🧾 File Structure

```
📦 src
 └── com
     └── linkedlist
         ├── CustomLinkedList.java
         ├── CustomDoubleLinkedList.java
         ├── CustomCircularLinkedList.java
         └── Main.java
```

---

## 🧰 Technologies Used
- **Language:** Java 17+
- **IDE:** IntelliJ IDEA / VS Code
- **Concepts:** OOP, Data Structures, Generics, Control Flow

---

## 🧑‍💻 Author
**Nithin Sankar Bahunadam**  
🎓 M.S. in Big Data Analytics & IT | University of Central Missouri  
💡 Passionate about building efficient algorithms and backend systems using Java, Spring Boot, and Python.

📬 **Connect with me:**  
[LinkedIn](https://www.linkedin.com/sankarbahunadam) • [GitHub](https://github.com/nithinsankarbahunadam)

---

## ⭐ If you found this helpful...
Give this repo a **star ⭐** and share it with others learning Java data structures!
