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
        list.insertFirst(17);
        list.insertLast(20);
        list.insert(4,55);

        int deletedFirstVal = list.deleteFirst();
        System.out.println(deletedFirstVal);

        int deletedLastVal = list.deleteLast();
        System.out.println(deletedLastVal);

        int deletedAtVal = list.deleteAt(3);
        System.out.println(deletedAtVal);

        list.display();


    }
}