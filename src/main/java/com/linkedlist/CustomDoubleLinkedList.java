package com.linkedlist;

public class CustomDoubleLinkedList {

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
     * Insert at the beginning (O(1))
     */
    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        } else {
            // list was empty, tail also becomes this node
            tail = node;
        }
        head = node;
        size++;
    }

    /**
     * Insert at the end (O(1))
     */
    public void insertLast(int data) {
        if (head == null) {
            insertFirst(data);
            return;
        }
        Node node = new Node(data);
        node.prev = tail;
        node.next = null;

        tail.next = node;
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

        Node nextNode = getNode(index);     // node currently at 'index'
        Node prevNode = nextNode.prev;      // node at 'index-1'
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
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            // list became empty
            tail = null;
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
        tail.next = null;

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

        // Help GC (optional)
        target.next = null;
        target.prev = null;

        size--;
        return val;
    }

    /**
     * Return first node with matching data, or null if not found (O(n))
     */
    public Node find(int data) {
        Node cur = head;
        while (cur != null) {
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
     * Print from head to tail
     */
    public void displayForward() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("End");
    }

    /**
     * Print from tail to head
     */
    public void displayReverse() {
        Node node = tail;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.prev;
        }
        System.out.println("Start");
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

    private static class Node {
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

