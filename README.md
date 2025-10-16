# 🧩 CustomLinkedList (Java)

This project implements a **singly linked list** data structure in Java from scratch — without using Java’s built-in collection classes. It demonstrates how nodes are linked using references, and provides hands-on understanding of **data structures**, **OOP concepts**, and **pointer manipulation** in Java.

---

## 🚀 Features

### 🔹 Insert Operations
- `insertFirst(int data)` — Adds a new node at the beginning of the list  
- `insertLast(int data)` — Appends a new node at the end of the list  
- `insert(int index, int data)` — Inserts a node at a specific index  

### 🔹 Delete Operations
- `deleteFirst()` — Removes and returns the first node  
- `deleteLast()` — Removes and returns the last node  
- `deleteAt(int index)` — Removes a node at the given index  

### 🔹 Search & Access
- `find(int data)` — Finds a node containing the specified value  
- `get(int index)` — Returns a node at the specified index  

### 🔹 Utility
- `display()` — Displays all elements in the list in a readable format  

---

## 🧠 Concepts Demonstrated

- Node-based data storage using inner classes  
- Dynamic resizing without arrays  
- Manual head and tail pointer management  
- Traversal using `while` and `for` loops  
- Method overloading and encapsulation  

---

## 🏗️ Class Structure

com.linkedlist
└── CustomLinkedList.java
├── insertFirst(), insertLast(), insert()
├── deleteFirst(), deleteLast(), deleteAt()
├── find(), get(), display()
└── static class Node { int value; Node next; }
