package com.linkedlist;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        CustomLinkedList list = new CustomLinkedList();
        list.insertFirst(97);
        list.insertFirst(74);
        list.insertFirst(35);
        list.insertFirst(26);
        list.insertLast(25);

        list.insert(4,20);
        list.display();

        list.insert(4,55);
        list.display();

        int deletedFirstVal = list.deleteFirst();
        System.out.println(deletedFirstVal);
        list.display();

        int deletedLastVal = list.deleteLast();
        System.out.println(deletedLastVal);
        list.display();

        int deletedAtVal = list.deleteAt(3);
        System.out.println(deletedAtVal);
        list.display();

        System.out.println("Doubly Linked List");


        CustomDoubleLinkedList listD = new CustomDoubleLinkedList();
        listD.insertFirst(97);
        listD.insertFirst(74);
        listD.insertFirst(35);
        listD.insertFirst(26);
        listD.insertLast(25);

        listD.insert(4, 20); // 0-based index
        listD.displayForward();   // 26 -> 35 -> 74 -> 97 -> 20 -> 25 -> End
        listD.displayReverse();   // 25 -> 20 -> 97 -> 74 -> 35 -> 26 -> Start

        System.out.println("Deleted first: " + listD.deleteFirst()); // 26
        System.out.println("Deleted last: " + listD.deleteLast());   // 25
        System.out.println("Deleted at 2: " + listD.deleteAt(2));    // removes 97 (after prior deletions)
        listD.displayForward();
        System.out.println("Size: " + listD.size());



    }
}