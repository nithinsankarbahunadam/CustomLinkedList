package com.linkedlist;


/**
 * Custom circular doubly-linked list of ints.
 * Invariants:
 *  - if size == 0: head == tail == null
 *  - if size == 1: head == tail and head.next == head and head.prev == head
 *  - if size > 1: tail.next == head and head.prev == tail
 */
public class CustomCircularLinkedList {

    private Node head;
    private Node tail;
    private int size;

    // ===== Public API =====

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Insert at beginning (O(1))
     */
    public void insertFirst(int data) {
        Node node = new Node(data);

        if (head == null) {
            // new single-node circular list
            node.next = node;
            node.prev = node;
            head = tail = node;
        } else {
            // place node before current head
            node.next = head;
            node.prev = tail;

            head.prev = node;
            tail.next = node;

            head = node;
        }
        size++;
    }

    /**
     * Insert at end (O(1))
     */
    public void insertLast(int data) {
        if (head == null) {
            insertFirst(data);
            return;
        }
        Node node = new Node(data);

        node.prev = tail;
        node.next = head;

        tail.next = node;
        head.prev = node;
        tail = node;

        size++;
    }

    /**
     * Insert at index (0..size) (O(min(index, size-index)))
     */
    public void insert(int index, int data) {
        checkPositionIndex(index); // allow index == size

        if (index == 0) {
            insertFirst(data);
            return;
        }
        if (index == size) {
            insertLast(data);
            return;
        }

        Node nextNode = getNode(index); // node currently at index
        Node prevNode = nextNode.prev;
        Node newNode = new Node(data);

        // Wire: prevNode <-> newNode <-> nextNode
        newNode.prev = prevNode;
        newNode.next = nextNode;

        prevNode.next = newNode;
        nextNode.prev = newNode;

        size++;
    }

    /**
     * Delete first element and return its value (O(1))
     */
    public int deleteFirst() {
        checkNotEmpty();

        int val = head.data;

        if (size == 1) {
            // becomes empty
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
        return val;
    }

    /**
     * Delete last element and return its value (O(1))
     */
    public int deleteLast() {
        checkNotEmpty();

        if (size == 1) {
            return deleteFirst();
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;

        size--;
        return val;
    }

    /**
     * Delete at index (0..size-1) and return its value (O(min(index, size-index)))
     */
    public int deleteAt(int index) {
        checkElementIndex(index);

        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node target = getNode(index);
        int val = target.data;

        Node prevNode = target.prev;
        Node nextNode = target.next;

        // Unlink target
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        // Help GC
        target.next = null;
        target.prev = null;

        size--;
        return val;
    }

    /**
     * Return first node with matching data, or null if not found (O(n))
     */
    public Node find(int data) {
        if (head == null) return null;

        Node cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.data == data) return cur;
            cur = cur.next;
        }
        return null;
    }

    /**
     * Get node at index (0..size-1) (O(min(index, size-index)))
     */
    public Node get(int index) {
        checkElementIndex(index);
        return getNode(index);
    }

    /**
     * Print from head to tail (iterates exactly size elements)
     */
    public void displayForward() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        Node node = head;
        for (int i = 0; i < size; i++) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("(back to head)");
    }

    /**
     * Print from tail to head (iterates exactly size elements)
     */
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Empty");
            return;
        }
        Node node = tail;
        for (int i = 0; i < size; i++) {
            System.out.print(node.data + " -> ");
            node = node.prev;
        }
        System.out.println("(back to tail)");
    }

    // ===== Internal helpers =====

    private void checkNotEmpty() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }

    /**
     * Returns node at index (0..size-1).
     * Uses bidirectional traversal for efficiency.
     */
    private Node getNode(int index) {
        // Walk from closer side
        if (index < (size / 2)) {
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        } else {
            Node cur = tail;
            for (int i = size - 1; i > index; i--) {
                cur = cur.prev;
            }
            return cur;
        }
    }

    // ===== Node type =====

    public static class Node {
        int data;
        Node next;
        Node prev;

        private Node(int data) {
            this.data = data;
        }

        private Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}