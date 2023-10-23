package org.example;

import java.util.Scanner;

public class DeleteNodeAtPosition {

    public static void main(String[] args) {

        SinglyLinkedListNode head = new SinglyLinkedListNode(20);

        SinglyLinkedListNode chainingNode = head;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(sc.nextInt());
            chainingNode.next = node;
            chainingNode = node;
        }

        head = deleteNode(head, 3);

        chainingNode = head;
        while (chainingNode != null) {
            System.out.println(chainingNode.data);
            chainingNode = chainingNode.next;
        }
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {

        if (position == 0){
            SinglyLinkedListNode deletedNode = llist;
            llist = deletedNode.next;
            deletedNode = null;
            return llist;
        }
        // Write your code here
        SinglyLinkedListNode prePositionNode = llist;
        for (int i = 0; i < position - 1; i++) {
            prePositionNode = prePositionNode.next;
        }
        SinglyLinkedListNode deletedNode = prePositionNode.next;
        prePositionNode.next = deletedNode.next;

        return llist;
    }
}
