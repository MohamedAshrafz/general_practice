package org.example;

import java.util.Scanner;

public class InsertNodeAtTail {
    public static void main(String[] args) {

        SinglyLinkedListNode head = new SinglyLinkedListNode(5);

        SinglyLinkedListNode chainingNode = head;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(sc.nextInt());
            chainingNode.next = node;
            chainingNode = node;
        }

        head = insertNodeAtTail(head, 10);

        chainingNode = head;
        while (chainingNode != null) {
            System.out.println(chainingNode.data);
            chainingNode = chainingNode.next;
        }
    }

    /**
     * using recursion
     */
//    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
//        if (head == null) {
//            return new SinglyLinkedListNode(data);
//        }
//        if (head.next == null) {
//            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
//            head.next = newNode;
//            return head;
//        }
//        insertNodeAtTail(head.next, data);
//        return head;
//    }

    /**
     * using while loop
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if(head == null){
            return new SinglyLinkedListNode(data);
        }
        SinglyLinkedListNode chainingNode = head;
        while (chainingNode.next != null) {
            chainingNode = chainingNode.next;
        }
        chainingNode.next = new SinglyLinkedListNode(data);

        return head;
    }
}
