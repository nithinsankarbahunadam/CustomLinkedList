package com.linkedlist;

public class CustomLinkedList{

    private Node head;
    private Node tail;

    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;

        if(this.tail == null) {
            this.tail = head;
        }
        size++;
    }

    public void insertLast(int data) {

        if(this.head == null) {
            insertFirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int index, int data) {
        if(index == 0){
            insertFirst(data);
            return;
        }
        if(index == size){
            insertLast(data);
            return;
        }

        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }

        Node newNode = new Node(data,temp.next);
        temp.next = newNode;
        size++;
    }

    public int deleteFirst() {
        int val=head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        if(size <= 1){
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;

    }

    public Node get(int index) {
        Node node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    public int deleteAt(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }

        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node find(int data){
        Node node = head;
        while(node != null){
            if(node.value == data){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public int getSize() {
        return size;
    }

    private static class Node{
        private final int value;
        private Node next;

        public Node(int value){

            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
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

}
