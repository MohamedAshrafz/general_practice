package org.example;

public class InsertNodeAtSpecificPosition {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {

        if (position == 0){
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.next = llist;
            return newNode;
        }
        // Write your code here
        SinglyLinkedListNode prePositionNode = llist;
        for (int i = 0; i < position - 1; i++) {
            prePositionNode = prePositionNode.next;
        }
        SinglyLinkedListNode tempNextNode = prePositionNode.next;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        prePositionNode.next = newNode;
        newNode.next = tempNextNode;

        return llist;
    }

}
